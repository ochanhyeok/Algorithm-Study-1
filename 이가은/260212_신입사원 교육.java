import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n: ability) {
            pq.add(n);
        }
        
        for (int i = 0; i < number; i++) {
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }
        
        int sum = 0;
        while(!pq.isEmpty()) sum += pq.poll();
        return sum;
    }
}