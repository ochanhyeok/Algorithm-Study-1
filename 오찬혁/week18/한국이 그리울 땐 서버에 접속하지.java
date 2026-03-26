import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		String line = br.readLine();
		String[] cmd = line.split("\\*");

		for(int i = 0; i < N; i++){
			String str = br.readLine();

			if(str.length() >= cmd[0].length() + cmd[1].length() && str.startsWith(cmd[0]) && str.endsWith(cmd[1])){
				sb.append("DA\n");
			} else {
				sb.append("NE\n");
			}
		}

		System.out.println(sb.toString());
	}
}