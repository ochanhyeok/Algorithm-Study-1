import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i <= 9; i++){
            map.put(arr[i], i);
        }

        for(String key : map.keySet()){
            s = s.replaceAll(key, String.valueOf(map.get(key)));
        }

        System.out.println(s);

        return Integer.parseInt(s);
    }
}