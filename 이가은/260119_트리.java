import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] tree;
    static int target;
    static int leafCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;

        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) {
                root = i;
            } else {
                tree[p].add(i);
            }
        }

        target = Integer.parseInt(br.readLine());

        // 루트가 target인 경우 무조건 0
        if (root == target) {
            System.out.println(0);
            return;
        }

        // 루트부터 트리 순회하며 리프 탐색 (target 노드는 제외)
        dfs(root);
        System.out.println(leafCount);
    }

    static void dfs(int node) {
        if (node == target) return;

        int validChild = 0;
        for (int next : tree[node]) {
            if (next == target) continue;
            validChild++;
            dfs(next);
        }

        if (validChild == 0) leafCount++;
    }
}