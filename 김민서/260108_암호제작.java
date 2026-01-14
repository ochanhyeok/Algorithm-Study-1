import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BigInteger p = new BigInteger(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 2; i < k; i++) {
			if (p.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
				System.out.println("BAD " + i);
				return;
			}
		}

		System.out.println("GOOD");

	}

}

