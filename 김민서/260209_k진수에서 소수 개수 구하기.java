import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String num = Integer.toString(n, k);

        String[] arr = num.split("0+");
        int cnt = 0;

        for (String m : arr) {
            if (m.equals("")) continue;

            long val = Long.parseLong(m);

            if (isPrime(val)) {
                cnt++;
            }
        }

        return cnt;
    }

    public boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
