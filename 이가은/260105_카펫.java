class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int width = 3;
        
        while (true) {
            for (int height = 3; height <= width; height++) {
                int brownCnt = width * 2 + (height - 2) * 2;
                int yellowCnt = width * height - brownCnt;
                
                if (brownCnt == brown && yellowCnt == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    return answer;
                }
            }
            
            width++;
        }
    }
}