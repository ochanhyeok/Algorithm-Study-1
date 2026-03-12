import java.util.*;

class Solution {
    static int maxDiff = -1;
    static int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        int[] lion = new int[11];
        dfs(0, n, info, lion);
        return answer;
    }

    static void dfs(int idx, int remain, int[] info, int[] lion) {
        // 10점 ~ 0점까지 다 본 경우
        if (idx == 11) {
            // 남은 화살이 있으면 0점 칸에 몰아주기
            lion[10] += remain;

            int diff = getScoreDiff(info, lion);

            // 라이언이 이긴 경우만 후보
            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff;
                    answer = lion.clone();
                } else if (diff == maxDiff) {
                    if (isBetter(lion, answer)) {
                        answer = lion.clone();
                    }
                }
            }

            // 원상복구
            lion[10] -= remain;
            return;
        }

        // 1. 현재 점수 칸을 이기는 경우
        int need = info[idx] + 1;
        if (remain >= need) {
            lion[idx] = need;
            dfs(idx + 1, remain - need, info, lion);
            lion[idx] = 0; // 백트래킹
        }

        // 2. 현재 점수 칸을 포기하는 경우
        dfs(idx + 1, remain, info, lion);
    }

    static int getScoreDiff(int[] info, int[] lion) {
        int apeach = 0;
        int ryan = 0;

        for (int i = 0; i < 11; i++) {
            int score = 10 - i;

            if (info[i] == 0 && lion[i] == 0) continue;

            if (lion[i] > info[i]) {
                ryan += score;
            } else {
                apeach += score;
            }
        }

        return ryan - apeach;
    }

    static boolean isBetter(int[] lion, int[] answer) {
        // 낮은 점수를 더 많이 맞힌 경우가 우선
        for (int i = 10; i >= 0; i--) {
            if (lion[i] > answer[i]) return true;
            if (lion[i] < answer[i]) return false;
        }
        return false;
    }
}