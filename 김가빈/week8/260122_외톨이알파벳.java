import java.util.*;
class Solution {
    public String solution(String input_string) {
        String answer = "";
        Map<Character,Integer> map = new HashMap<>();
        
        char lastChar = input_string.charAt(0);
        
        for(int i=1; i<input_string.length(); i++){
            if(lastChar != input_string.charAt(i)){
                map.put(lastChar, map.getOrDefault(lastChar,0)+1);
            }
            lastChar = input_string.charAt(i);
        }
        map.put(lastChar, map.getOrDefault(lastChar,0)+1);

        
        StringBuilder sb = new StringBuilder();
        for( Character key : map.keySet()){
            if(map.get(key)>=2){
                sb.append(key);
            }
        }

        answer = (sb.length() == 0) ? "N" : sb.toString();
        return answer;
    }
}