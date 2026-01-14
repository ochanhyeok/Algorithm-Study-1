class Solution {
    public int solution(int n) {
        StringBuilder three = new StringBuilder("");
        
        for (int i=n; i!=0; i/=3) {
            three.append(i%3);
        }

        // 다시 10진법으로 변환
        int answer = 0;
        int pow = 1;
        for (int k=three.length()-1; k>=0; k--) {
            int digit = three.charAt(k) - '0';
            answer += digit * pow;
            pow *= 3;
        }
        
        return answer;
    }
}