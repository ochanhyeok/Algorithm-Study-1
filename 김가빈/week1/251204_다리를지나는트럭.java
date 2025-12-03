import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int total = 0;
        int idx = 0;
        
        //현재 다리 길이만큼 0으로 초기화 
        for (int i = 0; i < bridge_length; i++) queue.offer(0);

        //시간은 항상 1초씩 증가해야 함. 
        while (idx < truck_weights.length) {
            time++;

            total -= queue.poll();

            if (total + truck_weights[idx] <= weight) {
                queue.offer(truck_weights[idx]);
                total += truck_weights[idx++];
                
            } else {
                // 트럭 못 올리면 대기하는 만큼 0을 추가 => 이로써 대기 시간을 따로 카운팅 하지 않아도 됨 
                queue.offer(0);
            }
        }

        // 마지막 트럭이 다리에서 빠져나가는 시간 추가
        return time + bridge_length;
    }
}