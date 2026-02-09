import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int start = 1, end = distance; 
        
        Arrays.sort(rocks);
        
        while(start <= end ){
            int mid = (start+end)/2; //최소 거리 가정 
            
            int remove = 0; //제거할 돌 개수
            int prev = 0; //이전 돌 위치 -> 시작점 : 0
            
            //돌 앞에서부터 순회 
            for (int r : rocks ){
                //이전 돌과의 거리가 mid보다 작다면? -? 최솟값이 작아지니까 이 돌을 제거해야 함. 크다면 그냥 현재 돌만 prev에 저장 
                if (r - prev < mid){
                   remove++;  
                } else {
                    prev = r; 
                }
            }
            
            //마지막 돌까지의 거리 
            if ( distance - prev <mid){
                remove ++;
            }
            
            //판정 -> n개만큼만 지울 수 있으니까 
            if(remove <= n){
                answer = mid;
                start = mid+1; //더 큰 최댓값이 있는지 새로 탐색하기 위해 범위 늘리기  
            } else {
                end = mid -1; //불가능하니까 찾으려는 값의 범위를 줄이기 
            }
            
        }
        
        
        
        return answer;
    }
}