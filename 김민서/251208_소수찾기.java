import java.util.*;
class Solution {
    static boolean[] visited;
    static int[] output;
    static int[] arr;
    static List<Integer> result;
    
    public int solution(String numbers) {
        int answer = 0;
        result = new ArrayList<Integer>();
        String[] st = numbers.split("");
        arr = new int[st.length];
        for(int j=0; j<arr.length; j++){           //string을 int배열로 변환
            arr[j] = Integer.valueOf(st[j]);
        }
        int n = arr.length;
        for(int i=1; i<=numbers.length(); i++){
            output = new int[i];        
            visited = new boolean[n];
            p(0, n, i);                         //순열함수 써서 카드로 만들 수 있는 모든 숫자 list에 저장
        }
        for(int a : result){
            if(find(a)) answer++;               //소수찾기
        }
        return answer;
    }
    
    public void p(int dept, int n, int r){       //순열
        if(dept == r){                           //깊이가 r과 같아지면 list에 중복 검사 후 저장
            StringBuilder sb = new StringBuilder();
            for(int x : output){
                sb.append(x);
            }
            int a = Integer.parseInt(sb.toString());

            if(!result.contains(a)){
                result.add(a);
            }
            return;
        }
        for(int j=0; j<n; j++){
            if(!visited[j]){                     //방문하지 않으면
                visited[j] = true;               
                output[dept] = arr[j];           //현 깊이에 저장
                p(dept+1, n, r);                 //다음 깊이 수 찾기 
                visited[j] = false;              //다음 경우의 수를 위해 false
            }
        }
    }
    
    public boolean find(int n){       //소수찾기
        if(n<2) return false;               
        for(int i = 2; i<=n/2; i++){        //2로 안나눠지면 n/2보다 큰수로도 안나눠짐
            if(n%i == 0) return false;
        }
        return true;
    }
}