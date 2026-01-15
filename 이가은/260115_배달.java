import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] dij = new int[N + 1][2];
        boolean[] visited = new boolean[N + 1];
        int visitCnt = 0;
        Map<Integer, List<int[]>> roadMap = new HashMap<>();
        
        for (int[] r: road) {
            roadMap.computeIfAbsent(r[0], k -> new ArrayList<>()).add(new int[] {r[1], r[2]});
            roadMap.computeIfAbsent(r[1], k -> new ArrayList<>()).add(new int[] {r[0], r[2]});
        }
        
        for (int i = 2 ; i < N + 1; i++) {
            dij[i] = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        }
       
        while (visitCnt < N) {
            int index = IntStream.rangeClosed(1, N).filter(i -> !visited[i]).boxed().min(Comparator.comparingInt(i -> dij[i][0])).orElse(-1);
            
            visited[index] = true;
            visitCnt++;
            
            for (int[] roadInfo: roadMap.get(index)){
                int village = roadInfo[0];
                if (visited[village]) continue;
                if (dij[village][0] > dij[index][0] + roadInfo[1]) {
                    dij[village][0] = dij[index][0] + roadInfo[1];
                    dij[village][1] = index;
                }
            }
            
        }

        return IntStream.rangeClosed(1, N).filter(i -> dij[i][0] <= K).toArray().length;
    }
}