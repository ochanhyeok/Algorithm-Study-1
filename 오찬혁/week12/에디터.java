package baekjoon;

import java.util.*;
import java.io.*;

public class 에디터{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();
		StringBuilder editor = new StringBuilder(str);

		int curIdx = str.length();

		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			if("P".equals(cmd)){ // 문자를 커서 왼쪽에 추가
				String letter = st.nextToken();
				editor.insert(curIdx, letter);
				curIdx++;
			} else if("L".equals(cmd)){ // 커서를 왼쪽으로 한 칸 옮김
				if(curIdx > 0){
					curIdx--;
				}
			} else if("D".equals(cmd)){ // 커서를 오른쪽으로 한 칸 옮김
				if (curIdx < editor.length()) {
					curIdx++;
				}
			} else if("B".equals(cmd)){ // B 커서 왼쪽에 있는 문자를 삭제
				if (curIdx > 0) {
					editor.deleteCharAt(curIdx - 1);
					curIdx--;
				}
			}
		}

		System.out.println(editor.toString());
	}

}