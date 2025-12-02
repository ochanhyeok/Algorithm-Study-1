import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			if ("push".equals(str.split(" ")[0])) {
				queue.offer(Integer.parseInt(str.split(" ")[1]));
				
			} else if ("pop".equals(str)){
				sb.append( (!queue.isEmpty()) ? queue.poll() : -1 );
				sb.append("\n");
				
			} else if ("front".equals(str)){
				sb.append( (!queue.isEmpty()) ? queue.peek() : -1 );		
				sb.append("\n");
				
			} else if ("back".equals(str)) {
				if (!queue.isEmpty()) {
					sb.append(queue.getLast()+"\n");
				} else {
					sb.append(-1+"\n");
				}
				
			} else if ("size".equals(str)){
				sb.append(queue.size()+"\n");				
			
			} else if ("empty".equals(str)){
				sb.append( queue.isEmpty() ? 1 : 0 );
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
