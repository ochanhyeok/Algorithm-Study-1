import java.util.*; 
class Solution {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer =0 ; 
        
        for (int i=0; i<ability.length ; i++){
            queue.add(ability[i]);
        }
        
        for (int n=0; n <number; n++){
            int minNum1 = queue.poll();
            int minNum2 = queue.poll();
            
            queue.add(minNum1+ minNum2);
            queue.add(minNum1+ minNum2);
            
        }
        
        for(int q : queue){
            answer += q;
        }
        return answer;
    }
}