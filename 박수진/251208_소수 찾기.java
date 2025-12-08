import java.util.HashSet;

class Solution {
    static HashSet<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        // 입력 문자열을 하나씩 쪼개어 배열에 저장
        String[] piece = numbers.split("");
        boolean[] visited = new boolean[piece.length];
        
        // 모든 순열 만들기 (i는 뽑을 개수를 의미)
        for (int i=1; i<=piece.length; i++) {
            String[] output = new String[i];
            perm(piece, output, visited, 0, visited.length, i);
        }
        
        // 만들어진 숫자들 중 소수 개수 카운팅
        int answer = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }

        // numberSet.clear()
        return answer;
    }
    
    // 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    // depth: 결과 배열의 인덱스
    static void perm(String[] input, String[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            save(output); // 숫자 변환 및 Set에 저장
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = input[i];
                perm(input, output, visited, depth + 1, n, r);       
                visited[i] = false;
            }
        }
    }
    
    // 배열을 합쳐서 숫자로 만들고, Set에 저장
    static void save(String[] output) {
        StringBuilder sb = new StringBuilder("");
        for (String str : output) {
            sb.append(str);
        }
        
        int num = Integer.parseInt(sb.toString());
        numberSet.add(num); // Set에 넣어서 중복 제거
    }
    
    // 소수 판별
    static boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i*i <= n; i++) {
          if (n % i == 0) {
              return false;
          }
        }
        return true;
    }
}