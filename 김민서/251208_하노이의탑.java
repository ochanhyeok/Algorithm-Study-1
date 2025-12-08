package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hanoi {
	public static int hanoi(int n, String start, String mid, String end, int cnt, StringBuilder sb) {
		if(n == 1) {
			sb.append(start + " " + end + "\n");
			return cnt+1;
		}
		cnt = hanoi(n-1, start, end, mid, cnt++, sb);  //n-1을 중간으로 옮김
		sb.append(start + " " + end + "\n");      // n을 end로 옮김
		cnt++;
		cnt = hanoi(n-1, mid, start, end, cnt++, sb); // n-1을 중간에서 end로 옮김
		return cnt;
	}

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = hanoi(n, "1", "2", "3", 0, sb);
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

}
