package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */
public class 오픈채팅방 {
	public static final Map<String, User> userRepository = new HashMap<>();
	public static final List<Dialogue> dialogueRepository = new ArrayList<>();

	public String[] solution(String[] record) {
		for (String log : record) {
			String[] split = log.split(" ");

			String id = split[1];
			Command command = Command.from(split[0]);

			if (command == Command.LEAVE) {
				dialogueRepository.add(new Dialogue(id, command));
			} else {
				String name = split[2];
				if (command == Command.ENTER) {
					User user = new User(id, name);
					userRepository.put(user.id, user);
					dialogueRepository.add(new Dialogue(id, command));
				} else if (command == Command.CHANGE) {
					User user = userRepository.get(id);
					user.setName(name);
				}
			}
		}
		return dialogueRepository.stream()
				.map(dialogue -> userRepository.get(dialogue.id).write(dialogue.command))
				.toArray(String[]::new);
	}

	static class User {

		private final String id;
		private String name;

		public User(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String writeEnter() {
			return name + "님이 들어왔습니다.";
		}

		public String writeLeave() {
			return name + "님이 나갔습니다.";
		}

		public String write(Command command) {
			if (command == Command.ENTER) {
				return writeEnter();
			}
			return writeLeave();
		}
	}

	enum Command {
		ENTER("Enter"),
		LEAVE("Leave"),
		CHANGE("Change");

		private final String command;

		Command(String command) {
			this.command = command;
		}

		public static Command from(String input) {
			return Arrays.stream(values())
					.filter(command -> command.hasSame(input))
					.findFirst()
					.get();
		}

		private boolean hasSame(String command) {
			return this.command.equals(command);
		}
	}

	static class Dialogue {
		private final String id;
		private final Command command;

		public Dialogue(String id, Command command) {
			this.id = id;
			this.command = command;
		}
	}
}
