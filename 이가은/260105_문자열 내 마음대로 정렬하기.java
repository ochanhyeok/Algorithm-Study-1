import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, (a,b) -> {
            
            String aStr = a.charAt(n) + "";
            String bStr = b.charAt(n) + "";
            
            if (aStr.equals(bStr)) {
                return a.compareTo(b);
            } else {
                return aStr.compareTo(bStr);
            }
            
        });
        
        return strings;
    }
}