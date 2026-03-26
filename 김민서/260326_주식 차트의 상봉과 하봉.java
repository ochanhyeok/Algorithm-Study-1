import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;

        int[] incLeft = new int[n];   // i까지 연속 상승 길이
        int[] decLeft = new int[n];   // i까지 연속 하락 길이
        int[] incRight = new int[n];  // i부터 연속 상승 길이
        int[] decRight = new int[n];  // i부터 연속 하락 길이

        // 왼쪽 -> 오른쪽
        for (int i = 1; i < n; i++) {
            if (prices[i - 1] < prices[i]) {
                incLeft[i] = incLeft[i - 1] + 1;
            }
            if (prices[i - 1] > prices[i]) {
                decLeft[i] = decLeft[i - 1] + 1;
            }
        }

        // 오른쪽 -> 왼쪽
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] < prices[i + 1]) {
                incRight[i] = incRight[i + 1] + 1;
            }
            if (prices[i] > prices[i + 1]) {
                decRight[i] = decRight[i + 1] + 1;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
            // 상봉
            if (prices[i - 1] < prices[i] && prices[i] > prices[i + 1]) {
                int width = Math.min(incLeft[i], decRight[i]);
                list.add(width);
            }
            // 하봉
            else if (prices[i - 1] > prices[i] && prices[i] < prices[i + 1]) {
                int width = Math.min(decLeft[i], incRight[i]);
                list.add(-width);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}