package sort2;

import java.util.Arrays;
import java.util.Comparator;

public class main {

    public static void main(String[] args) {

       Solution solution = new Solution();

        System.out.println((solution.solution(new int[]{12,121})));
        System.out.println((solution.solution(new int[]{21,212})));

    }

}

class Solution {
    public String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();

        Integer[] WrapNumbers = Arrays.stream(numbers).boxed().toArray( Integer[]::new );

        Arrays.sort(WrapNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = o1.toString() + o2.toString();
                String b = o2.toString() + o1.toString();
                return b.compareTo(a);
            }
        });

        for(int num: WrapNumbers){
            answer.append(num);
        }
        if(answer.charAt(0) == '0') return "0";
        return answer.toString();
    }
}
