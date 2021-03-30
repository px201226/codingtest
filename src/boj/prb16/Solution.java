package boj.prb16;


import java.util.Arrays;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/12913
 * DP
 * land[y][x] = [y][x] 지점을 선택했을 때 최대 포인트
 * */


public class Solution
{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] land = new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(solution.solution(land));
    }

    public  int solution(int[][] land) {
        for(int y=1; y<land.length; y++){
            for(int i=0; i<4; i++){
                int point = land[y][i];
                for(int j=0; j<4; j++){
                    if(i == j) continue;
                    land[y][i] = Math.max(land[y][i], land[y-1][j] + point);
                }
            }
        }
        int[] temp = land[land.length-1];
        return Arrays.stream(temp).max().getAsInt();
    }
}