import java.util.*;

public class Main {
    
    // k의 배수로 올림
    static int ceil(int val, int k) {
        return ((val + k - 1) / k) * k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();          // 길이
        int[] predict = new int[n];
        
        for (int i = 0; i < n; i++) {
            predict[i] = sc.nextInt();
        }
        
        int k = sc.nextInt();

        int[] result = new int[n];

        // 첫 날
        result[0] = ceil(predict[0], k);

        for (int i = 1; i < n; i++) {
            int prev = result[i - 1];

            int low = prev - k;
            int high = prev + k;

            int cur = Math.max(low, ceil(predict[i], k));
            cur = ceil(cur, k);

            if (cur > high) {
                cur = (high / k) * k;
            }

            result[i] = cur;
        }

        // 출력
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}