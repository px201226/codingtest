package boj.prb44;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 * */

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] isConnetive = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            isConnetive[result[0]][result[1]] = true;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j) continue;
                    if (!isConnetive[i][k] || !isConnetive[k][j]) continue;
                    isConnetive[i][j] = isConnetive[i][k] & isConnetive[k][j];
                }
            }
        }

        for(boolean[] d : isConnetive){
            System.out.println(Arrays.toString(d));
        }
        for (int i = 1; i < n + 1; i++) {
            boolean flag = true;
            for (int j = 1; j < n + 1; j++) {
                if (i == j) continue;
                if (!isConnetive[i][j] && !isConnetive[j][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}