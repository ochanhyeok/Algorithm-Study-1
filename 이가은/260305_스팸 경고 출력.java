import java.util.*;

class Solution {
    public int[] solution(String[] approved, String[] spams, String[] calls, int k) {
        Set<String> approvedSet = new HashSet<>(Arrays.asList(approved));
        Set<String> spamSet = new HashSet<>(Arrays.asList(spams));

        Map<String, Integer> cnt = new HashMap<>();
        int[] answer = new int[calls.length];

        for (int i = 0; i < calls.length; i++) {
            String num = calls[i];

            if (spamSet.contains(num)) {
                answer[i] = 1;
                continue;
            }

            if (approvedSet.contains(num)) {
                answer[i] = 0;
                continue;
            }

            int newCount = cnt.getOrDefault(num, 0) + 1;
            cnt.put(num, newCount);
            answer[i] = (newCount <= k) ? 1 : 0;
        }

        return answer;
    }
}
