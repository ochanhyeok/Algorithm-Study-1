package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	public int distance; //거리
	public int vertex; //정점

	public Edge(int vertex, int distance) {
		this.distance = distance;
		this.vertex = vertex;
	}

	@Override
	public int compareTo(Edge edge) {
		return this.distance - edge.distance;
	}
}

public class Bus {
	static int N; // 도시의 개수 (정점)
	static int M; // 버스의 개수 (간선)
	static List<Edge>[] graph; // 그래프를 표현하는 인접 리스트
	static int[] distance; // 최단거리 배열
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new LinkedList[N + 1];
		distance = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Edge>();
		}

		for (int j = 1; j <= M; j++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v, w));
		}

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);

		System.out.println(distance[end]);
	}

	public static void dijkstra(int start) {
		boolean[] visited = new boolean[N + 1];

		Arrays.fill(distance, INF);
		distance[start] = 0;

		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(start, 0));

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			int u = edge.vertex;

			if (!visited[u]) {
				visited[u] = true;

				for (Edge n : graph[u]) {
					int v = n.vertex;
					int dist = n.distance;

					if (!visited[v] && distance[u] + dist < distance[v]) {
						distance[v] = distance[u] + dist;
						queue.add(new Edge(v, distance[v]));
					}
				}
			}
		}
	}
}