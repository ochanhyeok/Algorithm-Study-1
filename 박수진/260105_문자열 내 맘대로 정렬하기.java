import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int c = Character.compare(o1.charAt(n), o2.charAt(n)); // n번째 문자 비교
                if (c != 0) return c;                                  // 다르면 그 결과 리턴
                return o1.compareTo(o2);                               // 같으면 전체 문자열 사전순
            }
        });
        return strings;
    }
}