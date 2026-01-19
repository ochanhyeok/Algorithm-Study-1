package task;

import java.util.*;
import java.io.*;

public class Main {
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<N; i++) {
			graph.put(i, new ArrayList<>());
		}
//		System.out.println(graph);
		
		int rootNode = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			Integer node = Integer.parseInt(st.nextToken());
			if(node==-1) {
				rootNode= i;
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
            List<Integer> result = dfs(graph, rootNode, removeNode);
            System.out.println(count);
        }
	}

	private static List<Integer> dfs(Map<Integer, List<Integer>> graph, int rootNode, int removeNode) {
		boolean[] visited = new boolean[graph.size()];//방문한 노드
		Queue<Integer> needVisit = new LinkedList<Integer>();
		
		needVisit.add(rootNode);
		
		while(needVisit.size()>0) {
			Integer currentNode = needVisit.remove(needVisit.size()-1);
			if(!visited)
		}
		
		return null;
	}
	
}

