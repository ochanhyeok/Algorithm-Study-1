import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers[i] = num;
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);

        int answer = 0;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == x) {
                answer++;
                left++;
                right--;
            } else if (sum > x) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer);

    }
}