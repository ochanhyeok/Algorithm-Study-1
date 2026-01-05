class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int h = 1; h * h <= total; h++) {
            if (total % h != 0) continue;

            int w = total / h; // w >= h

            // 테두리 1칸 제거한 내부가 yellow인지 확인
            if ((w - 2) * (h - 2) == yellow) {
                return new int[]{w, h};
            }
        }

        return new int[]{0, 0};
    }
}