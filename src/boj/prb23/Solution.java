package boj.prb23;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 * DP dynamic programming, 변수의 범위를 알아야 풀 수 있는 문제
 * */


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("100-200*300-500+20"));
    }

    public long solution(String expression) {
        List<Integer> opt = new ArrayList<>();
        List<Long> opd = new ArrayList<>();

        String[] temp = expression.split("[^0-9]");
        for (String number : temp)
            opd.add(Long.parseLong(number));

        temp = expression.split("[0-9]+");
        for (String operation : temp) {
            switch (operation) {
                case "+":
                    opt.add(1);
                    break;
                case "-":
                    opt.add(2);
                    break;
                case "*":
                    opt.add(3);
                    break;
            }
        }

        ;
        return DFS(opt, opd, new ArrayList<Integer>(), 0);
    }

    public Long DFS(List<Integer> opt, List<Long> opd, List<Integer> priority, int depth) {
        Long max = 0L;
        if (depth == 3) {
            return Math.abs(calc(new ArrayList<>(opt), new ArrayList<>(opd), priority));
        }

        for (int i = 1; i <= 3; i++) {
            if (priority.contains(i)) continue;
            priority.add(i);
            max = Math.max(max, DFS(opt, opd, priority, depth + 1));
            priority.remove(priority.size() - 1);
        }
        return max;
    }

    private Long calc(List<Integer> opt, List<Long> opd, List<Integer> priority) {

        for (Integer p : priority) {
            for (int i = 0; i < opt.size(); i++) {
                if (opt.get(i) == p) {
                    switch (p) {
                        case 1:
                            opd.set(i, opd.get(i) + opd.get(i+1));
                            break;
                        case 2:
                            opd.set(i, opd.get(i) - opd.get(i+1));
                            break;
                        case 3:
                            opd.set(i, opd.get(i) * opd.get(i+1));
                            break;
                    }
                    opt.remove(i);
                    opd.remove(i+1);
                    i--;
                }
            }
        }

        return opd.get(0);
    }

}