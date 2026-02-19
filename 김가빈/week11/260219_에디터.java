import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String strArr = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(strArr);
        
        int M = Integer.parseInt(br.readLine());
        
        int idx =strArr.length();
        for(int i=0; i<M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            
            if("L".equals(s)) {
            	if (idx ==0 ) continue;
            	idx -= 1; 
            } else if("D".equals(s)) {
            	if (idx == sb.length()) continue;
            	idx += 1; 
            } else if("B".equals(s)) {
            	if (idx ==0 ) continue;
            	sb.delete(idx-1, idx);
            	idx -= 1;
            } else if("P".equals(s)) {
            	String $ = st.nextToken();
            	sb.insert(idx, $);
            	idx += 1;
            }
        }
        System.out.println(sb.toString());
	}
	
}

