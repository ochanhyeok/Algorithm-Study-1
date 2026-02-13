import java.util.*;

class Solution {
	public int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);

		int left = 0;
		int right = citations[citations.length - 1];

		while(left <= right){
			int mid = (left + right) / 2;

			if(findHIdx(citations, mid)){
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return answer;
	}

	static boolean findHIdx(int[] citations, int mid){
		int check = 0;

		for(int cit : citations){
			if(cit >= mid){
				check++;
			}
		}

		return check >= mid;
	}
}