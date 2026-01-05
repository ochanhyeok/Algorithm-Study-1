import java.util.*;

class Solution {

	Map<String, Integer> countMap;

	public String[] solution(String[] orders, int[] course) {
		List<String> result = new ArrayList<>();

		for(int i = 0; i < orders.length; i++){
			char[] arr = orders[i].toCharArray();
			Arrays.sort(arr);
			orders[i] = new String(arr);
		}

		for(int len : course){
			countMap = new HashMap<>();

			for(String order : orders){
				if(order.length() < len){
					continue;
				}
				makeComb(order, new StringBuilder(), 0, len);
			}

			int max = 0;
			for(int v : countMap.values()){
				if(v > max){
					max = v;
				}
			}

			if(max < 2){
				continue;
			}

			for(Map.Entry<String, Integer> e : countMap.entrySet()){
				if(e.getValue() == max){
					result.add(e.getKey());
				}
			}

		}

		Collections.sort(result);

		return result.toArray(new String[0]);
	}

	private void makeComb(String order, StringBuilder sb, int idx, int len){
		if(sb.length() == len){
			String key = sb.toString();
			countMap.put(key, countMap.getOrDefault(key, 0) + 1);
			return;
		}

		for(int i = idx; i < order.length(); i++){
			sb.append(order.charAt(i));
			makeComb(order, sb, i + 1, len);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}