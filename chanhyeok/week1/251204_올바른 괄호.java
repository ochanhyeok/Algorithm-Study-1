import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            // 여는 괄호면 일단 저장
            if(ch == '('){
                stk.push(ch);
            } else {
                // 닫는 괄호일 때 스택이 비어있는 상태면 false
                if(stk.isEmpty()){
                    return false;
                }
                // pop
                stk.pop();
            }
        }

        // 스택이 남아있으면 false반환
        return stk.isEmpty();
    }
}