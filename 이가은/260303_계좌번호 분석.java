package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		String[] nums = { "1-2-3-456789012", "582845-385823", "48572-39485-89012", "4-5-2-593328484", "4958-392945123-",
				"49582039415423", "7-3-7-000000000", "485723-693812", "39482746582734", "1-1-1-111111111",
				"A4944-5095-4951", "4851293412223" };
		System.out.println(Arrays.toString(solution(nums)));
	}

	public static int[] solution(String[] nums) {
		Map<String, Integer> numTypes = new HashMap<>();

		for (String num : nums) {

			int dashCount = 0; 
			int numberCount = 0;
			boolean isCharacterValid = true;

			StringBuilder numStructure = new StringBuilder(); // dash 위치, dashCount, numberCount 저장한 문자열
            
            // 계좌번호가 -로 시작하거나 끝나는 경우
			if (num.charAt(0) == '-' || num.charAt(num.length() - 1) == '-')
				continue;

			for (int i = 0; i < num.length(); i++) {
				char c = num.charAt(i);

                // 규칙 1 : 숫자와 -로만 이루어짐 위배
				if (c != '-' && !isNumber(c)) {
					isCharacterValid = false;
					break;
				}

                // 규칙 4 : - 연속' 불가
				if (i > 0 && c == '-' && num.charAt(i - 1) == '-') {
					isCharacterValid = false;
					break;
				}

				if (isNumber(c)) {
					numberCount++;
				} else {
					numStructure.append(i + ",");
					dashCount++;
				}

			}

            // 규칙 1 (모든 문자 숫자나 -) 과 규칙 2(숫자 11 ~ 14자), 규칙 3 (- 0 ~ 3자) 만족하지 않은 경우 
			if (!isCharacterValid || !isCharacterCountValid(numberCount, dashCount))
				continue;

			numStructure.append("(" + numberCount + "," + dashCount + ")");

			String numStrunctureStr = numStructure.toString();
			numTypes.put(numStrunctureStr, numTypes.getOrDefault(numStrunctureStr, 0) + 1);

		}

		return numTypes.values().stream().sorted((a, b) -> b - a).mapToInt(i -> i).toArray();
	}

	static boolean isNumber(char c) {
		return c >= '0' && code <= '9';
	}

	static boolean isCharacterCountValid(int numberCount, int dashCount) {
		return numberCount >= 11 && numberCount <= 14 && dashCount >= 0 && dashCount <= 3;
	}

}
