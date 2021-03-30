package boj.prb27;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/72413
  Floyd 알고리즘을 이용해 A,B 탑승자의 K 지점을 구해
  * cost(s,k) + cost(k,a) + cost(k,b)가 최소가 되는 점을 구한다.
 * */

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[][] cost = new int[n+1][n+1];
        for(int[] fare : fares){
            cost[fare[0]][fare[1]] = fare[2];
            cost[fare[1]][fare[0]] = fare[2];
        }

        for(int k=1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    if(i==j) continue;
                    if(cost[i][k] == 0 || cost[k][j] == 0) continue;
                    if(cost[i][j] == 0)
                        cost[i][j] = cost[i][k] + cost[k][j];
                    else
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        for(int k=1; k<n+1; k++){
            if(cost[s][k] + cost[k][a] + cost[k][b] == 0) continue;
            answer = Math.min(answer, cost[s][k] + cost[k][a] + cost[k][b] );
        }
        return answer;
    }
}