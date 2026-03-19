import java.util.Arrays;

public class Main {

    static int minSum = Integer.MAX_VALUE;
    static int[] answer;

    public static void main(String[] args) {
        int[] predict = {1, 13, 15, 12,3, 1, 10};
        int k = 4;

//        int[] predict = {0, 10, 0, 8, 0, 12};
//        int k = 1;

//        int[] predict = {11, 3, 1, 6, 20, 7, 1, 0, 0};
//        int k = 6;
        System.out.println(Arrays.toString(solution(predict, k)));
    }

    static public int[] solution(int[] predict, int k) {
        int n = predict.length;
        int[] result = new int[n];
        answer = new int[n];

        // 마지막 날부터 백트래킹
        double lastPredict = predict[n - 1];
        int lastAmount = (int) Math.ceil(lastPredict / k) * k ;

        result[n - 1] = lastAmount;

        backtrack(n - 1, lastAmount, result, predict, k);

        return answer;
    }



    static void backtrack(int index, int sum, int[] result, int[] predict, int k) {
        if (index == 0) {
            if (sum < minSum) {
                minSum = sum;
                answer = Arrays.copyOf(result, result.length);
            }
            return;
        }

        int[] cases = {result[index], result[index] - k, result[index] + k};

        for (int i = 0; i < 3; i++) {
            int previousAmount = cases[i];

            if (previousAmount >= predict[index - 1]) {
                result[index - 1] = previousAmount;
                backtrack(index - 1, sum + result[index - 1], result, predict, k );
                result[index - 1] = 0;
            }
        }

    }
