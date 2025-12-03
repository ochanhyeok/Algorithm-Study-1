import java.util.*;
class Solution {
    public int solution(int[] order) {
        List<Integer> truck = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int idx = 0; 
        
        for(int i=1; i<=order.length;i++){
            if(i != order[idx]){
                stack.push(i);
            }else{
                truck.add(i);
                idx++;
                //보관컨베이어벨트 확인
                while(!stack.isEmpty() && stack.peek()==order[idx]){
                    truck.add(stack.pop());
                    idx++;
                }
            }
        }
        //남은 보관 컨베이어벨트 확인
        while(!stack.isEmpty() && stack.peek()==order[idx]){
            truck.add(stack.pop());
            idx++;
        }
        
        return truck.size();
    }
}