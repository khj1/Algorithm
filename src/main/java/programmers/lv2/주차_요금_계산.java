package programmers.lv2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class 주차_요금_계산 {

	private final Map<String, Long> minutes = new HashMap<>();
	private int basicTime;
	private int basicFee;
	private int unitTime;
	private int unitFee;

	public int[] solution(int[] fees, String[] records) {
		basicTime = fees[0];
		basicFee = fees[1];
		unitTime = fees[2];
		unitFee = fees[3];

		Records parkingHistory = new Records();

		for (String record : records) {
			String[] data = record.split(" ");
			Record newRecord = new Record(data);
			String carNumber = newRecord.getCarNumber();

			String detail = data[2];
			if (detail.equals("IN")) {
				parkingHistory.add(newRecord);
			} else {
				Record oldRecord = parkingHistory.findRecord(newRecord);
				long parkingTime = oldRecord.calculateTime(newRecord);
				minutes.put(carNumber, minutes.getOrDefault(carNumber, 0L) + parkingTime);
				parkingHistory.remove(oldRecord);
			}
		}
		parkingHistory.calculateMinutes(minutes);
		List<Long> sortedMinutes = minutes.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.map(Map.Entry::getValue)
				.collect(Collectors.toList());

		return calculateFees(sortedMinutes);
	}

	private int[] calculateFees(List<Long> minutes) {
		int[] fees = new int[minutes.size()];
		for (int i = 0; i < minutes.size(); i++) {
			long minute = minutes.get(i);
			if (minute <= basicTime) {
				fees[i] = basicFee;
			} else {
				double exceedTime = (double)(minute - basicTime) / unitTime;
				int exceedTimeCeil = (int)Math.ceil(exceedTime);
				fees[i] = basicFee + exceedTimeCeil * unitFee;
			}
		}
		return fees;
	}

	private class Record {

		private final LocalTime time;
		private final String carNumber;

		public Record(String[] record) {
			String time = record[0];
			String carNumber = record[1];

			this.time = LocalTime.parse(time);
			this.carNumber = carNumber;
		}

		public boolean hasSameNumber(Record other) {
			return this.carNumber.equals(other.carNumber);
		}

		public long calculateTime(Record other) {
			return ChronoUnit.MINUTES.between(this.time, other.time);
		}

		public long calculateTime(LocalTime other) {
			return ChronoUnit.MINUTES.between(this.time, other);
		}

		public String getCarNumber() {
			return carNumber;
		}
	}

	private class Records {

		private final List<Record> records = new ArrayList<>();

		public void add(Record record) {
			records.add(record);
		}

		public Record findRecord(Record newRecord) {
			return records.stream()
					.filter(record -> record.hasSameNumber(newRecord))
					.findAny()
					.get();
		}

		public void remove(Record oldRecord) {
			records.remove(oldRecord);
		}

		public void calculateMinutes(Map<String, Long> minutes) {
			for (Record record : records) {
				long time = record.calculateTime(LocalTime.parse("23:59"));
				String carNumber = record.getCarNumber();
				minutes.put(carNumber, minutes.getOrDefault(carNumber, 0L) + time);
			}
		}
	}
}
