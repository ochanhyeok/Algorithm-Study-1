import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<Integer>();
        for(int a=0; a<bridge_length; a++){
            bridge.add(0);   
        }
        int cw = 0;
        int time = 0;
        int truck = 0;
        while(truck<truck_weights.length){
            time++;
            cw -= bridge.poll();
            if(cw + truck_weights[truck]<=weight){
                bridge.add(truck_weights[truck]);
                cw += truck_weights[truck];         
                truck++;
            }else{
                bridge.add(0);
            }
        }
        return time + bridge_length;
    }
}