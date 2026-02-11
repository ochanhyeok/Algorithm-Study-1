import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int a : ability) {
            pq.offer(a);
        }
        
        for (int i = 0; i < number; i++) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            
            pq.offer(min1+min2);
            pq.offer(min1+min2);
        }
        
        int answer = 0;
        for (int a : pq) {
            answer += a;
        }

        return answer;
    }
}