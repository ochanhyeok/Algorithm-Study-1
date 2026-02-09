import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String res = Integer.toString(n, k); 
        
        String[] numbers = res.split("0"); 
        
        for (String numStr: numbers) { 
            
            if (numStr.length() == 0 ) continue; 
            
            if (isPrime(Long.parseLong(numStr))) {
               
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(long n) {
        if (n == 1) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if ( n % i == 0) {
                return false;
            } 
        }
        
        return true;
    }
}