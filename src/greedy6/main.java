package greedy6;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{2,4},{1,3},{5,6}}));
    }
}



class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (a,b) -> a[0] - b[0]);
        int minPostion = routes[0][1];
        for(int i=1; i<routes.length; i++){
            if(routes[i][1] < minPostion)
                minPostion = routes[i][1];
            if(routes[i][0] > minPostion){
                answer++;
                minPostion = routes[i][1];
            }
        }
        return answer;
    }
}