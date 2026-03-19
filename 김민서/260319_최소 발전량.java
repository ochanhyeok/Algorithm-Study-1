import java.util.*;

class Solution {
    public int[] solution(int[] predict, int k) {
        int n = predict.length;
        int[] result = new int[n];

        // 첫 날: 가능한 최소 k배수
        result[0] = ceil(predict[0], k);

        for (int i = 1; i < n; i++) {
            int prev = result[i - 1];

            // 이번 날 최소 요구 (k배수)
            int need = ceil(predict[i], k);

            // 가능한 범위
            int low = prev - k;
            int high = prev + k;

            // need 이상이면서 low 이상
            int cur = Math.max(need, low);

            // k배수 맞추기
            cur = ceil(cur, k);

            // 만약 범위 초과하면 → 이전 값에서 최대 가능한 값 선택
            if (cur > high) {
                cur = (high / k) * k;
            }

            result[i] = cur;
        }

        return result;
    }

    // k의 배수로 올림
    private int ceil(int val, int k) {
        return ((val + k - 1) / k) * k;
    }
}