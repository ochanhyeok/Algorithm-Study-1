import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinSum {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ex = br.readLine();
		
		String part[] = ex.split("-", 2); // 두덩이로만 나눔
		
		int total = 0;
		
		for (String s : part[0].split("\\+")) { // 정규식 특수문자라서 \\붙여야함
		    total += Integer.parseInt(s);
		}

		if (part.length > 1) {
		    for (String s : part[1].split("[+-]")) {
		        total -= Integer.parseInt(s);
		    }
		}
		
		System.out.println(total);
	}

}
