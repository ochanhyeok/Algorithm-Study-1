import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peekLast()]) {
                int idx = stack.pollLast();
                answer[idx] = i - idx;
            }
            stack.addLast(i);
        }

        // 끝까지 안 떨어진 것들 처리
        while (!stack.isEmpty()) {
            int idx = stack.pollLast();
            answer[idx] = (n - 1) - idx;
        }

        return answer;
    }
}