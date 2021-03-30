package greedy5;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {


        Solution solution = new Solution();
        int solution1 = solution.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
        System.out.println(solution1);
    }
}

class Solution {

    public int find(int[] parent, int a){
        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent,parent[a]);
    }

    public void union(int[] parent, int a, int b){
        int u = find(parent,a);
        int v = find(parent,b);
        if(u < v)
            parent[v] = u;
        else
            parent[u] = v;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[100];

        Arrays.sort(costs,(a,b) -> a[2] - b[2]);
        for(int i=0; i<100; i++)
            parent[i] = i;

        for(int i=0; i<costs.length; i++){
            if(find(parent,costs[i][0]) != find(parent,costs[i][1])){
                answer += costs[i][2];
                union(parent,costs[i][0], costs[i][1]);
            }
        }

        return answer;
    }
}
