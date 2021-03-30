package boj.prb36;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/12953
 3개 수의 최소공배수는 = a,b의 최소공배수 r 과 c의 최소공배수
 * */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.solution(16,16,2,1));
    }
    public String solution(int n, int t, int m, int p) {
        StringBuilder temp = new StringBuilder("");
        int num = 1;
        temp.append("0");
        while(temp.length() <= t * m ){
            String to = changeNumber(num++, n);
            temp.append(to);
        }
        StringBuilder answer = new StringBuilder("");
        int index = p - 1;
        for(int i=0; i<t; i++){
            answer.append(temp.charAt(index));
            index += m;
        }
        return answer.toString();
    }

    public String changeNumber(int num, int i) {
        String answer = "";
        int remainder = 0;
        while(num != 0) {
            remainder = num%i;
            if(num%i < 10) {
                answer = remainder + answer;
            } else {
                //A=65, B=66, C=67, D=68, E=69, F=70
                answer = (char)(remainder + 55) + answer;
            }
            num /= i;
        }
        return answer;
    }
}