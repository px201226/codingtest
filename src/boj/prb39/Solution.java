package boj.prb39;


import java.util.LinkedList;
import java.util.Queue;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42895
 * */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
    public int solution(int n, int[][] edges) {
        int answer = 0;

        boolean[][] dist = new boolean[n+1][n+1];
        for(int[] edge : edges){
            dist[edge[0]][edge[1]] = true;
            dist[edge[1]][edge[0]] = true;
        }


        return BFS(dist, n);
    }

    public int BFS(boolean[][] isConnet, int n){
        Queue<int[]> queue = new LinkedList<>();
        int[] dist = new int[n+1];
        int max = 0, answer =0;

        queue.add(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            dist[point[0]] = point[1];
            max = Math.max(answer,point[1]);
            for(int i=1; i<n+1; i++){
                if(dist[i] == 0 && isConnet[point[0]][i] && point[0] != i && i != 1){
                    dist[i] = point[1] +1;
                    queue.add(new int[]{i, point[1]+1});
                }
            }

        }

        for(int i=1; i<dist.length; i++){
            if( dist[i] == max) answer++;
        }
        return answer;

    }
}