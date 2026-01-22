import java.util.*;
import java.io.*;

class Main{
    static int count;
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        boolean[] boardCol = new boolean[N];
        int[] diag1 = new int[N*2];
        int[] diag2 = new int[N*2];
        count =0; 
        dfs(0, N, boardCol, diag1, diag2);
        System.out.println(count);
    }
    
    public static void dfs(int row,int N, boolean[] boardCol, int[] diag1, int[] diag2){
        if(row == N) {
            count++;
            return;
        }
        
        for(int i=0; i<N; i++){
            if(boardCol[i] == true || diag1[row + i] >0 || diag2[row - i + N] >0) continue;
            boardCol[i] = true;
            diag1[row+i] += 1;
            diag2[row-i+N] += 1;
            
            dfs(row+1, N, boardCol, diag1, diag2);
            
            boardCol[i] = false;
            diag1[row+i] -= 1;
            diag2[row-i+N] -= 1;
        }
    }
}