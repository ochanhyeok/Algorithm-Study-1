import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < bridge_length; i++){
            q.offer(0);
        }

        int time = 0;
        int idx = 0;
        int cur_weight = 0;
        while(idx < truck_weights.length){
            time++;
            cur_weight -= q.poll();

            if(cur_weight + truck_weights[idx] <= weight){
                q.offer(truck_weights[idx]);
                cur_weight += truck_weights[idx];
                idx++;
            } else {
                q.offer(0);
            }
        }

        // whlie문이 끝나면 마지막트럭은 다리에 막 들어선 상태기 때문에 다리길이만큼 더해줘야 함
        return time + bridge_length;
    }
}