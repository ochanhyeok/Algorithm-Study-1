import java.util.*;
import java.io.*;

public class Main {
    static List<int[]> list = new ArrayList<>();
    static boolean[] visited = new boolean[10];
    static int[] out = new int[3];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int note[][] = new int[n][3];
        
        dfs(0);
        
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            note[i] = new int[] {num, strike, ball};
        }
        
        int b = 0;
        int s = 0;
        
        for(int[] c : list) {
            boolean correct = true;
            
            for(int i = 0; i < n; i++) {
                s = note[i][1];
                b = note[i][2];
            
                if(!findSB(c, note[i][0], s, b)) {
                    correct = false;
                    break;
                }
            }
            
            if(correct) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
    
    public static boolean findSB(int[] a, int b, int strike, int ball) {
        int[] num = new int[3];
        num[0] = b / 100;
        num[1] = (b / 10) % 10;
        num[2] = b % 10;
        
        int sa = 0;
        int ba = 0;
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(num[i] == a[j]) {
                    if(i == j) {
                        sa++;
                    } else {
                        ba++;
                    }
                }
            }
        }
        
        if(sa == strike && ba == ball) {
            return true;
        }
        
        return false;
    }
    
    static void dfs(int d) {
        if(d == 3) {
            list.add(out.clone());
            return;
        }
        
        for(int i = 1; i < 10; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[d] = i;
                dfs(d + 1);
                visited[i] = false;
            }
        }
    }
}