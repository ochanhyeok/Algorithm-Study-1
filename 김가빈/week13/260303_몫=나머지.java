 import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        int[] nums = {2,3,4};

        for(int n : nums) {
            int answer = solution(n);
            System.out.println("result: " + answer);
        }
    }


    // 하루에 할 수 있는 행동(유지/매수/매도)는 next 배열에서 계산하고 dp에는 하루가 끝나면 계산이 끝난 next를 dp로 교체하는 구조
    public static int solution(int n) {
        int answer = 0;

        for (int div=1; div<n; div++){
            answer += (n+1)*div;
        }
        return answer;
    }
}
