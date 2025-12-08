import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        dfs(numbers, "");

        for(int num : set){
            if(isPrime(num)){
                answer++;
            }
        }

        return answer;
    }

    boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    void dfs(String numbers, String cur){
        if(!"".equals(cur)){
            set.add(Integer.parseInt(cur));
        }

        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                System.out.printf(
                        "cur=\"%s\", pick index=%d, char=%c, visited=%s -> next=\"%s\"%n",
                        cur, i, numbers.charAt(i),Arrays.toString(visited), cur + numbers.charAt(i));
                dfs(numbers, cur + numbers.charAt(i)); // 자리하나 더 붙이기
                visited[i] = false;
            }
        }
    }
}