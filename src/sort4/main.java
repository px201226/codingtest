package sort4;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{10, 9, 8, 0, 0}));
    }
}

class Solution {
    public int solution(int[] citations) {

        Arrays.sort(citations);

        int hindex = 0;
        for(int h=1; h<=citations.length; h++){
            int count = 0;
            for(int i=0; i<citations.length; i++){
                if(citations[i] >= h){
                    count++;
                }
            }


            if(count >= h)
                hindex = Math.max(hindex,h);
        }

        return hindex;
    }
}