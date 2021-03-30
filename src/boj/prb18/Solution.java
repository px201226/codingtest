package boj.prb18;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/12924
 * 완전탐색
 * */


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(15);
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    System.out.printf("i=%d, j=%d\n", i,j);
                    break;
                } else if (sum > n) {
                    break;
                }
            }

        }
        return answer;

    }

}