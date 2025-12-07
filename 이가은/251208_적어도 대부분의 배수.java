import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] arr = new int[5];
		
		for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int answer = 1;
		
		while (true) {
			int cnt = 0;
			for (int i = 0; i < 5; i++) {
				if (answer % arr[i] == 0) cnt++;
				if (cnt == 3) {
					System.out.println(answer);
					return;
				}
			}
			answer++;
		}
	}
}
