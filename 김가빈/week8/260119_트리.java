import java.util.*;
import java.io.*;

public class Main {
    static int count = 0; // 리프 노드 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }

        int rootNode = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node == -1) {
                rootNode = i;
                continue;
            }
            graph.get(node).add(i);
            graph.get(i).add(node);
        }

        st = new StringTokenizer(br.readLine());
        int removeNode = Integer.parseInt(st.nextToken());

        if (removeNode == rootNode) {
            System.out.println(0);
        } else {
            dfs(graph, rootNode, removeNode);
            System.out.println(count);
        }
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int rootNode, int removeNode) {
        boolean[] visited = new boolean[graph.size()]; // 방문 여부
        Stack<Integer> needVisit = new Stack<>();      // DFS용 스택

        needVisit.push(rootNode);

        while (!needVisit.isEmpty()) {
            int currentNode = needVisit.pop();

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            // 삭제 노드면 더 탐색 안 함
            if (currentNode == removeNode) continue;

            int childCount = 0;

            for (int next : graph.get(currentNode)) {
                if (!visited[next] && next != removeNode) {
                    childCount++;
                    needVisit.push(next);
                }
            }

            // 자식이 없으면 리프 노드
            if (childCount == 0) {
                count++;
            }
        }
    }
}
