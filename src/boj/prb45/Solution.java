package boj.prb45;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 * */

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(100,100,new int[][]{{0,0},{0,0}}));
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long[][] dp = new long[n+1][m+1];
        for(int[] puddle : puddles)
            dp[puddle[1]][puddle[0]] = -1;

        dp[1][1] = 1;
        for(int y=1; y<=n; y++){
            for(int x=1; x<=m; x++){
                if(dp[y][x] == -1) {
                    dp[y][x] = 0;
                    continue;
                }

                if(y!=1) dp[y][x] += dp[y-1][x] % 1000000007;
                if(x!=1) dp[y][x] += dp[y][x-1] % 1000000007;
            }

        }

        return (int)dp[n][m] % 1000000007;
    }


}