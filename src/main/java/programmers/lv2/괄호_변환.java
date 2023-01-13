package programmers.lv2;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/60058
 */
public class 괄호_변환 {
	public String solution(String p) {
		return convertParentheses(p);
	}

	private String convertParentheses(String p) {
		if (p.isBlank()) {
			return "";
		}

		int firstBalanceParenthesesIndex = getFirstBalanceParenthesesIndex(p);
		String v = p.substring(firstBalanceParenthesesIndex + 1);
		String u = p.substring(0, firstBalanceParenthesesIndex + 1);

		if (isPerfectParentheses(u)) {
			return u + convertParentheses(v);
		}
		return "(" + convertParentheses(v) + ")" + trimAndReverse(u);
	}

	private boolean isPerfectParentheses(String u) {
		int open = 0;
		int close = 0;
		for (char c : u.toCharArray()) {
			if (c == '(') {
				open++;
			} else {
				close++;
			}
			if (close > open) {
				return false;
			}
		}
		return true;
	}

	private int getFirstBalanceParenthesesIndex(String u) {
		int open = 0;
		int close = 0;
		int index = 0;
		for (char c : u.toCharArray()) {
			if (c == '(') {
				open++;
			} else {
				close++;
			}
			if (open == close) {
				return index;
			}
			index++;
		}
		return index;
	}

	private String trimAndReverse(String u) {
		return reverse(trim(u));
	}

	private String trim(String u) {
		return u.substring(1, u.length() - 1);
	}

	private String reverse(String u) {
		StringBuilder sb = new StringBuilder();
		for (char c : u.toCharArray()) {
			if (c == '(') {
				sb.append(')');
			} else {
				sb.append('(');
			}
		}
		return sb.toString();
	}
}
