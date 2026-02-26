import java.util.*;
//크루스칼알고 + 유니온파인드 => 스패닝 없이, 최소 경로 찾기 
class Solution {
    static class Edge {
        int i;
        int j;
        int cost; 
        
        Edge(int i, int j, int cost){
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
    static int[] parent;
    static int[] rank;
    
    //find 함수 -> 부모 노드 찾기
    public int find(int num){
        if(parent[num] == num) return num; 
        parent[num] = find(parent[num]);
        return parent[num];
    }
    //union 함수 -> 깊이 비교헤서 더 짧은 그룹을 긴 그룹에 붙이기 
    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;

        if(rank[pa] > rank[pb]) parent[pb] = pa;
        else if(rank[pa] < rank[pb] ) parent[pa] = pb;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
        return true; 
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Edge> graph = new ArrayList<>(); 
        for(int i=0; i<costs.length; i++){
            graph.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        Collections.sort(graph, (a,b)->{
            return a.cost - b.cost;
        });
        
     //   graph.stream()
     // .forEach(i -> System.out.println(i.cost));
        
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i; 
        }
        
        int totalCost = 0;
        int used = 0;

        for (Edge e : graph) {
            if (union(e.i, e.j)) {
                totalCost += e.cost;
                used++;
                if (used == n-1) break; 
            }
        }   
        
        return totalCost;
    }
}