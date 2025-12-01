import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i< s.length(); i++){
            char c = String.valueOf(s).charAt(i);
            if(stack.isEmpty()) stack.push(c);
            else{
                if(c == ')') {
                    if(stack.peek()=='(') {
                        stack.pop();
                        continue;
                    }else stack.push(c);
                }else if(c=='('){
                    stack.push(c);
                }
            }
        }
        
        return (stack.isEmpty())? true : false;
    }
}