import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// Queen : 같은 열, 같은 대각선에 있으면 안 됨

class Main {
    static int N;
    static long count = 0;
    
    static boolean[] colUsed; // 열 점유 상태
    static boolean[] diag1Used; // '\' 대각선 점유 상태
    static boolean[] diag2Used;  // '/' 대각선 점유 상태
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        
        colUsed = new boolean[N];
        diag1Used = new boolean[2 * N - 1];
        diag2Used = new boolean[2 * N - 1];
        
        dfs(0);
        System.out.println(count);
    }
    
    static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }
        
        // 현재 행(row)에서 어느 열(col)에 둘지 결정
        for (int col = 0; col < N; col++) {
            int d1 = row - col + (N - 1);
            int d2 = row + col;
            
            // 가지치기
            if (colUsed[col] || diag1Used[d1] || diag2Used[d2])
                continue;
            
            // 퀸 놓기
            colUsed[col] = true;
            diag1Used[d1] = true;
            diag2Used[d2] = true;
            
            // 다음 행으로 이동
            dfs(row + 1);
            
            // 복구 (백트래킹)
            colUsed[col] = false;
            diag1Used[d1] = false;
            diag2Used[d2] = false;
        }
    }
}