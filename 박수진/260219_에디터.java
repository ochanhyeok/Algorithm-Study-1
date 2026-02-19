import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
 
        for (char c : bf.readLine().toCharArray()) {
            left.push(c);
        }
        
        int M = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < M; i++) {
            String command = bf.readLine();
            char op = command.charAt(0);
            
            switch(op) {
                    case 'P' :
                        char x = command.charAt(2);
                        left.push(x);
                        break;
                    case 'L' :
                        if (!left.isEmpty())
                            right.push(left.pop());
                        break;
                    case 'D' :
                        if (!right.isEmpty())
                            left.push(right.pop());
                        break;
                    case 'B' :
                        if (!left.isEmpty())
                            left.pop();
                        break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        
        System.out.println(sb.toString());
    }
}
