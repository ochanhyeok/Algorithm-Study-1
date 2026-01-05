import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length;i++){
            queue.offer(scoville[i]);
        }
        
        //우선순위 큐이므로 제일 낮은 지수가 peek
        while(queue.peek() < K){
            // 큐에 스코빌지수가 k보다 작은 수가 단 1개 남은경우
            // 새로운 스코널 지수 생성 X
            if(queue.size()==1) return -1; 
            
            queue.offer(queue.poll()+(queue.poll()*2));
            answer++;
        }
        
        return answer;
    }
}