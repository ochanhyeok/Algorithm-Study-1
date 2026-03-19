import java.util.*;

class Main {
    public static void main (String[] args) {
        int[][] predicts = {
            {1,13,15,12,3,1,10},
            {0,10,0,8,0,12},
            {11,3,1,6,20,7,1,0,0}
        };

        int[] kList = {
            4,1,6
        };

        for(int i=0; i<3; i++){
            int[] answer = solution(predicts[i], kList[i]);
            System.out.println(Arrays.toString(answer));
        }
    }

    static public int[] solution(int[] predict, int k){
        int[] result = new int[predict.length];
        int[] left = new int[predict.length];
        int[] right = new int[predict.length];
        int[] need = new int[predict.length];
        
        //각 날짜의 최소 필요 발전량 -> k배수일 겨웅
        for(int i=0; i<predict.length;i++){
            need[i] = ((predict[i]+k-1)/k)*k ;  
        }

        //이전 날짜가 너무 크면 현재 날짜도 최소 이전값-k
        left[0] = need[0];
        for(int i=1; i<predict.length;i++){
            left[i] = Math.max(need[i], left[i-1]-k);
        }

        //이후 날짜 값이 크면 현재 날짜도 커져야함.
        right[predict.length-1] = need[predict.length-1];
        for(int i=predict.length-2; i>=0 ;i--){
            right[i] = Math.max(need[i], right[i+1]-k);
        }

        //왼쪽 오른쪽 중 큰 것
        for(int i=0; i<predict.length; i++){
            result[i] = Math.max(left[i], right[i]);
        }

        return result;
    }
}