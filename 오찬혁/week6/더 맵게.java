import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int cnt = 0;

		for(int i = 0; i < scoville.length; i++){
			pq.offer(scoville[i]);
		}

		while(!pq.isEmpty() && pq.peek() < K){
			if(pq.size() < 2){
				return -1;
			}

			int sco1 = pq.poll();
			int sco2 = pq.poll();
			int newSco = sco1 + (sco2 * 2);

			pq.offer(newSco);
			cnt++;
		}

		return cnt;
	}
}