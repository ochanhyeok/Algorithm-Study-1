import java.util.*;

class Solution {

	static Map<String, List<Integer>> map;

	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		map = new HashMap<>();

		String[][] infos = new String[info.length][5];
		for(String s : info){
			String[] arr = s.split(" ");
			makeComb("", 0, arr);
		}

		// key의 점수 리스트 정렬
		for(String key : map.keySet()){
			Collections.sort(map.get(key));
		}

		int idx = 0;
		for(String q : query){
			String replaced = q.replace(" and ", "");
			String[] str = replaced.split(" ");
			String key = str[0];
			int score = Integer.parseInt(str[1]);

			answer[idx++] = countByBinarySearch(key, score);
		}

		return answer;
	}

	static void makeComb(String cur, int depth, String[] arr){
		// 언어/직군/경력/소울푸드
		if(depth == 4){
			int score = Integer.parseInt(arr[4]);
			map.computeIfAbsent(cur, k -> new ArrayList<>()).add(score);
			return;
		}

		makeComb(cur + "-", depth + 1, arr);

		makeComb(cur + arr[depth], depth + 1, arr);
	}

	static int countByBinarySearch(String key, int score){
		if(!map.containsKey(key)){
			return 0;
		}

		List<Integer> list = map.get(key);
		int start = 0;
		int end = list.size() - 1;

		// score 이상이 처음 나오는 인덱스 찾기
		while(start <= end){
			int mid = (start + end) / 2;
			if(list.get(mid) < score){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return list.size() - start;
	}
}