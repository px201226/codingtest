package boj.prb17;


import java.util.HashMap;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 * HashMap
 * */


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    public int solution(int[] nums) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(Integer num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int selects = nums.length / 2;

        if(map.size() < selects){
            return map.size();
        }else{
            return selects;
        }

    }

}