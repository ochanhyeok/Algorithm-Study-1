package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Grd {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    List<int[]> time = new ArrayList<>();
	    for(int i=0; i<n; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            time.add(new int[]{s, e}); 
	    }
	    Collections.sort(time, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
	    int cnt = 0;
        int end = Integer.MIN_VALUE; // 초기값: 어떤 시작값도 통과하게
        for (int[] j : time) {
            if (j[0] >= end) {
                cnt++;
                end = j[1];
            }
        }
	    System.out.println(cnt);
	}

}