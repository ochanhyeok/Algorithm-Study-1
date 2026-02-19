import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int size = citations.length;
        int left = 0;
        int right = citations[size - 1];
        
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            
            for (int c : citations) {
                if (c >= mid) {
                    cnt++;
                }
            }
            
            if (cnt >= mid) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}