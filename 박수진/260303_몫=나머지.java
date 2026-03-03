class Solution {
    public long solution(int n) {
        long answer = 0;
        for (long q = 1; q <= n - 1; q++) {
            answer += q * (n + 1);
        }
        return answer;
    }

    public long solution2(int n) {
      long N = n;
      return (N * (N - 1) / 2) * (N + 1);
    }
}