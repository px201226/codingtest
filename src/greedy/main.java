package greedy;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3,new int[]{3}, new int[]{1}));
    }
}
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] cloths = new int[n];
        Arrays.fill(cloths, 1);

        for(int i : lost)
            cloths[i-1]--;

        for(int i : reserve)
            cloths[i-1]++;

        for(int i=0; i<cloths.length; i++){
            if(cloths[i] == 2){
                //왼쪽
                if(i-1 >= 0 ){
                    if(cloths[i-1] == 0){
                        cloths[i-1] ++;
                        cloths[i]--;
                        continue;
                    }
                }
                //오른쪽
                if(i+1 < cloths.length ){
                    if(cloths[i+1] == 0){
                        cloths[i+1]++;
                        cloths[i]--;
                        continue;
                    }
                }
            }
        }

        return  Arrays.stream(cloths).filter((i) -> i >= 1).toArray().length;
    }
}