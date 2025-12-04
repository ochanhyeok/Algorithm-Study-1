import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            } else if(cmd.equals("pop")){
                if(queue.isEmpty()){
                    sb.append("-1");
                } else {
                    sb.append(queue.poll());
                }
                sb.append("\n");
            } else if(cmd.equals("size")){
                sb.append(queue.size()).append("\n");
            } else if(cmd.equals("empty")){
                if(queue.isEmpty()){
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                sb.append("\n");
            } else if(cmd.equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1");
                } else {
                    sb.append(queue.peekFirst());
                }
                sb.append("\n");
            } else if(cmd.equals("back")){
                if(queue.isEmpty()){
                    sb.append("-1");
                } else {
                    sb.append(queue.peekLast());
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}