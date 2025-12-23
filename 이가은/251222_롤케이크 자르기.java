import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> brotherToppingMap = new HashMap<>();
        Set<Integer> cheolsu = new HashSet<>();
        Set<Integer> brother = new HashSet<>();
        
        for (int t: topping) {
            brotherToppingMap.put(t, brotherToppingMap.getOrDefault(t, 0) + 1);
            brother.add(t);
        }
        
        for (int i = 0; i < topping.length; i++) {
            int t = topping[i];
            cheolsu.add(t);
            brotherToppingMap.put(t, brotherToppingMap.get(t) - 1);
            
            if (brotherToppingMap.get(t) == 0)  brother.remove(t);
            
            if (cheolsu.size() == brother.size()) answer++;
        }
        
        return answer;
    }
}