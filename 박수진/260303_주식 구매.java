import java.util.*;

class Solution {
  int solution(int[] prices) {
    int minPrice = Integer.MAX_VALUE;

    // dp[b][s]: 매수 b번, 매도 s번 했을 때 최대 이익
    int[][] dp = new int[3][3];
    for (int b = 0; b <= 3; b++) {
      Arrays.fill(dp[b], minPrice);
    }
    dp[0][0] = 0;

    for (int p : prices) {
      int[][] next = new int[3][3];
      for (int b = 0; b <= 2; b++) {
        for (int s = 0; s <= b; s++) {
          if (dp[b][s] == minPrice) continue;

          // 1. 아무것도 안 함
          next[b][s] = Math.max(next[b][s], dp[b][s]);

          // 2. 매수
          if (b < 2) {
            next[b + 1][s] = Math.max(next[b + 1][s], dp[b][s] - p);
          }

          // 3. 매도
          if (s < b) {
            next[b][s + 1] = Math.max(next[b][s + 1], dp[b][s] + p);
          }
        }
      }
      dp = next;
    }

    int answer = 0;
    for (int k = 0; k <= 2; k++) {
      answer = Math.max(answer, dp[k][k]);
    }
    return answer;
  }
}