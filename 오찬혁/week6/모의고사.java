import java.util.*;

class Solution {
	public int[] solution(int[] answers) {
		List<Integer> list = new ArrayList<>();
		int[] supo1 = {1, 2, 3, 4, 5};
		int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int cnt1 = 0, cnt2 = 0, cnt3 = 0;
		int len1 = supo1.length;
		int len2 = supo2.length;
		int len3 = supo3.length;
		System.out.println(len1 + ", " + len2 + ", " + len3);
		for(int i = 0; i < answers.length; i++){
			if(supo1[i % len1] == answers[i]){
				cnt1++;
			}
			if(supo2[i % len2] == answers[i]){
				cnt2++;
			}
			if(supo3[i % len3] == answers[i]){
				cnt3++;
			}
			// System.out.println("cnt1 = " + cnt1 + ", cnt2 = " + cnt2 + ", cnt3 = " + cnt3);
		}

		int max = Math.max(cnt1, Math.max(cnt2, cnt3));

		if(cnt1 == max){
			list.add(1);
		}
		if(cnt2 == max){
			list.add(2);
		}
		if(cnt3 == max){
			list.add(3);
		}

		return list.stream().mapToInt(i -> i).toArray();
	}
}