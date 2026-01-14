import java.util.*;

class Solution {

	static class Node implements Comparable<Node>{
		int to, cost;

		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o){
			return this.cost - o.cost;
		}
	}

	public int solution(int N, int[][] road, int K) {
		int answer = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();

		List<Node>[] graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++){
			graph[i] = new ArrayList<>();
		}

		for(int[] r : road){
			graph[r[0]].add(new Node(r[1], r[2]));
			graph[r[1]].add(new Node(r[0], r[2]));
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

		pq.offer(new Node(1, 0));

		while(!pq.isEmpty()){
			Node cur = pq.poll();
			if(cur.cost > dist[cur.to]){
				continue;
			}

			for(Node next : graph[cur.to]){
				if(dist[next.to] > dist[cur.to] + next.cost){
					dist[next.to] = dist[cur.to] + next.cost;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}

		for(int i = 1; i <= N; i++){
			if(dist[i] <= K){
				answer++;
			}
		}

		return answer;
	}
}