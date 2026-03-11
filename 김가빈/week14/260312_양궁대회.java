import java.util.*;
class Solution {
    int maxDiff = -1; 
    int[] best = {-1};
    public int[] solution(int n, int[] info) {
        int[] lion = new int[11]; 
        
        dfs(n,0, info, lion);
        
        return best;
    }
    
    public void dfs(int arrowLeft, int idx, int[] info, int[] lion){
        //모든 점수 칸을 다 본 경우 
        if(idx == 11 ) {
            //남은 화살들을 다 0점 칸에 몰아줘야 함. 
            lion[10] += arrowLeft;
            
            int lionSum = 0, apeachSum=0;
            for(int i=0; i<info.length; i++){
                if(info[i] == 0 && lion[i] == 0) continue;
                if(info[i] < lion[i]) lionSum += (10-i); 
                else apeachSum += (10-i); 
            }
            
            int diff = lionSum - apeachSum;
            //라이언이 이긴 경우만
            if(diff > 0) {
                //이겼을 때 최적화 답 구하기 위함
                if(diff > maxDiff) {
                    maxDiff = diff; 
                    best = lion.clone();    //배열복사
                } else if (diff == maxDiff){    //같은 경우 낮은 점수 많은 순
                    int lionMinTotal = 0, bestMinTotal = 0; 
                    for(int i=10; i>=0; i--){
                        lionMinTotal += (i*lion[10-i]);
                        bestMinTotal += (i*best[10-i]);
                    }
                    if(lionMinTotal < bestMinTotal) best = lion.clone();
                }
            }
            
            lion[10] -= arrowLeft; //백트래킹
            return; 
        }
        
        //라이언은 이기려면 어피치보다 1점만 높으면 됨. 
        int need = info[idx]+1; 
        if(arrowLeft >= need) {
            lion[idx] = need; 
            dfs(arrowLeft-need, idx+1, info, lion); 
            lion[idx] = 0; //백트래킹 복구 
        }
        
        //점수 포기하는 경우 
        dfs(arrowLeft, idx+1, info, lion); 
        
        return; 
    }
    
}