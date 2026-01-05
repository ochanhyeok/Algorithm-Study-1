import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
        int[] days = new int[size];
        
        int remain = 0;
        // i번째 기능이 며칠 뒤에 완성되는지 체크
        for (int i = 0; i < size; i++) {
            remain = 100 - progresses[i];
            days[i] = (remain + speeds[i] - 1) / speeds[i]; // ceil
        }
        
        List<Integer> answer = new ArrayList<>();
        int base = days[0]; // 기준 날짜
        int count = 1;
				
				// 두 번째 기능부터 하나씩 확인
        for (int i = 1; i < size; i++) {
            if (days[i] <= base) {
                count++;
            } else {
                answer.add(count);
                base = days[i];
                count = 1;
            }
        }
        
        answer.add(count);
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}