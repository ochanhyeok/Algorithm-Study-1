import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<String> stack = new Stack<>();
		int answer = 0;

		StringBuilder temp = new StringBuilder();

		for (char token : str.toCharArray()) {
			if (token >= '0' && token <= '9') {
				temp.append(token);
			} else {
				stack.push(temp.toString());
				temp.setLength(0);
				stack.push(token + "");
			}
		}

		stack.push(temp.toString());

		Stack<String> ordered = new Stack<>();
		while (!stack.isEmpty()) {
			ordered.push(stack.pop());
		}

		int current = 0;

		while (!ordered.isEmpty()) {
			String pop = ordered.pop();

			if ("-".equals(pop)) {

				while (!ordered.isEmpty()) {
					String next = ordered.peek();

					if ("-".equals(next))
						break;

					if (!"+".equals(next)) {
						current += Integer.parseInt(next);
					}

					ordered.pop();
				}

				answer -= current;
				current = 0;

			} else if ("+".equals(pop)) {
				answer += Integer.parseInt(ordered.pop());
			} else {
				answer += Integer.parseInt(pop);
			}
		}

		System.out.println(answer);
	}
}