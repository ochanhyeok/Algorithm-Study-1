import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public String solution(String input_string) {

		Map<Character, List<Integer>> map = new HashMap<>();
		List<Character> result = new ArrayList<>();

		for(int i = 0; i < input_string.length(); i++){
			char ch = input_string.charAt(i);
			map.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
		}

		for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
			List<Integer> idxList = entry.getValue();

			boolean isLonely = false;
			for(int i = 0; i < idxList.size() - 1; i++){
				if(idxList.get(i + 1) - idxList.get(i) > 1){
					isLonely = true;
					break;
				}
			}

			if(isLonely){
				result.add(entry.getKey());
			}
		}

		if(result.isEmpty()){
			return "N";
		}

		Collections.sort(result);

		return result.stream()
			.sorted()
			.map(String::valueOf)
			.collect(Collectors.joining());

	}
}