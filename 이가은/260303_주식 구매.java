class Solution {
        public int solution(int[] prices) {
        /**
         * buy1  : 첫 번째 주식을 들고 있는 상태에서의 최대 이익
         * sell1 : 첫 번째 거래(매수→매도) 끝난 상태의 최대 이익
         * buy2  : 두 번째 주식을 들고 있는 상태의 최대 이익
         * sell2 : 두 번째 거래까지 끝난 상태의 최대 이익
         */

        int buy1 = Integer.MIN_VALUE / 4; // 오버플로 발생 방지
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE / 4;
        int sell2 = 0;


        for (int p : prices) {
            buy1 = Math.max(buy1, -p);          // 1번째 매수
            sell1 = Math.max(sell1, buy1 + p);  // 1번째 매도
            buy2 = Math.max(buy2, sell1 - p);   // 2번째 매수
            sell2 = Math.max(sell2, buy2 + p);  // 2번째 매도
        }

        return Math.max(0, Math.max(sell1, sell2));
    }
}