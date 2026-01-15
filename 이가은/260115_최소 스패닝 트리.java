import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 각 노드의 부모 노드 저장
	static int[] parent;
	// 해당 노드에서의 트리 높이
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(A, B, C);
		}

		// 1) 가중치 오름차순 정렬
		Arrays.sort(edges);

		// 2) 초기화
		parent = new int[V + 1];
		rank = new int[V + 1];

		for (int i = 1; i <= V; i++)
			parent[i] = i;

		long total = 0L; // 비용 합
		int picked = 0;

		// 3) 작은 간선부터
		for (Edge e : edges) {
			// 사이클이 생기지 않는 간선 추가
			if (union(e.a, e.b)) {
				total += e.w;
				picked++;

				// 간선 V - 1개면 종료
				if (picked == V - 1)
					break;
			}

		}

		System.out.println(total);
	}

	// find(x): x가 속한 집합의 대표(root)를 찾는다.
	// path compression: 찾는 김에 parent를 root로 압축해서 다음이 빨라짐
	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	// union(a,b): a 집합과 b 집합을 합친다.
	// true: 두 정점이 다른 집합
	// false: 같은 집합 (=> 사이클 생김)
	static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if (ra == rb)
			return false;

		// union by rank: 더 낮은 트리를 높은 트리에 붙여서 트리 높이 최소화
		if (rank[ra] < rank[rb]) {
			parent[ra] = rb;
		} else if (rank[ra] > rank[rb]) {
			parent[rb] = ra;
		} else {
			parent[rb] = ra;
			rank[ra]++;
		}

		return true;
	}

	static class Edge implements Comparable<Edge> {
		int a, b;
		int w;

		Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w); // 가중치 오름차순
		}
	}

}
