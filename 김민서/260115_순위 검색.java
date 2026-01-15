import java.util.*;

class Solution {

    // 조건 조합 → 점수 리스트
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 1️⃣ info 정보로 map 구성
        for (String s : info) {
            String[] arr = s.split(" ");
            makeCombination(0, "", arr);
        }

        // 2️⃣ 점수 리스트 정렬 (이분탐색용)
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        // 3️⃣ query 처리
        for (int i = 0; i < query.length; i++) {
            answer[i] = processQuery(query[i]);
        }

        return answer;
    }

    // =======================
    // info 조합 생성
    // =======================
    private void makeCombination(int depth, String key, String[] arr) {

        // 4가지 조건 다 선택했으면
        if (depth == 4) {
            int score = Integer.parseInt(arr[4]);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }

        // 실제 값 사용
        makeCombination(depth + 1, key + arr[depth], arr);

        // "-" 사용
        makeCombination(depth + 1, key + "-", arr);
    }

    // =======================
    // query 처리
    // =======================
    private int processQuery(String q) {

        // "and" 제거
        q = q.replaceAll(" and ", "");
        String[] arr = q.split(" ");

        String key = arr[0];
        int score = Integer.parseInt(arr[1]);

        // 해당 조건이 없으면 0명
        if (!map.containsKey(key)) return 0;

        List<Integer> scores = map.get(key);

        // lower bound
        int left = 0;
        int right = scores.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (scores.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // score 이상 개수
        return scores.size() - left;
    }
}
