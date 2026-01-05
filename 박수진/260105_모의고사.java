import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] supoza = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4 , 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
         int[] score = new int[3]; // 0:1번, 1:2번, 2:3번 정답 개수

        for (int i = 0; i < answers.length; i++) {
            for (int p = 0; p < 3; p++) {
                if (supoza[p][i % supoza[p].length] == answers[i]) {
                    score[p]++;
                }
            }
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < 3; p++) {
            if (score[p] == max) result.add(p + 1);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        return answer;
    }
}