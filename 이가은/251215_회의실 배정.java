import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		int[][] meetings = new int[n][2]; // 각 회의별 시작시간, 종료시간 저장
		int answer = 0;
		
        // 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			meetings[i][0] = start;
			meetings[i][1] = end;
		}

        // 종료시간이 빠른 순서대로 정렬
        // 종료시간 같은 경우 시작시간 빠른 순서대로 정렬
		Arrays.sort(meetings, (a, b) -> {
			if (a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});

        // 이전 회의 종료시간
		int prev = meetings[0][0];

        // 정렬된 회의들을 순회하며 이전 회의 종료시간과 가장 가까운 시작시간을 가진 회의를 카운트
		for (int i = 0; i < n; i++) {
			if (meetings[i][0] >= prev) { // 이전 회의 종료시간보다 같거나 큰 경우 탐색
				answer++;
				prev = meetings[i][1]; // 다음 비교를 위해 prev를 현재 회의 종료 시간으로 업데이트
			}
		}

		System.out.println(answer);
	}

}