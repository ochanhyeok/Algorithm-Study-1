package task;

import java.util.*;
import java.io.*;

public class Main {
	
	static int[] digits; 
	static long[][][] dp; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               
        int N = Integer.parseInt(br.readLine().trim());
        
        long lo = 666, hi = (long) 1e15;
        while(lo<hi) {
        	long mid = (lo+hi)/2;
        	if (count(mid) >= N ) hi = mid; 
        	else lo = mid+1;
        }
        System.out.println(lo);
	}
	
	//x이하의 종말의 수 개수 
	static long count(long x) {
		String s = Long.toString(x);
		int n = s.length(); 
		digits = new int[n];
		
		for(int i=0; i< n; i++) {
			digits[i] = s.charAt(i) -'0';
		}
		
		dp = new long[n][4][2];
		for ( long[][] a : dp)
			for (long[] b : a)
				Arrays.fill(b, -1);
		return solve(0,0,false,true);
		
	}
	
	static long solve(int pos, int consec6, boolean isApoc, boolean tight) {
		if ( pos == digits.length) return isApoc ? 1 : 0;
		
		if (!tight && dp[pos][consec6][isApoc ? 1 : 0] != -1)
			return dp[pos][consec6][isApoc ? 1: 0];
		
		int limit = tight ? digits[pos] : 9;
		long result = 0; 
		
		for (int d = 0; d<=limit ; d++) {
			int newConsec = (d==6) ? Math.min(consec6 +1, 3) : 0;
			boolean newApoc = isApoc || (newConsec >= 3);
			result += solve(pos+1, newConsec, newApoc, tight && (d == limit));
			
		}
		
		if (!tight) dp[pos][consec6][isApoc ? 1 : 0] = result; 
		return result;
	}
 	
}

