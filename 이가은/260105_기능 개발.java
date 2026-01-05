import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution{

	public int[] solution(int[] progresses, int[] speeds) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Integer[] progressesArr = IntStream.range(1,progresses.length + 1).boxed().toArray(Integer[]:: new);
        Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(progressesArr));
        List<Integer> complete = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
        	map.put(i + 1, (int) Math.ceil((100.0 - progresses[i])/ speeds[i]));
        }
        
        while (!queue.isEmpty()) {
      
        	int priorityTask = queue.poll();
        	
        	int days = map.get(priorityTask);
        	int count = 0;
        	count++;
        	
        	for (int task : queue) {
        		int remain = map.get(task);
        		map.put(task, remain - days);      
        		if (map.get(task) <= 0 && queue.element() == task) {
        			queue.poll();
        			count++;
        		}
        	}
        	
        	complete.add(count);
        }
        
        return complete.stream().mapToInt(i -> i).toArray();
    }
	
}
