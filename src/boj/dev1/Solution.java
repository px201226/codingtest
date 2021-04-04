package boj.dev1;

import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public static void main(String[] args) {
        int[] lotts = new int[]{44, 1, 0, 0, 31, 25};
        int[] win = new int[]{31, 10, 45, 1, 6, 19};
        Solution solution = new Solution();
        int[] solution1 = solution.solution(lotts,win);
         System.out.println(Arrays.toString(solution1));
    }

    public HashMap<Integer,Integer> ranks = new HashMap<>(){
        {
            put(6,1);
            put(5,2);
            put(4,3);
            put(3,4);
            put(2,5);
            put(1,6);
            put(0,6);
        }
    };
    public int[] solution(int[] lottos, int[] win_nums) {

        int equalsConut = 0;
        int zeroCount = 0;
        for(int i=0; i<lottos.length; i++){

            int baseNum = lottos[i];

            if(baseNum == 0){
                zeroCount++;
                continue;
            }

            for(int j=0; j<win_nums.length; j++){
                if(win_nums[j] == baseNum){
                    equalsConut++;
                    break;
                }
            }
        }
        return new int[]{ranks.get(equalsConut+zeroCount), ranks.get(equalsConut)};
    }

}