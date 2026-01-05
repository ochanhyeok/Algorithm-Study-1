import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        //수포자 패턴 
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] count = new int[3];
        
        //answer 순회하면서 수포자애들 인덱스 증가하며 같은 원소일 때는 해당 cnt배열을 증가. 
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) count[0]++;
            if (answers[i] == p2[i % p2.length]) count[1]++;
            if (answers[i] == p3[i % p3.length]) count[2]++;
        }
        
        //최댓값 찾기 
        int max = Math.max(count[0], Math.max(count[1],count[2]));
        
        //최댓값을 정답으로 가지는 수포자 찾기 
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(count[i] ==max){
                result.add(i+1); 
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}