class Solution {
    public int solution(String word) {
        int answer = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int start = ((int)Math.pow(5, 5-i) - 1) / 4; // 등비수열 합
            
            switch(word.charAt(i)) {
                case 'A' :
                    answer += 1;
                    break;
                case 'E' :
                    answer += start + 1;
                    break;
                case 'I' :
                    answer += start * 2 + 1;
                    break;
                case 'O' :
                    answer += start * 3 + 1;
                    break;
                case 'U' :
                    answer += start * 4 + 1;
                    break;
            }
        }
        
        return answer;
    }
}