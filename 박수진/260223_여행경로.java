import java.util.Arrays;

class Solution {
    static boolean[] visited;
    static String[] answer;
    static int N;
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        visited = new boolean[N];
        answer = new String[N + 1];
        answer[0] = "ICN";
        
        // 2차원 배열을 알파벳 순으로 정렬       
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            
            return o1[0].compareTo(o2[0]);
        });
        
        dfs("ICN", 1, tickets);
        return answer;
    }
    
    static boolean dfs(String current, int depth, String[][] tickets) {
        if(depth == N + 1) return true;
        
        for(int i = 0; i < N; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                answer[depth] = tickets[i][1];
                
                if (dfs(tickets[i][1], depth + 1, tickets)) return true;

                // 백트래킹
                visited[i] = false;
                answer[depth] = null;
            }
        }
        return false;
    }
}