import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 동전 종류
		int k = Integer.parseInt(st.nextToken()); // 합

		int[] coins = new int[n];
		int maxIndex = 0;
		int answer = 0;

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			if (coins[i] <= k)
				maxIndex = i;
		}

		for (int i = maxIndex; i >= 0; i--) {
			int coin = coins[i];
			if (k - coin >= 0) {
				answer += k / coin;
				k = k - ((k / coin) * coin);
			}

			if (k == 0)
				break;
		}

		System.out.println(answer);

	}

}