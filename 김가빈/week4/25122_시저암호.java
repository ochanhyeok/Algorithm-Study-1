import java.util.*;
import java.io.*;
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' ') {
                sb.append(' ');
            } else if (c >= 'a' && c <= 'z') {
                //처음에 아무 생각 없이 -a만 하면 나올 줄 알았는데 -> 이러면 그냥 26이 나옴.. 따라서 26으로 나눠서 각 순서에 따라 알파벳 출력할 수 있도록 처리
                sb.append((char)((c + n - 'a')%26+'a'));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char)((c + n - 'A')%26+'A'));
            }
        }
        
        return sb.toString();
    }
}