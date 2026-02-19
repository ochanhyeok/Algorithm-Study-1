import java.util.*;


class Solution {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int[][] visited;
    static int id=1;
    public int solution(int[][] land) {
        int answer = 0;
        visited = new int[land.length][land[0].length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int j=0; j<land[0].length; j++) {
            for (int i=0; i<land.length; i++) {
                if (land[i][j] == 1 && visited[i][j]==0) {
                    int totalSum = dfs( i, j, 0, land);
                    map.put(id, totalSum);
                    id++;
                } 
            }
        }
        
        for (int j=0; j<land[0].length; j++) {
            Set<Integer> set = new HashSet<>();
            int totalSum=0;
            for (int i=0; i<land.length; i++) {
                if (visited[i][j] != 0 && !set.contains(visited[i][j])) {
                totalSum += map.get(visited[i][j]);   
                set.add(visited[i][j]);
                }
            }
            answer = Math.max(answer,totalSum);
        }
        
        return answer;
    } 
    
    public int dfs(int i, int j, int cnt, int[][] land) {
    
        if ( visited[i][j]!= 0) return cnt;
        
        visited[i][j] = id;
        cnt+=1;
        
        for(int k=0; k<4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            
            if (ni<0 || nj<0 || ni>= land.length || nj >= land[0].length) continue;
            if (land[ni][nj]==1 && visited[ni][nj]==0) {
            cnt = dfs(ni, nj, cnt, land);
            }
        }
        return cnt;
    }
}