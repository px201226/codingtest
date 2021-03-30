package coopang.main1;

public class main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.getDigitProduct("123"));
        System.out.println(solution.getDigitProduct("001"));
        System.out.println(solution.getDigitProduct("1030"));
    }
}


class Solution {
    public int[] solution(int N) {

        int maxK = 0;
        int maxValue = 0;

        for(int i=2; i<10; i++){
            String despositValue = toDeposition(N,i);
            int digit = getDigitProduct(despositValue);
            if(maxValue <= digit){
                maxK = i;
                maxValue = digit;
            }
        }
        return new int[]{maxK,maxValue};
    }

    public int getDigitProduct(String value){
        int answer = 1;
        for(int i=0; i<value.length(); i++){
            if(value.charAt(i) == '0') continue;
            answer *= value.charAt(i) - '0';
        }
        return answer;
    }

    public String toDeposition(int orgValue, int n) {
        String answer = "";
        while (orgValue != 0) {
            answer = (orgValue % n) + answer;
            orgValue /= n;
        }
        return answer;
    }
}


