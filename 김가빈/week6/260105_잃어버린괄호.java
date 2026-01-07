v
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();

        int minusIdx = expr.indexOf('-');

        // '-'가 없는 경우: 그냥 전부 더하면 끝
        if (minusIdx == -1) {
            System.out.println(sumNumbers(expr));
            return;
        }

        // '-' 뒤쪽
        String tail = expr.substring(minusIdx + 1);
        int temp = sumNumbers(tail);

        // '-' 앞쪽
        String head = expr.substring(0, minusIdx);
        int result = sumNumbers(head);

        System.out.println(result - temp);
    }

    // + 또는 - 기준으로 문자열 분리 후 숫자 합산
    private static int sumNumbers(String s) {
        String[] nums = s.split("[+-]");
        int sum = 0;
        for (String n : nums) {
            if (!n.isEmpty()) {
                sum += Integer.parseInt(n);
            }
        }
        return sum;
    }
}