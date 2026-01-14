class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder("");
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(' ');
                continue;
            } 
            int ascii = c;
            
            if ('a' <= c && c <= 'z') {  // 2) 소문자 처리
                ascii = ascii + n;
                if (ascii > 'z') ascii -= 26;
            } else if ('A' <= c && c <= 'Z') { // 3) 대문자 처리
                ascii = ascii + n;
                if (ascii > 'Z') ascii -= 26;
            }
            
            answer.append((char)ascii);
        }
        return answer.toString();
    }
}