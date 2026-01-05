import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pibo {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(p(n));
	}
	
	public static int p(int n) {
		if(n == 1 || n == 0) {
			return n;
		}
		return p(n - 1) + p(n - 2);
	}

}
