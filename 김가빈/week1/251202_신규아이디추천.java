import java.util.*;
class Solution {
    public String solution(String new_id) {
    
        new_id = new_id.toLowerCase();
        
        String[] str = new_id.split("");
        for(int i=0; i<str.length; i++){
            if(!str[i].matches("[a-z0-9-_.]")) new_id = new_id.replace(str[i],"");
        }
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=0; i<new_id.length(); i++){
            char c = String.valueOf(new_id).charAt(i);
            if('.'==c && !flag) {
                sb.append(c);
                flag = true;
            }else if('.'==c && flag){
                continue;   
            }else {
                sb.append(c);
                flag = false;
            }
        }
        
        
        
        if(sb.indexOf(".")==0 && sb.length()>=1) sb.delete(0,1);
        if(sb.lastIndexOf(".")==sb.length()-1 && sb.length()>=1) sb.delete(sb.length()-1,sb.length());
  
        if(sb.length()==0) sb.append("a");
  
        if(sb.length() >= 16) {
            sb.delete(15, sb.length());    
            if(sb.lastIndexOf(".")==sb.length()-1) sb.delete(sb.length()-1,sb.length());
        }
        
        new_id = sb.toString();
        
        if(new_id.length() <= 2){
            String s = sb.delete(0, sb.length()-1).toString();
            while(new_id.length()<3){
                new_id+=s;
            }
        }

        return new_id;
    }
}