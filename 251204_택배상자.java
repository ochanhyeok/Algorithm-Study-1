import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int box = 1;
        Stack<Integer> stack = new Stack<Integer>();
        for(int j=0; j<order.length; j++){
            while(box <= order.length && box < order[j]){
                stack.push(box);
                box++;
            }
            if(order[j] == box){
                box++;
                answer++;
            } else if(!stack.isEmpty() && order[j] == stack.peek()) {
                stack.pop();
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}