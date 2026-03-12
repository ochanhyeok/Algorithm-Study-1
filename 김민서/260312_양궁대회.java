import java.util.*;

class Solution {
    static int[] lion = new int[11];
    static int[] answer = new int[11];
    static int max = 0;
     
    public int[] solution(int n, int[] info) {
        dfs(0, n, info);
        for(int i = 0; i < 11; i++) {
            if(answer[i] != 0) {
                return answer;
            }
        }
        return new int[] {-1};
    }
    //dfs 돌려서 점수차가 최댓값인 배열을 리스트에 저장
    //dfs 나와서 최댓값인 애들 뒤에서부터 비교
    public void dfs(int idx, int n, int[] info) {
        if(idx == 11) {
            lion[10] += n;
            int ls = 0;
            int ps = 0;
            
            for(int i = 10; i >= 0; i--) {
                if(lion[i] == 0 && info[i] == 0) continue;
                
                if(lion[i] > info[i]) {
                    ls += 10 - i;
                } else {
                    ps += 10 - i;
                }
            }
            
            int diff = ls - ps;
            
            if(diff <= 0) {
                lion[10] -= n;
                return;
            }

            if(diff > max) {
                max = diff;
                answer = lion.clone();
            } else if(diff == max) {
                for(int i = 10; i >= 0; i--) {
                    if(lion[i] > answer[i]) {
                        answer = lion.clone();
                        break;
                    } else if(lion[i] < answer[i]) {
                        break;
                    }
                }
            }
            
            lion[10] -= n;
            return;
        }
        
        int need = info[idx] + 1;
        if(need <= n) {
            lion[idx] = need;
            dfs(idx + 1, n - need, info);
        }
        
        lion[idx] = 0;
        dfs(idx + 1, n, info);
    }
}