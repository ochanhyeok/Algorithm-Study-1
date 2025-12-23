import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> arr = new ArrayList<>();
        int y = 0;
        while(n != 0) {
            y = n%3;
            n /= 3;
            arr.add(y);
        }
        // for(int i : arr){
        //     System.out.println(i);
        // }
        int j = 1;
        int answer = 0;
        for(int i = arr.size() - 1; i >= 0; i--){
            answer += arr.get(i) * j;
            j *= 3;
        }
        return answer;
    }
}