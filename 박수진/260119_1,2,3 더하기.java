import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        
        int[] testCase = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            testCase[i] = Integer.parseInt(bf.readLine());
            if (testCase[i] > max)
                max = testCase[i];
        }
        
        int[] relation = new int[max+1];
        relation[1] = 1;
        relation[2] = 2;
        relation[3] = 4;
        
        if (max >= 4) {
            for (int i = 4; i <= max; i++) {
                relation[i] = (relation[i-1] + relation[i-2] + relation[i-3]);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            answer.append(relation[testCase[i]]).append('\n');
        }
        System.out.println(answer.toString());
    }
}