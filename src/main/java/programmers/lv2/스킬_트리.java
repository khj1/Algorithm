package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/49993
 */
public class 스킬_트리 {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		Queue<Character> queue = getQueue(skill);

		for (String skillTree : skill_trees) {
			Queue<Character> tempQueue = new LinkedList<>(queue);
			if (isValidSkillTree(skill, skillTree, tempQueue)) {
				answer++;
			}
		}
		return answer;
	}

	private boolean isValidSkillTree(String skill, String skillTree, Queue<Character> tempQueue) {
		for (char learnedSkill : skillTree.toCharArray()) {
			if (skill.contains(String.valueOf(learnedSkill))) {
				if (learnedSkill != tempQueue.peek()) {
					return false;
				}
				tempQueue.poll();
			}
		}
		return true;
	}

	private Queue<Character> getQueue(String skill) {
		Queue<Character> queue = new LinkedList<>();
		for (char priorSkill : skill.toCharArray()) {
			queue.add(priorSkill);
		}
		return queue;
	}
}
