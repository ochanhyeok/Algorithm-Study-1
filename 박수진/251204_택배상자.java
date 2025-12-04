import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        // 보조 컨테이너 벨트
        Stack<Integer> subBelt = new Stack<>();
        
        // 컨테이너 벨트에서 꺼내는 순서
        int cnt = 1;
        int answer = 0;
        
        for (int i=0; i<order.length; i++) {           
            // 첫 번째 상자인 경우 
            if (i==0) {
                while(cnt != order[i]) {
                    subBelt.push(cnt);
                    cnt++;
                }
                answer++;
            }
            
            else {
                // 1) 이전 상자의 앞 번호 (보조 벨트에서 찾기)
                if (order[i] < order[i-1]) {
                    if (subBelt.peek() != order[i]) {
                        return answer;
                    }
                    subBelt.pop();
                    answer++;
                }

                // 2) 이전 상자의 뒷 번호 (메인 벨트에서 찾기)
                else if (order[i] > order[i-1]) {
                    cnt++;
                    while (cnt != order[i]) {
                        subBelt.push(cnt);
                        cnt++;
                    }
                    answer++;
                }
            }            
        }
        return answer;
    }
}