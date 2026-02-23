import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int x = Integer.parseInt(bf.readLine());
        
        boolean[] exist = new boolean[2000001];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            int target = x - current;
            
            if (target > 0 && target <= 200000 && exist[target]) {
                count++;
            }
            
            exist[current] = true;
        }
        
        System.out.println(count);
    }
}