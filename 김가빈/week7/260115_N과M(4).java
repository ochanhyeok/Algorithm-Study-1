
import java.io.*;
import java.util.*;

public class Main {

    static List<String> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        comb(sb, N, M, 1);

        for (String str : list) {
            System.out.println(str);
        }
    }

    public static void comb(StringBuilder sb, int N, int M, int start) {
        if (sb.length() == M * 2) {
            list.add(sb.toString());
            return;
        }

        for (int i = start; i <= N; i++) {
            sb.append(i).append(" ");   // 숫자 추가
            comb(sb, N, M, i);      // 다음 단계
            sb.delete(sb.length()-2,sb.length()); //상태 복구(줄바꿈까지)
        }
    }
}