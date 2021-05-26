package boj.sixshop03;


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6));
    }
    public int solution(int n) {
        int answer = 0;

        if(n % 5 == 0)
            return  n / 5;

        for(int i=(n/5)*5; i>=0; i-=5){
            if((n - i) % 3 == 0 ){
                return  (i / 5)  + ((n-i) / 3);
            }
        }

        return answer;
    }

}

