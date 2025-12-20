import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{

	public int distance;
	public int vertex;
	
	public Edge(int vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}
	
	public String toString() {
		return vertex+" "+distance;
	}
	
	//우선순위큐가 내부에서 이를 자동으로 사용해서 정렬 
	@Override
	public int compareTo(Edge o) {
		return this.distance - o.distance;
	}
	
}

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		// 순서대로 도시 수, 도로, 목표 거리, 시작 도시 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
	
		//2차원 리스트 구현 
		List<Integer>[] graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
		
		// 도로 입력 
		for(int i=0; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
		}
		
		int max = Integer.MAX_VALUE; //최단거리 비교해줄 값.
		int dist[] = new int[N+1]; //각 노드들의 거리를 표시하기 위함. 
		Arrays.fill(dist, max);	//우선 모든 노드들의 거리를 최댓값으로 채워준다. 
		
		//우선순위 큐 활용해서 가장 가까운 도시부터 처리 
		dist[X] = 0; //시작도시니까 거리는 0
		pq.offer(new Edge(X, 0));
		
		while(pq.size() >0) {
			Edge curEdge = pq.poll();
			
			if(curEdge.distance > dist[curEdge.vertex]) continue; // 현재도시의 거리가 이전의 기록보다 크면 다시 확인할 필요 ㄴㄴ
			
			//연결 노드들 순회
			for(int next : graph[curEdge.vertex]) {
				int nextDist = curEdge.distance+1; //모든 간선 거리가 1이니까 +1;
				if(nextDist < dist[next]) { //다음 노드의 거리가 현재보다 크다면 업데이트 해줘야 함.
					dist[next] = nextDist; 
					pq.offer(new Edge(next, nextDist));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		boolean found = false; //K가 하나도 없는 경우를 판별하기 위한 변수
		
	    for (int i = 1; i <= N; i++) {
	        if (dist[i] == K) {
	            sb.append(i).append("\n");
	            found = true;
	        }
		}
		
		System.out.print(found ? sb.toString() : "-1");
		
	}
}

