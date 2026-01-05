import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


class Solution {
    public int[] solution(int[] answers) {
       List<Integer> answer = new ArrayList<>();

        int[] scores = new int[3];
        int[][] students = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int count = 0;
        int max = 0;

        for (int i = 0; i < 3; i++) {
            int[] student = students[i];

            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == student[j % student.length]) {
                    count++;
                }
            }
            scores[i] = count;
            max = Math.max(max, count);
            count = 0;
        }

        int finalMax = max;
        return IntStream.range(0, 3).filter(i -> scores[i] == finalMax).map(i -> i + 1).toArray();
    }
}