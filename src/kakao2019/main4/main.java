package kakao2019.main4;

import java.util.ArrayList;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5,6,2,5,2},14));
    }
}


class Solution {
    public int solution(int[] food_times, long k) {
        int answer = -1;

        int[][] food_timeOfindex = new int[food_times.length][2];

        for(int i=0; i<food_times.length; i++){
            food_timeOfindex[i][0] = i;
            food_timeOfindex[i][1] = food_times[i];
        }

        Arrays.sort(food_timeOfindex, (o1,o2) -> (o1[1] - o2[1]));

        for(int i=0; i<food_timeOfindex.length; i++){
            long eating = (i==0) ? 0 : food_timeOfindex[i-1][1];
            long remainder = food_timeOfindex[i][1] - eating;
            long time = remainder * (food_timeOfindex.length - i);
            if(k - time >= 0){
                k = k - time;
            }else{
                int[][] temp = Arrays.copyOfRange(food_timeOfindex, i, food_timeOfindex.length);
                Arrays.sort(temp, (o1,o2) -> (o1[0] - o2[0]));
                int index = (int) (k % (food_timeOfindex.length - i));
                return temp[index][0] + 1;
            }
        }


        return answer;
    }
}