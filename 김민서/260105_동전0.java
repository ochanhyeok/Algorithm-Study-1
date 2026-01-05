import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
        	coins[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = n - 1; i >= 0; i--) {
        	int num = k / coins[i];
        	k = k - (num * coins[i]);
        	cnt += num;
        	
        	if(k == 0) break;
        }
        
        System.out.println(cnt);
	}

}
