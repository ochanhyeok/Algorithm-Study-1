import java.util.*;

class Solution {
  int[] solution(String[] approved, String[] spams, String[] calls, int k) {
    int[] answer = new int[calls.length];

    // 전화번호별 착신 횟수
    // [opti] '전화번호'마다 '횟수'를 저장해야 할 때, Map 사용이 최선인가
    Map<String, Integer> cnt = new HashMap<>();

    for (int s = 0; s < calls.length; s++) {
      String c = calls[s];

      boolean nxt = false;

      // 1. spam이면 항상 1
      for (int i = 0; i < spams.length; i++) {
        if (spams[i].equals(c)) {
          answer[s] = 1;
          nxt = true;
          break;
        }
      }

      if (nxt)
        continue;

      // 2. approved면 항상 0
      for (int i = 0; i < approved.length; i++) {
        if (approved[i].equals(c)) {
          answer[s] = 0;
          nxt = true;
          break;
        }
      }
      
      if (nxt)
        continue;

      // calls 순회하면서 착신 횟수 카운트
      cnt.put(c, cnt.getOrDefault(c, 0) + 1);

      // 3. 전화 횟수 >= k 확인
      if (cnt.get(c) <= k)
        answer[s] = 1;
    }

    return answer;
  }
}