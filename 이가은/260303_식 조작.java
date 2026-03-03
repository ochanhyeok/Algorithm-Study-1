import java.util.ArrayList;
import java.util.List;

class Solution {

    public int solution(String expression) {
        List<Character> ops = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == 'x' ) {
                nums.add(Integer.parseInt(temp.toString()));
                temp.setLength(0);
                ops.add(c);
            } else {
                temp.append(c);
            }
        }

        nums.add(Integer.parseInt(temp.toString()));

        int m = nums.size();
        int best = eval(nums, ops);
        for (int l = 0; l < m; l++) {
            for (int r = l + 1; r < m; r++) {
                int inside = evalRange(nums, ops, l, r); // 괄호 구간 값

                List<Integer> nums2 = new ArrayList<>();
                List<Character> ops2 = new ArrayList<>();

                for (int i = 0; i < l; i++) nums2.add(nums.get(i));

                nums2.add(inside);

                for (int i = r + 1; i < m; i++) nums2.add(nums.get(i));

                for (int i = 0; i < l; i++) ops2.add(ops.get(i));

                for (int i = r; i < ops.size(); i++) ops2.add(ops.get(i));

                int value = eval(nums2, ops2);
                best = Math.max(best, value);
            }
        }

        return best;
    }

    private int eval(List<Integer> nums, List<Character> ops) {
        // nums2, ops2 : 곱을 제거한 새 식
        List<Integer> nums2 = new ArrayList<>();
        List<Character> ops2 = new ArrayList<>();

        int cur = nums.get(0);
        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            int next = nums.get(i + 1);

            /**
             * 곱셈은 미리 계산
             */
            if (op == 'x') {
                cur = cur * next;
            } else {
                nums2.add(cur);
                ops2.add(op); // '+' or '-'
                cur = next;
            }
        }
        nums2.add(cur);

        /**
         * 나머지 +,- 만 남겨서 왼→오 계산
         */
        int res = nums2.get(0);
        for (int i = 0; i < ops2.size(); i++) {
            char op = ops2.get(i);
            int b = nums2.get(i + 1);
            if (op == '+') res += b;
            else res -= b;
        }
        return res;
    }

    private int evalRange(List<Integer> nums, List<Character> ops, int l, int r) {
        List<Integer> subNums = new ArrayList<>();
        List<Character> subOps = new ArrayList<>();

        for (int i = l; i <= r; i++) subNums.add(nums.get(i));
        for (int i = l; i <= r - 1; i++) subOps.add(ops.get(i));

        return eval(subNums, subOps);
    }

}