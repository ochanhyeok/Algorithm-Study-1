import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[] A = Arrays.stream(br.readLine().split(" "))
                         .mapToLong(Long::parseLong)
                         .toArray();
        
        Arrays.sort(A);
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            long target = A[i];
            int left = 0, right = N - 1;
            
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                
                long sum = A[left] + A[right];
                if (sum == target) {
                    answer++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        System.out.println(answer);
    }
}