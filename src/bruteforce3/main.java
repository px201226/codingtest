package bruteforce3;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(8,1)));
    }
}


class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int tile = brown + yellow;
        int height = 3;
        int width=0, predictYellow = 0;
        while (predictYellow != yellow) {
            if(tile % height != 0){
                height++;
                continue;
            };
            width = tile / height;
            if(width < height) break;
            predictYellow = (height -2) * (width-2);
            height++;
        }
        answer = new int[]{width,height-1};
        return answer;
    }
}