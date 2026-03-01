package code;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) nums.add(c - '0');
            else ops.add(c);
        }

        int max = calc(nums, ops); // 괄호 안 넣은 경우도 포함

        int m = ops.size();

        // 연산자 기준으로 괄호 범위 선택
        for (int start = 0; start < m; start++) {
            for (int end = start; end < m; end++) {

                List<Integer> newNums = new ArrayList<>();
                List<Character> newOps = new ArrayList<>();

                // 괄호 앞부분 복사
                for (int i = 0; i < start; i++) {
                    newNums.add(nums.get(i));
                    newOps.add(ops.get(i));
                }

                // 괄호 내부 계산
                int inner = calc(
                        nums.subList(start, end + 2),
                        ops.subList(start, end + 1)
                );
                newNums.add(inner);

                // 괄호 뒤 숫자
                for (int i = end + 2; i < nums.size(); i++) {
                    newNums.add(nums.get(i));
                }

                // 괄호 뒤 연산자
                for (int i = end + 1; i < ops.size(); i++) {
                    newOps.add(ops.get(i));
                }

                int result = calc(newNums, newOps);
                max = Math.max(max, result);
            }
        }

        System.out.println(max);
    }

    // 곱셈 먼저 처리
    static int calc(List<Integer> n, List<Character> g) {

        List<Integer> tempNums = new ArrayList<>();
        List<Character> tempOps = new ArrayList<>();

        tempNums.add(n.get(0));

        for (int i = 0; i < g.size(); i++) {
            if (g.get(i) == 'x') {
                int last = tempNums.remove(tempNums.size() - 1);
                tempNums.add(last * n.get(i + 1));
            } else {
                tempNums.add(n.get(i + 1));
                tempOps.add(g.get(i));
            }
        }

        int result = tempNums.get(0);

        for (int i = 0; i < tempOps.size(); i++) {
            if (tempOps.get(i) == '+')
                result += tempNums.get(i + 1);
            else
                result -= tempNums.get(i + 1);
        }

        return result;
    }
}