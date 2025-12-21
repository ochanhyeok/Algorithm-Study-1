import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//시간 T를 잡을 때 그 안에 M명을 다 처리할 수 있는지 판단 후 최소 T 찾기 
		int N = Integer.parseInt(st.nextToken()); // 심사대 수 
		long M = Long.parseLong(st.nextToken()); // 총 사람의 수 
		
		long[] times = new long[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		//이분 탐색 범위 설정
		long left = 1; 
		long right = Arrays.stream(times).max().getAsLong()*M;
		long answer = right;
		
		while (left <= right) {
			long mid = (left + right) / 2; 

            // 해당 시간 안에 처리 가능한 사람 수 계산
            long total = 0;
            for (int i = 0; i < N; i++) {
                total +=( mid / times[i]);  // 심사대 i가 mid 안에 처리할 수 있는 인원을 더함
                if (total >= M) break; 
            }

            if (total >= M) {
                // mid 시간이 충분하면 범위 줄이 
                answer = mid; 
                right = mid - 1;
            } else {
                // mid 시간이 부족하니까 늘림
                left = mid + 1;
            }
        }

        System.out.println(answer);
		
	}
}

