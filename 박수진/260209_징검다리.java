import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int low = 1;
        int high = distance;
        int answer = 0;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (check(distance, rocks, n, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    // 최소 거리 minDist를 유지하도록 바위를 최대 n개까지 제거할 수 있는지 판정
    private boolean check(int distance, int[] rocks, int n, int minDist) {
        int removed = 0;
        int prev = 0; // 마지막으로 남긴 바위

        for (int rock : rocks) {
            if (rock - prev < minDist) {
                removed++;
                if (removed > n) return false;
            } else {
                prev = rock;
            }
        }

        if (distance - prev < minDist) {
            removed++;
        }

        return removed <= n;
    }
}
