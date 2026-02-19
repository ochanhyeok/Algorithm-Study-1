import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int max = 0;
        
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= len - i) {
                if(max < len - i) {
                    max = len - i;
                }    
            }
        }
        
        return max;
    }
}