package greedy3;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{40,40,40}, 100));
    }
}

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] isSelect = new boolean[people.length];

        int count = 0;
        int i=0, j=people.length-1;

        while(i<j){
            if(people[i] + people[j] <= limit){
                isSelect[i] = isSelect[j] = true;
                i++; j--; count++;
            }else {
                j--;
            }
        }

        for(boolean is : isSelect){
            if(is==false) count++;
        }
        return count;
    }
}


