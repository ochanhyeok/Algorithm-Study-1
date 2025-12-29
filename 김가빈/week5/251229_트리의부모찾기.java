import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Map<Integer, List<Integer>> graph = new HashMap<>();
		parent = new int[N];
		
		//트리 구현 -> 연결 그래프로 
		for(int i=1; i<=N; i++) {
			graph.put(i, new ArrayList<>());
		}
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			Integer p = Integer.parseInt(st.nextToken());
			Integer c = Integer.parseInt(st.nextToken());
			graph.get(p).add(c);
			graph.get(c).add(p);
		}
		
		//1번 노드부터 방문 여부만 체크하기 위한 dfs
		findParent(graph, 1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i< parent.length; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
		
		
	}
	public static boolean[] findParent(Map<Integer, List<Integer>> graph, int i) {
		boolean[] visited = new boolean[graph.size()]; //방문한 노드 -> 없으면 서로 부모가 되는 경우 발생 
		Queue<Integer> needVisit = new LinkedList<>(); //방문할 노드
		
		//트리 형태의 자료구조 -> 리스트의 첫번째 값이 부모노드가 된다. => 모든 노드가 하나로 연결되어 있는 구조니까 어디서 시작해도 전부 연결 
		//문제에서 둘째 줄에서부터 트리 상에서 연결된 정점이 주어지니까 처음 주어지는 노드가 루트노드가 됨.
		needVisit.add(i); //시작노드부터
		
		while(needVisit.size() > 0) {
			Integer node = needVisit.remove();//뒤에서 제거(즉, 마지막 노드를 꺼냄)
			//꺼낸 노드가 방문한 노드면 이미 누군가의 부모-> 검색X
			if(!visited[node-1]) {
				visited[node-1] = true; //해당 노드 방문 전이니까 방문처리 
				if(graph.get(node) != null) { //자식 노드가 있다면 방문할 노드에 추가 
					needVisit.addAll(graph.get(node));
					
					//자식 노드들의 부모를 현재 노드로 변경
					for(Integer c : graph.get(node)) {
						//해당 자식 노드가 방문 하지 않았을 때 부모 모드 입력하기
						if(!visited[c-1]) {
							parent[c-1] = node;
						}
					}
				}
			}
		}
		return visited;
		
	}
}

