import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] prices = {
                {1, 2, 3, 4},
                {1, 2, 4, 1, 2, 3},
                {4, 3, 2, 1, 4},
                {4, 3, 2, 1},
                {1, 10, 5, 11, 7}
        };

        for (int[] price : prices) {
            int answer = solution(price);
            System.out.println("result: " + answer);
        }
    }


    // 하루에 할 수 있는 행동(유지/매수/매도)는 next 배열에서 계산하고 dp에는 하루가 끝나면 계산이 끝난 next를 dp로 교체하는 구조
    public static int solution(int[] prices) {
        int minValue = Integer.MIN_VALUE;

        int[][] dp = new int[3][3];
        for(int i=0; i<3;i++) Arrays.fill(dp[i], minValue);
        dp[0][0] = 0;

        for(int p : prices) {
            int[][] next = new int[3][3];
            for(int j=0; j<3; j++) Arrays.fill(next[j], minValue);
            next[0][0] = 0;

            for(int buy=0; buy<3; buy++){
                for(int sell=0; sell<3; sell++ ){
                    int cur = dp[buy][sell];
                    if(cur==minValue) continue;

                    //유지
                    next[buy][sell] = Math.max(next[buy][sell], cur);

                    //매수
                    if(buy<2){
                        next[buy+1][sell] = Math.max(next[buy+1][sell], cur-p );
                    }

                    //매도
                    if(buy>0 && sell<2){
                        next[buy-1][sell+1] = Math.max(next[buy-1][sell+1], cur+p );
                    }

                }
            }
            dp=next;
        }
        int ans = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])); //각 거래의 경우에서 최댓값 찾기
        return Math.max(0, ans);
    }
}