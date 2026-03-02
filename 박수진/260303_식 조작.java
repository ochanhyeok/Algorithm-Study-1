import java.util.*;

class Solution {
  public int solution(String expression) {
    List<Integer> nums = new ArrayList<>();
    List<Character> ops = new ArrayList<>();

    for (int i = 0; i < expression.length(); i++) {
        char c = expression.charAt(i);
        if (c >= '0' && c <= '9') {
            nums.add(c - '0'); // 숫자는 0~9 (한 자리)
        } else { 
            // '+', '-', 'x'
            ops.add(c);
        }
    }

    int m = nums.size();
    int best = Integer.MIN_VALUE;

    // 괄호 구간을 전부 시도
      for (int i = 0; i < m; i++) {
          for (int j = i + 1; j < m; j++) {
              // sub expression 추출
              List<Integer> subNums = new ArrayList<>();
              List<Character> subOps = new ArrayList<>();

              for (int k = i; k <= j; k++) 
                subNums.add(nums.get(k));
              for (int k = i; k <= j - 1; k++) 
                subOps.add(ops.get(k));

              int subVal = eval(subNums, subOps);

              // 전체 식에서 [i..j] 구간을 subVal로 치환
              List<Integer> newNums = new ArrayList<>();
              List<Character> newOps = new ArrayList<>();

              // nums 앞부분 유지
              for (int k = 0; k < i; k++) 
                newNums.add(nums.get(k));

              // subVal 삽입
              newNums.add(subVal);

              // nums 뒷부분 추가
              for (int k = j + 1; k < m; k++) 
                newNums.add(nums.get(k));

              // ops 재구성
              // ops[0..i-2]
              for (int k = 0; k <= i - 2; k++) 
                newOps.add(ops.get(k));

              // ops[i-1] (i>0이면 괄호 앞 연결 연산자 유지)
              if (i > 0) 
                newOps.add(ops.get(i - 1));

              // ops[j] (j < m-1이면 괄호 뒤 연결 연산자 유지)
              if (j < m - 1) 
                newOps.add(ops.get(j));

              // ops[j+1 .. end]
              for (int k = j + 1; k < ops.size(); k++) 
                newOps.add(ops.get(k));

              int val = eval(newNums, newOps);
              if (val > best) best = val;
          }
      }

      return best;
  }

    private int eval(List<Integer> nums, List<Character> ops) {
        // 1) 곱셈 먼저 압축
        List<Integer> tmpNums = new ArrayList<>();
        List<Character> tmpOps = new ArrayList<>();

        tmpNums.add(nums.get(0));
        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            int next = nums.get(i + 1);

            if (op == 'x') {
                int last = tmpNums.remove(tmpNums.size() - 1);
                tmpNums.add(last * next);
            } else {
                tmpOps.add(op);
                tmpNums.add(next);
            }
        }

        // 2) + / - 좌->우
        int res = tmpNums.get(0);
        for (int i = 0; i < tmpOps.size(); i++) {
            char op = tmpOps.get(i);
            int b = tmpNums.get(i + 1);
            if (op == '+') res += b;
            else res -= b; // '-'
        }
        return res;
    }
}