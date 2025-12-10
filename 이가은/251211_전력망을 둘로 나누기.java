import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<Integer>[] connection = new List[n + 1];
        for (int i = 0; i <= n; i++)  connection[i] = new ArrayList<>();
        

        // 각 송전탑마다 연결된 송전탑 저장
        for (int[] wire: wires) {
            int a = wire[0];
            int b = wire[1];
            connection[a].add(b);
            connection[b].add(a);
        }
        
        // 연결된 송전탑 순회
        for (int[] wire : wires) {
            boolean visited[] = new boolean[n + 1];
            int a = wire[0]; int b = wire[1];
            int cnt = 0;
            
            // 연결 끊음
            connection[a].remove(Integer.valueOf(b));
            connection[b].remove(Integer.valueOf(a));
            
            Queue<Integer> queue = new LinkedList<>();
            
            // 시작점 1로 지정
            queue.add(1);
            visited[1] = true;

            // 1부터 연결된 송전탑 카운트
            while(!queue.isEmpty()) {
               int q = queue.poll();
                cnt++;
                for (int next : connection[q]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    queue.add(next);
                }
            }
            
            // 하나의 전력망 카운트했으면
            // 남은 하나의 전력망은 전체에서 뺀 것
            // 두 전력망 송전탑 차이 구함
            answer = Math.min(Math.abs(cnt - (n - cnt)), answer);
            
            // 다시 연결
            connection[a].add(b);
            connection[b].add(a);
        }
        
        return answer;
    }
    
}