import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i< tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        List<int[]> list = new ArrayList<>();
        for(int num : map.keySet()){
            list.add(new int[]{ num, map.get(num)});
        }
        
        Collections.sort(list, (o1,o2)->{
            return o2[1] - o1[1];
        });
            
        int answer =0;
        for(int[] arr : list){
            if (k<=0) break;
            k -= arr[1];
            answer++;
        }
        
        return answer;
    }
}