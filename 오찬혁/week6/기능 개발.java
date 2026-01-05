import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> progressQueue = new LinkedList<>();
		Queue<Integer> speedQueue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();

		for(int i = 0; i < progresses.length; i++){
			progressQueue.offer(progresses[i]);
			speedQueue.offer(speeds[i]);
		}

		while(!progressQueue.isEmpty()){
			int size = progressQueue.size();

			// 1일치 진행량
			for(int i = 0; i < size; i++){
				int progress = progressQueue.poll() + speedQueue.peek();
				int speed = speedQueue.poll();
				progressQueue.offer(progress);
				speedQueue.offer(speed);
			}

			int cnt = 0;
			while(!progressQueue.isEmpty() && progressQueue.peek() >= 100){
				progressQueue.poll();
				speedQueue.poll();
				cnt++;
			}

			if(cnt > 0){
				result.add(cnt);
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
}