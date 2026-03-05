package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        int n1 = 3;
        int m1 = 5;
        int[][] records1 =  {{1, 1, 5}, {2, 4, 7}, {1, 5, 10}, {3, 1, 10}, {2, 1, 5}, {1, 3, 3}, {3, 2, 8}, {2, 2, 8}, {3, 4, 7}};
       
        int n2 = 2;
        int m2 = 3;
        int[][] records2 =  {{1, 2, 7}, {1, 1, 7}, {1, 3, 9}, {2, 1, 3}, {2, 2, 9}, {2, 3, 1}};
        
        int[][] answer1 = solution(n1, m1, records1);
        int[][] answer2 = solution(n2, m2, records2);
        
        System.out.println(Arrays.deepToString(answer1));
        System.out.println(Arrays.deepToString(answer2));
    }
    
    public static int[][] solution(int n, int m, int[][]records) {
    	
    	List<int[]> answer = new ArrayList<>();
    	
    	Map<Integer, Integer> disk = new HashMap<>();
    	
    	for(int i = 0; i < records.length; i++) {
    		disk.put(records[i][0], disk.getOrDefault(records[i][0], 0) + 1);
    	}
    	
    	Map<Integer, List<int[]>> numRecords = new HashMap<>();
    	
    	for(int[] row : records) {
    		numRecords.computeIfAbsent(row[1], k -> new ArrayList<>()).add(row);
    	}
    	
    	for(List<int[]> list : numRecords.values()) {
    		list.sort((a, b) -> {
        		if(a[2] != b[2]) {
        			return Integer.compare(b[2], a[2]);
        		}
        		
        		return Integer.compare(disk.get(b[0]), disk.get(a[0]));
        	});
    		
    		for(int i = 0; i < list.size() - 1; i++) {
    			answer.add(new int[] {list.get(i)[0], list.get(i)[1]});
    			disk.put(list.get(i)[0], disk.get(list.get(i)[0]) - 1);
    		}
    	}
    	
    	return answer.toArray(new int[answer.size()][]);
    }
}