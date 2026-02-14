import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int m = Integer.parseInt(br.readLine());

        ArrayDeque<Character> left = new ArrayDeque<>();
        ArrayDeque<Character> right = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) left.addLast(s.charAt(i));

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            char cmd = line.charAt(0);

            if (cmd == 'L') {
                if (!left.isEmpty()) right.addLast(left.removeLast());
            } else if (cmd == 'D') {
                if (!right.isEmpty()) left.addLast(right.removeLast());
            } else if (cmd == 'B') {
                if (!left.isEmpty()) left.removeLast();
            } else { // 'P'
                left.addLast(line.charAt(2));
            }
        }

        StringBuilder out = new StringBuilder(left.size() + right.size());
        for (char c : left) out.append(c);
        while (!right.isEmpty()) out.append(right.removeLast());
        System.out.print(out);
    }
}
