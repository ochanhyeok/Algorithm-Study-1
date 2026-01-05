import java.util.PriorityQueue;

class Solution {
    static int newFood = 0;
    
    public int solution(int[] scoville, int K) {
		    // 우선순위 큐: 우선순위가 높은 순서대로 나가는 구조
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size = scoville.length;
        int answer = 0;
        
        for (int i = 0; i < size; i++) {
            pq.offer(scoville[i]);
        }
        
        // 이미 최소 스코빌 지수값이 K 이상인 경우 (early return)
        if (pq.peek() >= K)
            return 0;
        
        int newFood = 0; // 새로운 음식
        while(pq.size() >= 2) {
            newFood = (pq.poll() + pq.poll()*2);
            pq.offer(newFood);
            answer++;
            
            if (pq.peek() >= K) {
                return answer;
            }
        }

        return -1;
    }
}