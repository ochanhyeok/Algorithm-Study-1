import java.util.*;

class Solution {
    public int[] solution(int[] predict, int k) {
        int n = predict.length;

        int[] need = new int[n];
        for (int i = 0; i < n; i++) {
            need[i] = (predict[i] + k - 1) / k; // ceil(predict[i] / k)
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int[] answer = new int[n];

        // 왼쪽 -> 오른쪽
        left[0] = need[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(need[i], left[i - 1] - 1);
        }

        // 오른쪽 -> 왼쪽
        right[n - 1] = need[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(need[i], right[i + 1] - 1);
        }

        // 양쪽 제약을 모두 만족하는 최소값
        for (int i = 0; i < n; i++) {
            answer[i] = Math.max(left[i], right[i]) * k;
        }

        return answer;
    }
}