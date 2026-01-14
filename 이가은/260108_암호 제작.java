import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String P = st.nextToken();      // 큰 수는 문자열로
        int K = Integer.parseInt(st.nextToken());

        int bad = findBadPrime(P, K);
        if (bad == -1) System.out.println("GOOD");
        else System.out.println("BAD " + bad);
    }

    static int findBadPrime(String P, int K) {
        boolean[] isPrime = sieve(K - 1); // K 미만 소수만 필요
        for (int i = 2; i < K; i++) {
            if (!isPrime[i]) continue;
            if (mod(P, i) == 0) return i; // i로 나누어 떨어지면 BAD
        }
        return -1;
    }

    static int mod(String s, int m) {
        int r = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            r = (r * 10 + (c - '0')) % m;
        }
        return r;
    }

    static boolean[] sieve(int n) {
        boolean[] prime = new boolean[Math.max(n + 1, 2)];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) continue;
            for (int j = i * i; j <= n; j += i) prime[j] = false;
        }
        return prime;
    }
}
