import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        String[] expressions = { "2-1x5-4x3+2", "2x3-1"};

        for(String expression : expressions) {
            int answer = solution(expression);
            System.out.println("result: " + answer);
        }
    }

    public static int solution(String expression) {
        // 1) parse
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == 'x') {
                ops.add(ch);
            } else {
                nums.add(ch - '0'); // 한 자리 숫자
            }
        }

        int m = nums.size();
        int answer = eval(nums, ops); // 괄호 안 넣는 경우도 포함

        // 2) try all parentheses ranges [l..r] over numbers
        for (int l = 0; l < m; l++) {
            for (int r = l; r < m; r++) {

                // 괄호 안 식 만들기
                List<Integer> subNums = new ArrayList<>();
                for (int k = l; k <= r; k++) subNums.add(nums.get(k));

                List<Character> subOps = new ArrayList<>();
                for (int k = l; k <= r - 1; k++) subOps.add(ops.get(k));

                int subVal = eval(subNums, subOps);

                // 3) 압축한 새 식 구성
                List<Integer> newNums = new ArrayList<>();
                List<Character> newOps = new ArrayList<>();

                // 앞부분
                for (int k = 0; k < l; k++) newNums.add(nums.get(k));
                // 괄호 결과
                newNums.add(subVal);
                // 뒷부분
                for (int k = r + 1; k < m; k++) newNums.add(nums.get(k));

                // 연산자: 앞쪽 ops[0..l-1]
                for (int k = 0; k < l; k++) newOps.add(ops.get(k));
                // 연산자: 뒤쪽 ops[r..end-1]
                for (int k = r; k < ops.size(); k++) newOps.add(ops.get(k));

                int val = eval(newNums, newOps);
                answer = Math.max(answer, val);
            }
        }

        return answer;
    }

    // 곱셈 우선, 같은 우선순위는 왼->오
    private static int eval(List<Integer> nums, List<Character> ops) {
        // 1) handle 'x' first
        List<Integer> tmpNums = new ArrayList<>();
        List<Character> tmpOps = new ArrayList<>();

        tmpNums.add(nums.get(0));
        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            int b = nums.get(i + 1);
            if (op == 'x') {
                int a = tmpNums.remove(tmpNums.size() - 1);
                tmpNums.add(a * b);
            } else {
                tmpOps.add(op);
                tmpNums.add(b);
            }
        }

        // 2) then + and -
        int res = tmpNums.get(0);
        for (int i = 0; i < tmpOps.size(); i++) {
            char op = tmpOps.get(i);
            int b = tmpNums.get(i + 1);
            if (op == '+') res += b;
            else res -= b;
        }
        return res;
    }
}
