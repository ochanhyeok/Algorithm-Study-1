import java.util.*;

class Solution {
    static HashMap<Integer, Integer> parent = new HashMap<>();
    static HashMap<Integer, Integer> rank = new HashMap<>();
    public int solution(int n, int[][] costs) {
        List<Integer> vertices = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            vertices.add(i);
        }
        
        List<Edge> edges = new ArrayList<>();
        
        for(int i = 0; i < costs.length; i++) {
            edges.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        int len = kruskal(vertices, edges);
        
        return len;
    }
    
    Integer find(Integer node) {
        if(parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }
    
    void union(Integer nodeS, Integer nodeE) {
        Integer root1 = find(nodeS);
        Integer root2 = find(nodeE);
        
        if(rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if(rank.get(root1) == rank.get(root2)) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }
    
    void makeSet(Integer node) {
        parent.put(node, node);
        rank.put(node, 0);
    }
    
    int kruskal(List<Integer> vertices, List<Edge> edges) {
        Edge currentEdge;
        int len = 0;
        
        for(int i = 0; i < vertices.size(); i++) {
            makeSet(vertices.get(i));
        }
        
        Collections.sort(edges);
        
        for(int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            if(find(currentEdge.nodeS) != find(currentEdge.nodeE)) {
                union(currentEdge.nodeS, currentEdge.nodeE);
                len += currentEdge.weight;
            }
        }
        return len;
    }
}

class Edge implements Comparable<Edge> {
    public Integer nodeS;
    public Integer nodeE;
    public int weight;
    
    public Edge(Integer nodeS, Integer nodeE, int weight) {
        this.nodeS = nodeS;
        this.nodeE = nodeE;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}