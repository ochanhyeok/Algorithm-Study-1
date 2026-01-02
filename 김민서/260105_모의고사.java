import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] p = new int[4][];

        p[1] = new int[]{1, 2, 3, 4, 5}; 
        p[2] = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; 
        p[3] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt[] = new int[4];
        
        for(int i = 1; i <= 3; i++) {
            int leng = p[i].length;
            
            for(int j = 0; j < answers.length; j++) {
                if(p[i][j % leng] == answers[j]) {
                    cnt[i]++;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int maxidx = 0;
        for(int i = 1; i <= 3; i++) {
            if(cnt[i] > cnt[maxidx]){
                list.clear();
                list.add(i);
                maxidx = i;
            } else if(cnt[i] == cnt[maxidx]) {
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}