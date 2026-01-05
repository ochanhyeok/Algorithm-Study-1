class Solution {
    public int[] solution(int brown, int yellow) {
        //전체 타일 수 
        int total = brown + yellow;

        //카펫 구조 : 전체가로 = 노랑가로 +2 w, 
        //카펫 구조 : 전체세로 = 노랑세로 +2 h, 
        // w*h 를 곱하면 전체 넓이가 나오는데, 이게 total 개수랑 같냐. 
        for (int h = 1; h * h <= yellow; h++) { //노란색의 약수를 순회. 
            if (yellow % h == 0) {
                int w = yellow / h;
                int width = w + 2;
                int height = h + 2;

                if (width * height == total) {
                    return new int[]{width, height};
                }
            }
        }
        return new int[0];
    }
}
