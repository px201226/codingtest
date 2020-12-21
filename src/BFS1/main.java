package BFS1;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(3,new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

}

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] isVisit = new boolean[n];
        for(int i=0; i<n; i++){
            if(!isVisit[i]){
                answer++;
                BFS(computers, i, isVisit);
                System.out.println(Arrays.toString(isVisit));
            }

        }

        return answer;
    }

    private void BFS(int[][] computers, int vertex, boolean[] isVisit) {
        isVisit[vertex] = true;
        for(int i=0; i<computers[0].length; i++){
            if(vertex != i && !isVisit[i] && computers[vertex][i] == 1){
                BFS(computers,i, isVisit);
            }
        }
    }
}
