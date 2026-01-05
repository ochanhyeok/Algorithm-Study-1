import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int remainingDays =
                (int) Math.ceil((double) remainingWork / speeds[i]);
             queue.offer(remainingDays);
         }
        
        int releaseDay = queue.poll();
        int days = 1;
        while(!queue.isEmpty()){
            if(queue.peek() <= releaseDay ){
                days++;
                queue.poll(); // 배포날은 업데이트 X
            }
            else {
                answer.add(days);
                days =1;
                releaseDay = queue.poll(); //배포날 업데이트
                    
            }
        }
        answer.add(days);
        return answer.stream().mapToInt(i->i).toArray();
    }
}