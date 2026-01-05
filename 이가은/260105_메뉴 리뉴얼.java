import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
		for (int i : course) {
			courseMap.put(i, new HashMap<>());
		}
		
		for (String order: orders) {
			char[] orderArray = order.toCharArray();
			Arrays.sort(orderArray);
			combinations(0, orderArray, "");
		} 
		
		ArrayList<String> answer = new ArrayList<>();

		
		for (int courseN : course) {
			if (courseMap.get(courseN).isEmpty()) continue;
			HashMap<String, Integer> courseCountMap = courseMap.get(courseN);
			int maxOrderCount = courseCountMap.values().stream().mapToInt(i -> i).max().getAsInt();
			if (maxOrderCount < 2) continue;
			for (Map.Entry<String, Integer> courseComb : courseCountMap.entrySet()) {
				if (courseComb.getValue() == maxOrderCount) {
					answer.add(courseComb.getKey());
				}
			}
		}
 		
		Collections.sort(answer);
		return answer.toArray(new String[0]);

    }
    
	public static void combinations(int idx, char[] order, String result) {
		if (courseMap.containsKey(result.length())) {
			HashMap<String, Integer> courseCountMap = courseMap.get(result.length());
			courseCountMap.put(result, courseCountMap.getOrDefault(result, 0) + 1);
		}

		for (int i = idx; i < order.length; i++) {
			combinations(i + 1, order, result + order[i]);
		}

	}

}