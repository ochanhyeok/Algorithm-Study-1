import java.util.Queue;
import java.util.LinkedList;

import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 명령어 입력 받기 (배열에 저장)
        String[] order = new String[N];
        for (int i=0; i<N; i++) {
            order[i] = br.readLine();
        }
        
        // 명령 수행 시작
        Queue<Integer> q = new LinkedList<>();
        StringBuilder answer = new StringBuilder("");
        int rear = 0;   // 큐의 마지막 원소 저장 변수
        
        for (String o : order) {
            if (o.contains("size"))
                answer.append(q.size()).append('\n');
            
            // 큐가 비어있을 때 pop, front, back 명령어 수행 시
            else if (q.isEmpty() && !(o.contains("push"))) {
                if (o.equals("empty"))
                    answer.append("1").append('\n');
                else
                    answer.append("-1").append('\n');
                continue;
            }
            
            else if (o.contains("pop")) {
                answer.append(q.poll()).append('\n');
            }

            else if (o.equals("front")) {
                answer.append(q.peek()).append('\n');
            }
            else if (o.equals("back")) {
                answer.append(rear).append('\n');
            }
            
            else if (o.equals("empty"))
                answer.append('0').append('\n');
            
            else { //push
                StringTokenizer stk = new StringTokenizer(o, " ");
                stk.nextToken();
                rear = Integer.parseInt(stk.nextToken());
                
                q.offer(rear);
            }
        }
        System.out.println(answer);
        return;
    }
}