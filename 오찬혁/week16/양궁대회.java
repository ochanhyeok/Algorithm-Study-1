class Solution {

	static int maxDiff;
	static int[] answer;

	public int[] solution(int n, int[] info) {
		maxDiff = 0;
		answer = null;
		dfs(0, n, info, new int[11]);

		return answer == null ? new int[]{-1} : answer;
	}

	static void dfs(int idx, int remain, int[] info, int[] lion){
		if(idx == 11){
			lion[10] += remain;

			int diff = calcDiff(info, lion);
			if(diff > maxDiff){
				maxDiff = diff;
				answer = lion.clone();
			} else if(diff == maxDiff && diff > 0){
				if(isBetter(lion, answer)){
					answer = lion.clone();
				}
			}

			lion[10] -= remain;

			return;
		}

		if(remain > info[idx]){
			lion[idx] = info[idx] + 1;
			dfs(idx + 1, remain - lion[idx], info, lion);
			lion[idx] = 0;
		}

		dfs(idx + 1, remain, info, lion);
	}

	static int calcDiff(int[] info, int[] lion){
		int lionSco = 0, apSco = 0;
		for(int i = 0; i <= 10; i++){
			int sco = 10 - i;
			if(lion[i] > info[i]){
				lionSco += sco;
			} else if(info[i] > 0){
				apSco += sco;
			}
		}
		return lionSco - apSco;
	}

	static boolean isBetter(int[] lion, int[] answer){
		for(int i = 10; i >= 0; i--){
			if(lion[i] != answer[i]){
				return lion[i] > answer[i];
			}
		}
		return false;
	}
}