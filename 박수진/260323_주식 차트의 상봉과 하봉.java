import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> bongs = new ArrayList<>();

        for (int i = 1; i < prices.length - 1; i++) {
            int a = prices[i-1];
            int b = prices[i];
            int c = prices[i+1];

            // 조건: 바로 상승/하락하는 지점
            if (a == b || b == c)
                continue;

            // 상봉: n 모양
            if (b > a && b > c) {
                bongs.add(i);
            }
            // 하봉: u 모양
            else if (b < a && b < c) {
                bongs.add(i);
            }
        }
        
        int[] answer = new int[bongs.size()];
        
        for (int j = 0; j < bongs.size(); j++) {
            int left = (j == 0)
                    ? bongs.get(j)
                    : bongs.get(j) - bongs.get(j - 1);

            int right = (j == bongs.size() - 1)
                    ? prices.length - 1 - bongs.get(j)
                    : bongs.get(j + 1) - bongs.get(j);

            answer[j] = Math.min(left, right);
        }

        return answer;
    }
}