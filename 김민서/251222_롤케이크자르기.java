import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();

        // 오른쪽 전체 토핑 개수 세기
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        // 자르는 지점 이동
        for (int t : topping) {
            left.add(t);

            right.put(t, right.get(t) - 1);
            if (right.get(t) == 0) {
                right.remove(t);
            }

            if (left.size() == right.size()) {
                answer++;
            }
        }

        return answer;
    }
}