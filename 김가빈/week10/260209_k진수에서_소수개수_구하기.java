import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String kNum = Integer.toString(n,k);
        String[] arr = kNum.split("0");

        for(int i=0; i<arr.length;i++){
            if(arr[i].length()<1) continue;
            long num = Long.parseLong(arr[i]);
            if(isPrime(num)) answer++;
        }
        return answer;
    }

    public static boolean isPrime(long num){
        if(num < 2) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }
}