import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(input);
        
        int last = input[0] * input[1] * input[2];
        int cnt = 0;
        
        for (int i=1; i<last; i++) {
            cnt = 0;
            if (i%input[0] == 0)
                cnt++;
            if (i%input[1] == 0)
                cnt++;
            if (i%input[2] == 0)
                cnt++;
            if (i%input[3] == 0)
                cnt++;
            if (i%input[4] == 0)
                cnt++;
            
            if (cnt >= 3) {
                System.out.println(i);
                return;
            }
        }
        
        System.out.println(last);
    }
}