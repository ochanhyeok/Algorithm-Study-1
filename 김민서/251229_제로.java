import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {

	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				stack.pop();
			} else {
				stack.add(num);
			}
		}
		
		int sum = 0;
		
		for(int i : stack) {
			sum += i;
		}
		
		System.out.println(sum);
	}

}
