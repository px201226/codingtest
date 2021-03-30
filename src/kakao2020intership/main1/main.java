package kakao2020intership.main1;

public class main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));

    }
}


class Solution {
    public final static String LEFT_NUMBERS = "147";
    public final static String RIGHT_NUMBERS = "369";
    public final static String[] SET_NUMBERS = new String[]{LEFT_NUMBERS,RIGHT_NUMBERS};
    public final static String CENTER_NUMBERS = "2580";

    public String solution(int[] numbers, String hand) {
        int[] lrIdx = new int[]{3,3};
        char[] lrChar = new char[]{'L','R'};
        int[] isNotCenter = new int[]{1,1};
        int defalutIdx = hand.equals("left") ? 0 : 1;

        StringBuilder answer = new StringBuilder();

        for(int num : numbers){
            boolean isFind = false;
            int find = 0;
            for(int i=0; i<2; i++){
                find = SET_NUMBERS[i].indexOf(Integer.toString(num));
                if(find != -1){
                    answer.append(lrChar[i]);
                    lrIdx[i] = find;
                    isFind = true;
                    isNotCenter[i] = 1;
                    break;
                }
            }

            if(isFind) continue;

            find = CENTER_NUMBERS.indexOf(Integer.toString(num));
            int leftDistance = Math.abs(find - lrIdx[0]) + isNotCenter[0];
            int rightDistance = Math.abs(find - lrIdx[1]) + isNotCenter[1];
            System.out.format("num=%d, left=%d, right=%d\n",num,lrIdx[0],lrIdx[1]);
            System.out.format("left dis=%d, right dis=%d\n",leftDistance,rightDistance);
            if(leftDistance < rightDistance){
                isNotCenter[0] = 0;
                lrIdx[0] = find;
                answer.append(lrChar[0]);
            }else if(leftDistance > rightDistance){
                isNotCenter[1] = 0;
                lrIdx[1] = find;
                answer.append(lrChar[1]);
            }else{
                isNotCenter[defalutIdx] = 0;
                lrIdx[defalutIdx] = find;
                answer.append(lrChar[defalutIdx]);
            }
        }
        return answer.toString();
    }

}
