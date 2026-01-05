import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            queue.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        while(!queue.isEmpty()){
            int cnt = 1;
            int date = queue.poll();
            while(!queue.isEmpty() && queue.peek() <= date){
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }
        int [] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}