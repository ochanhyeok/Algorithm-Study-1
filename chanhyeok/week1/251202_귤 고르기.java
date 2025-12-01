import java.util.*;
import java.util.stream();

class solution{
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // map에 (크기 : 갯수) 로 저장 -> 값 기준 내림차순 정렬 -> 갯수가 가장 많은 크기부터 cnt
        for(int n : tangerine){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedList = map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue());

        //sortedList.forEach(entry -> System.out.println(entry.getKey() + ", " + entry.getValue()));

        for(Map.Entry<Integer, Integer> entry : sortedLsit){
            int size = entry.getKey();
            int cnt = entry.getValue();

            k -= cnt;
            answer++;
            if(k <= 0){
                break;
            }
        }

        return answer;
    }
}