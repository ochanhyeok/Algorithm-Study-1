import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static List<Integer>[] graph = new ArrayList[n];
    static boolean isExist = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            dfs(i, 1, visited);

            if (isExist) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }


    static void dfs(int i, int depth, boolean[] visited) {
        if (depth == 5) {
            isExist = true;
            return;
        }

        for (int v : graph[i]) {
            if (visited[v]) continue;
            boolean[] nextVisited = visited.clone();
            nextVisited[v] = true;
            dfs(v, depth + 1, nextVisited);
            if (isExist) return;
        }
    }

}
