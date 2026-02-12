import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> abil = new PriorityQueue<>();
        int answer = 0;
        
        for(int i = 0; i < ability.length; i++) {
            abil.offer(ability[i]);
        }
        
        for(int i = 0; i < number; i++) {
            int n = abil.poll();
            int m = abil.poll();
            
            abil.offer(n + m);
            abil.offer(n + m);
        }
        
        for(int i = 0; i < ability.length; i++) {
            answer += abil.poll();
        }
        
        return answer;
    }
}