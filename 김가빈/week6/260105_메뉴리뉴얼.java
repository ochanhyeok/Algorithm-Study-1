import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList();
        Map<Character, Integer> orderMap = new HashMap();
        
        //각 단품 메뉴 카운팅을 쉽게 하기 위해 map활용
        for (int i=0; i<orders.length; i++) {
            for (int j=0; j<orders[i].length(); j++) {
                Character str = orders[i].charAt(j);
                orderMap.put(str,orderMap.getOrDefault(str, 0)+1);
            }
        }
        //map은 순서 보장X 따라서 list로 변환해 정렬함. 
        List<Map.Entry<Character, Integer>> orderList = orderMap.entrySet()
            .stream()
            .sorted((o1, o2) -> {
                return o2.getValue() - o1.getValue();
            })
            .collect(Collectors.toList());
        
         for (int c : course) {

            Map<String, Integer> combMap = new HashMap<>();
            int maxCount = 0;
            
            //주문한 개수가 현 코스 구성 개수보다 작으면 굳이 조합을 만들 필요X
            for (String order : orders) {
                if (order.length() < c) continue;

                char[] arr = order.toCharArray();
                Arrays.sort(arr);

                makeCombination(arr, 0, 0, c, new StringBuilder(), combMap);
            }
            
            //2개 이상 주문된 주문조합 중 가장 많이 주문된 조합 찾기 
            for (int cnt : combMap.values()) {
                if (cnt >= 2) {
                    maxCount = Math.max(maxCount, cnt);
                }
            }

            if (maxCount < 2) continue;
            //각 코스 구성의 주문 개수가 최댓값이랑 같으면 걔도 값에 추가해주기
            for (Map.Entry<String, Integer> e : combMap.entrySet()) {
                if (e.getValue() == maxCount) {
                    answer.add(e.getKey());
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    // 재귀로 조합을 만들고 그 조합을 맵을 이용해 개수를 셈. 
    public static void makeCombination(
            char[] order,
            int start,
            int depth,
            int target,
            StringBuilder sb,
            Map<String, Integer> map
    ) {
        if (depth == target) {
            String comb = sb.toString();
            map.put(comb, map.getOrDefault(comb, 0) + 1);
            return;
        }

        for (int i = start; i < order.length; i++) {
            sb.append(order[i]);
            makeCombination(order, i + 1, depth + 1, target, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}