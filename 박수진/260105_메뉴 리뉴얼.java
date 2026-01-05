import java.util.*;

class Solution {
    Map<String, Integer> countMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        // 1) 주문 문자열 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }

        List<String> answerList = new ArrayList<>();

        // 2) 코스 길이별로 처리
        for (int len : course) {
            countMap.clear();

            // 2-1) 모든 주문에서 길이 len 조합 생성하여 카운팅
            for (String order : orders) {
                if (order.length() < len) continue;
                comb(order, 0, len, new StringBuilder());
            }

            // 2-2) 해당 길이에서 최대 등장 횟수 찾기
            int max = 0;
            for (int v : countMap.values()) {
                max = Math.max(max, v);
            }

            // 2-3) max가 2 이상인 조합만 결과에 추가
            if (max >= 2) {
                for (Map.Entry<String, Integer> e : countMap.entrySet()) {
                    if (e.getValue() == max) {
                        answerList.add(e.getKey());
                    }
                }
            }
        }

        // 3) 전체 사전순 정렬
        Collections.sort(answerList);

        return answerList.toArray(new String[0]);
    }

    // order에서 길이 targetLen 조합을 생성
    private void comb(String order, int start, int targetLen, StringBuilder sb) {
        if (sb.length() == targetLen) {
            String key = sb.toString();
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            comb(order, i + 1, targetLen, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
