import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while (queue.size() >= 2 && queue.peek() < K) {
            int first = queue.poll();
            
            int second = queue.poll();
            
            int result = first + second * 2;
            
            queue.add(result);
            
            answer++;
        }
        
        
        return queue.peek() >= K ? answer : -1 ;
    }
}