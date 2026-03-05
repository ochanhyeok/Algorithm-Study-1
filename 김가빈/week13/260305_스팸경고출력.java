import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        String[][] approved = {
                {"123-4567", "451-2314", "015-1643"},
                {"123-1000"}
        };

        String[][] spams = {
                {"111-1111"},
                {"456-2000"}
        };

        String[][] calls = {
                {"123-4567", "000-0022", "015-1643", "000-0022", "111-1111", "000-0022", "111-1111", "111-1111"},
                {"456-2000", "456-2000", "123-1000", "123-1000", "789-3000", "789-3000", "789-3000", "789-3000", "789-3000"}
        };

        int[] k = {2, 3};


        for(int i=0; i<2; i++){
            int[] answer = solution(approved[i], spams[i], calls[i], k[i]);
            System.out.println(Arrays.toString(answer));
        }

    }

    public static int[] solution(String[] approved, String[] spams, String[] calls, int k) {
        int[] answer = new int[calls.length];
        List<String> approvedList = Arrays.asList(approved);
        List<String> spamsList = Arrays.asList(spams);
        Map<String, Integer> callMap = new HashMap<>();

        for(int i=0; i< calls.length;i++){
            String call = calls[i];
            callMap.put(call, callMap.getOrDefault(call,0)+1);

            //스팸목록에 있다면 1로 표시
            if(spamsList.contains(call)) answer[i] = 1;
            //전화번호 목록에 있다면 0으로 표시
            else if(approvedList.contains(call)) answer[i] = 0;
            //둘다 아닌 경우에 calls에서 count하여 해당 개수가 k를 초과하면 answer[i]에 추가
            else {
                if(callMap.containsKey(call)) {
                    if(callMap.get(call) <= k) {
                        answer[i] = 1;
                    } else answer[i] =0;
                }
            }
        }

        return answer;
    }

}
