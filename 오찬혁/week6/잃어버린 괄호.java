package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 읽어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] minus = str.split("-");
		int sum = 0;

		// \\+ 는 앞 패턴이 1번 이상 반복이라
		String[] first = minus[0].split("\\+");
		for (String num : first) {
			sum += Integer.parseInt(num);
		}

		// 내부 + 들을 다 더한 뒤 한번에 빼기
		for (int i = 1; i < minus.length; i++) {
			String[] plus = minus[i].split("\\+");
			int temp = 0;
			for (String num : plus) {
				temp += Integer.parseInt(num);
			}
			sum -= temp;
		}

		System.out.println(sum);
	}
}
