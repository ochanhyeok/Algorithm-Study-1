import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        
        ArrayList<Integer> cnt = new ArrayList<>();
        
        int currentCount = 1;
        for (int i = 0; i < tangerine.length - 1; i++) {
            if (tangerine[i] == tangerine[i+1]) {
                currentCount++;
            } else {
                cnt.add(currentCount);
                currentCount = 1; // 새로운 귤이므로 1로 초기화
            }
        }
        cnt.add(currentCount);
        
        cnt.sort(Collections.reverseOrder());
        
        int answer = 0;
        
        for (int count : cnt) {
            k -= count;
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}