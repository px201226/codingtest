package boj.prb32;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/12977
 조합과 소수 알고리즘
 * */
class Solution {
    public int solution(int[] nums) {
        return combination(nums, new boolean[nums.length], 0,0);
    }

    private int combination(int[] nums, boolean[] isSelect,int select, int begin){
        int answer = 0;
        if(select == 3){
            int sum = 0;
            for(int i=0; i<nums.length; i++){
                if(isSelect[i]) sum += nums[i];
            }
            return isPrime(sum) == true ? 1 : 0;
        }

        for(int i=begin; i<nums.length; i++){
            isSelect[i] = true;
            answer += combination(nums, isSelect,select+1,i+1);
            isSelect[i] = false;
        }
        return answer;
    }
    private boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num) ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}