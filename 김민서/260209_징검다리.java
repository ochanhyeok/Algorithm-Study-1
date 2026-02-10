import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int start = 1;
        int end = distance;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            int prev = 0;
            
            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
            }
            
            if(distance - prev < mid) {
                cnt++;
            }
            
            if(cnt <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return end;
    }
}