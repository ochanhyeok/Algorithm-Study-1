import java.util.*;

class Solution {
    public int solution(String s) {
        
        Map<String, String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
    
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        String[] str = s.split("");
        for(int i=0; i<str.length; i++){
            if(str[i].matches("[a-z]")){
                sb.append(str[i]);
                if(map.containsKey(sb.toString())){
                    answer.append(map.get(sb.toString()));
                    sb.delete(0, sb.length());
                    continue;
                }
                    
            }else answer.append(str[i]);
            // System.out.println(i + " "+ answer + " " + sb);
        }
        
        return Integer.parseInt(answer.toString());
    }
}