import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    public String solution(String input_string) {
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> outsider = new HashMap<>(); // (외톨이 알파벳, 인덱스)
        
        for (int k = 0; k < input_string.length(); k++) {
            char ch = input_string.charAt(k);
            if (outsider.containsKey(ch)) {
                if (outsider.get(ch) == k - 1) {
                    outsider.put(ch, k);
                }
                else {
                    ans.append(input_string.charAt(k));
                }
            } else {
                outsider.put(ch, k);
            }
        }

        
        String result = ans.chars()
                        .distinct()
                        .sorted()
                        .mapToObj(c -> String.valueOf((char)c))
                        .collect(Collectors.joining());

        if (result.length() == 0) {
            return "N";
        }
        
        return result;
    }
}