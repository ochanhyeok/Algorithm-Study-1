import java.util.*;
import java.io.*;

class Main {
    
    static long[][][] dp;
    static char[] digits;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long N = Long.parseLong(br.readLine());
        
        long start = 1;
        long end = N * 2000L; 
        
        while(start < end) {
            long mid = (start + end) / 2;
            
            if(countSix(mid) >= N) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        System.out.println(start)
    }
    
    static long countSix(long mid) {
        digits = Long.toString(mid).toCharArray();
        int len = digits.length;
        
        dp = new long[len][3][2];  //pos 몇번째 자리까지 만들었나 cnt: 직전까지 연속 6 수 tight: mid와 똑같이 따라가고 있는지
        for(long[][] arr2 : dp) {
            for(long[] arr1 : arr2) {
                Arrays.fill(arr1, -1);
            }
        }
        
        long six = dfs(0, 0, 1);
        
        return mid + 1 - six;
    }
    
    static long dfs(int pos, int cnt, int tight) {
        if(cnt == 3) { // 666
            return 0;
        }
        
        if(pos == digits.length) {  // 끝까지 666 안나옴
            return 1;
        }
        
        if(dp[pos][cnt][tight] != -1) { // 같은 상태는 다시 계산 안 함
            return dp[pos][cnt][tight];
        }
        
        long result = 0;
        int limit = (tight == 1) ? digits[pos] - '0' : 9;
        
        for(int d = 0; d <= limit; d++) {
            int nextTight = (tight == 1 && d == limit) ? 1 : 0;
            int nextCnt = (d == 6) ? cnt + 1 : 0;
            
            result += dfs(pos + 1, nextCnt, nextTight);
        }
        
        return dp[pos][cnt][tight] = result;
    }
}