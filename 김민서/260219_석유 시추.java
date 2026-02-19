import java.util.*;

class Solution {
    static boolean[][] visited;
    int cnt = 0;
    int[][] groupbd;
    int groupId = 1;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] land) {
        
        groupbd = new int[land.length][land[0].length];
        Map<Integer, Integer> group = new HashMap<>();
        
        visited = new boolean[land.length][land[0].length];
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    
                    cnt = 0;
                    
                    findOil(land, i, j);
                    
                    group.put(groupId, cnt);
                    
                    groupId++;
                }    
            }
        }
        
        int max = 0;
        
        for(int i = 0; i < land[0].length; i++) {
            
            int liter = 0;
            Set<Integer> used = new HashSet<>();  // 그룹 중복으로 들어가는거 막음
            
            for(int j = 0; j < land.length; j++) {
                int id = groupbd[j][i];

                if(id != 0 && !used.contains(id)) {
                    liter += group.get(id);
                    used.add(id);
                }
            }
            
            if(liter >= max) {
                max = liter;
            }
        }
        
        return max;
    }
    
    void findOil(int[][] land, int x, int y) {
        
        if(x < 0 || y < 0 || x >= land.length || y >= land[0].length) {
            return;
        }
        
        if(visited[x][y] || land[x][y] == 0) {
            return;
        }
        
        visited[x][y] = true;
        cnt++;
        groupbd[x][y] = groupId;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            findOil(land, nx, ny);
        }
    }
}