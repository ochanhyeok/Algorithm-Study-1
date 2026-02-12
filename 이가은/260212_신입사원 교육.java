import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        for (int i = 0; i < number; i++) {
            Arrays.sort(ability);
            
            int sum = ability[0] + ability[1];
            ability[0] = sum;
            ability[1] = sum;
        }
        
        return Arrays.stream(ability).sum();
    }
}