import java.util.*;

class Solution {

	static String[] vowels = {"A", "E", "I", "O", "U"};
	static List<String> dict = new ArrayList<>();

	public int solution(String word) {

		dfs("");

		return dict.indexOf(word) + 1;
	}

	static void dfs(String cur){
		if(cur.length() > 5){
			return;
		}

		if(cur.length() > 0){
			dict.add(cur);
		}

		for(int i = 0; i < vowels.length; i++){
			dfs(cur + vowels[i]);
		}
	}
}