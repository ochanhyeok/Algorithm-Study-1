import java.util.*;

class Solution {
	public int solution(int[] ability, int number) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i = 0; i < ability.length; i++){
			pq.offer(ability[i]);
		}

		for(int i = 0; i < number; i++){
			int totalEx = pq.poll() + pq.poll();

			pq.offer(totalEx);
			pq.offer(totalEx);
		}

		int size = pq.size();
		for(int i = 0; i < size; i++){
			answer += pq.poll();
		}

		return answer;
	}
}