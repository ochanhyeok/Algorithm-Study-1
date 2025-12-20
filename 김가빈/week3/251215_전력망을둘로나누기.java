import java.util.*;
class Solution {
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=1; i<=n; i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i=0; i<wires.length; i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        for (int[] w : wires) {
            visited = new boolean[n + 1];
            int cnt = dfs(w[0], w[0], w[1], graph);
            int diff = Math.abs(n - 2 * cnt);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    int dfs(int node, int blockA, int blockB, Map<Integer, List<Integer>> graph) {
        visited[node] = true;
        int cnt = 1;

        for (int next : graph.get(node)) {
            if ((node == blockA && next == blockB) ||
                (node == blockB && next == blockA)) continue;

            if (!visited[next]) {
                cnt += dfs(next, blockA, blockB, graph);
            }
        }
        return cnt;
    }
}