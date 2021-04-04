package boj.kakao3;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 * DP dynamic programming, 변수의 범위를 알아야 풀 수 있는 문제
 * */

import java.util.*;

class Solution {
    public static void main(String[] args) {

        int[][] train1 = new int[][]{{1,2},{1,3},{1,4},{3,5},{3,6}};
        int[] passenger1 = new int[]{1,1,1,1,1,1};

        int[][] train2 = new int[][]{{1,2},{1,3},{2,4}};
        int[] passenger2 = new int[]{2,1,2,2};

        int[][] train3 = new int[][]{{1,2},{1,3},{1,4},{1,5}};
        int[] passenger3 = new int[]{1,1,2,3,4};

        int[][] train4 = new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{1,7},{7,8}};
        int[] passenger4 = new int[]{1,2,3,4,5,6,10,10};

        Solution solution = new Solution();
        int[] solution1 = solution.solution(8, passenger4, train4);
        System.out.println(Arrays.toString(solution1));
    }
    public int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {};

        boolean[][] map = new boolean[n+1][n+1];

        for(int i=0; i<train.length; i++){
           int u = train[i][0];
           int v = train[i][1];
           map[u][v] = map[v][u] = true;
        }

        return BFS(map,passenger);
    }

    public int[] BFS(boolean[][] map, int[] passenger){

        boolean[] isVisited = new boolean[map.length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,passenger[0]});
        isVisited[1] = true;

        int maxU = 0;
        int max = 0;
        while(!q.isEmpty()){
            int[] u = q.poll();
            if(u[1] > max){
                max = u[1]; maxU = u[0];
            }else if(u[1] == max && u[0] > maxU){
                maxU = u[0];
            }
            for(int v=1; v<map.length; v++){
                if(map[u[0]][v] && !isVisited[v]){
                    isVisited[v] = true;
                    q.add(new int[]{v,u[1] + passenger[v-1]});
                }
            }
        }
        return new int[]{maxU,max};
    }

}