import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> stk = new Stack<>();

        for(int i = 1; i <= order.length; i++){
            // 스택에 저장 후 비교
            stk.push(i);

            // 순서와 맞을때까지 반복
            while(!stk.isEmpty() && stk.peek() == order[idx]){
                stk.pop();
                idx++;
                answer++;
            }
        }

        return answer;
    }
}