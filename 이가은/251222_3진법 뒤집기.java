class Solution {
    public int solution(int n) {
        int answer = 0;
        int k = 0;
        
        while (true) {
            if (n >= Math.pow(3, k)) {
                k++;
            } else {
                break;
            }
        }
        
        StringBuilder three = new StringBuilder();
        
        for (int i = k - 1; i >= 0; i--) {
            int num = 0;
            
            for (int j = 2; j >= 0; j-- ) {
                double t = Math.pow(3, i) * j;
                if (t <= n) {
                    n -= t;
                    num = j;
                    break;
                }
            }
            three.append(num);
        }
        
        char[] cArr = three.reverse().toString().toCharArray();
        
        for (int i = 0; i <= cArr.length - 1; i++) {
            int number = Character.getNumericValue(cArr[i]);
            answer += Math.pow(3, cArr.length - i - 1) * number;
        }
        
        return answer;
    }
}