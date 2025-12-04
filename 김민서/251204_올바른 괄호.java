import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char i : s.toCharArray()){
            if(i==')' && stack.isEmpty()) return false;
            else if(i==')' && !stack.isEmpty()) stack.pop();
            else stack.push(i);
        }
        if(!stack.isEmpty()) return false;
        else return true;
    }
}