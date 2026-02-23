import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        //1번째->5^0 ~ 5^4 /2번째 5^0~5^3 ...
        int[] weight = {781, 156, 31, 6, 1};
        String str = "AEIOU";
        
        for(int i=0; i<word.length(); i++){
            int idx = str.indexOf(word.charAt(i));
            answer += idx * weight[i] + 1; //해당 글자까지의 단어 개수들을 한 번에 더함 
        }
        return answer;
    }
}