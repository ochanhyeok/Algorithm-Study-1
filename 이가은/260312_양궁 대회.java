import java.util.*;

class Solution {
    
    static int maxDiff = -1;
    static int[] finalLionArr = new int[11];
    
    public int[] solution(int n, int[] info) {
        backtrack(n, 0, new int[11], info);
        
        if (maxDiff <= 0) return new int[]{-1};
        return finalLionArr;
    }
    
    static void backtrack(int restCnt, int index, int[] lionArr, int[] peachArr) {
        if (index == 11 || restCnt == 0) {
            if (index == 11 && restCnt > 0) {
                lionArr[10] += restCnt;
            }
            
            int diff = getDiff(lionArr, peachArr);
            if (diff > maxDiff) {
                maxDiff = diff;
                finalLionArr = Arrays.copyOf(lionArr, 11);
            } else if (diff == maxDiff && isBetter(lionArr, finalLionArr)) {
                finalLionArr = Arrays.copyOf(lionArr, 11);
            }
            
            if (index == 11 && restCnt > 0) {
                lionArr[10] -= restCnt;
            }
            return;
        }
        
        // 1. 안 쏘는 경우
        backtrack(restCnt, index + 1, lionArr, peachArr);

        // 2. 피치보다 1발 더 쏘는 경우
        int need = peachArr[index] + 1;
        if (restCnt >= need) {
            lionArr[index] = need;
            backtrack(restCnt - need, index + 1, lionArr, peachArr);
            lionArr[index] = 0;
        }
    }
    
    static int getDiff(int[] lionArr, int[] peachArr) {
        int lionSum = 0;
        int peachSum = 0;
        
        for (int i = 0; i <= 10; i++) {
            int score = 10 - i;
            if (lionArr[i] > peachArr[i]) {
                lionSum += score;
            } else if (peachArr[i] > 0) {
                peachSum += score;
            }
        }
        
        return lionSum - peachSum;
    }
    
    static boolean isBetter(int[] a, int[] b) {
        for (int i = 10; i >= 0; i--) {
            if (a[i] != b[i]) return a[i] > b[i];
        }
        return false;
    }
}