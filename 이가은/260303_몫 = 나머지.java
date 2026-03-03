class Solution {
    public long solution(int n) {
        long answer  = 0;
        for (long i = 1; i < n; i++) {
            answer += n * i + i;
        }

        return answer;
    }
}
