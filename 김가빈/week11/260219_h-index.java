import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        citations = Arrays.stream(citations)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(i->i).toArray();
        
        int start = 0;
        int end = citations.length;
        
        while ( start <= end ){
            int mid = (start+end)/2;
            int cnt = 0;
            for (int i = 0; i<citations.length; i++){
                if (citations[i] >= mid) cnt++;
            }
            
            if (cnt >= mid) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
            
        }
               
        return answer;
    }
}