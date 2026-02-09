public import java.util.StringTokenizer;

class Solution {
    public int solution(int n, int k) {
        StringBuilder nk = new StringBuilder();
        // n (10 -> k진수)
        while (n > 0) {
            nk.insert(0, n%k);
            n = n/k;
        }
        
        int answer = 0;
        
        // 0 기준으로 분리 후 소수가 맞는지 확인
        StringTokenizer st = new StringTokenizer(nk.toString(), "0");
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals("1"))
                continue;
            
            if (isPrime(s)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    boolean isPrime(String s) {
        long num = Long.parseLong(s);
        
        if (num <= 1) {
            return false;
        }
        
        for (long i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
