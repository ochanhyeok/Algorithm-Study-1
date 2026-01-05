import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        
        for(int i : scoville) {
            pq.offer(i);    
        }
        
        while(pq.size() >= 2 && pq.peek() < K) {
            int m1 = pq.poll();
            int m2 = pq.poll();
            
            pq.offer(m1 + 2 * m2);
            cnt++;
        }
        
        if(pq.peek() < K) return -1;
        
        return cnt;
    }
}