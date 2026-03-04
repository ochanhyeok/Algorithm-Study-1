package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] approved1 = {"123-4567", "451-2314", "015-1643"};
        String[] spams1 = {"111-1111"};
        String[] calls1 = {"123-4567", "000-0022", "015-1643", "000-0022", "111-1111", "000-0022", "111-1111", "111-1111"};
        int k1 = 2;
        
        String[] approved2 = {"123-1000"};
        String[] spams2 = {"456-2000"};
        String[] calls2 = {"456-2000", "456-2000", "123-1000", "123-1000", "789-3000", "789-3000", "789-3000", "789-3000", "789-3000"};
        int k2 = 3;
        
        int[] answer1 = solution(approved1, spams1, calls1, k1);
        int[] answer2 = solution(approved2, spams2, calls2, k2);
        
        System.out.println(Arrays.toString(answer1));
        System.out.println(Arrays.toString(answer2));
    }
    
    public static int[] solution(String[] approved, String[] spams, String[] calls, int k) {
    	
    	int[] answer = new int[calls.length];
    	Map<String, Integer> map = new HashMap<>();
    	
    	for(int i = 0; i < calls.length; i++) {
    		 
    		 boolean find = false;
    		 
			 for(String spam : spams) {
				 if(spam.equals(calls[i])) {
					 answer[i] = 1;
					 find = true;
					 break;
				 }
			 }
			 
			 for(String approve : approved) {
				 if(approve.equals(calls[i])) {
					 answer[i] = 0;
					 find = true;
				 }
			 }
			 
			 if(find) {
				 continue;
			 }
			 
			 map.put(calls[i], map.getOrDefault(calls[i], 0) + 1);
			 
			 if(map.get(calls[i]) <= k) {
				 answer[i] = 1;
			 } else {
				 answer[i] = 0;
			 }
    	}
    	
    	return answer;
    }
}