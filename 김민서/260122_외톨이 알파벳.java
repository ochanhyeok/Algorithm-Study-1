import java.util.*;

class Solution {
    public String solution(String input_string) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        List<Character> answer = new ArrayList<>();
        
        for(char i : input_string.toCharArray()) {
            if(!list.isEmpty() && list.contains(i) && list.get(list.size() - 1) != i && !answer.contains(i)) {
                answer.add(i);
            } 
            list.add(i);
        }
        
        if(answer.isEmpty()){
            return "N";
        }
        
        Collections.sort(answer);
        
        for(char c : answer) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}