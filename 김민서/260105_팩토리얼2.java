import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(pac(n));
	}
	
	public static long pac(int n) {
		if(n <= 1) {
			return 1;
		}
		return n * pac(n - 1);
	}
}