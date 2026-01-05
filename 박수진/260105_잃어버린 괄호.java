import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), "+-", true);
        
        List<String> stmt = new ArrayList<>();
        while(st.hasMoreTokens()) {
            stmt.add(st.nextToken());
        }
        
        long answer = 0L;
        long minusSum = 0L;
        boolean inMinus = false;
        
        for (int i = 0; i < stmt.size(); i++) {
            String t = stmt.get(i);

            if (t.equals("+")) continue;

            if (t.equals("-")) {
                // '-'를 처음 만나면 이후는 모두 빼는 구간으로 들어감
                inMinus = true;
                continue;
            }

            // 숫자 토큰
            long num = Long.parseLong(t);
            if (!inMinus) answer += num;
            else minusSum += num;
        }

        answer -= minusSum;
        System.out.println(answer);
    }
}