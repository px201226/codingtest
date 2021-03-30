package boj.prb41;


import java.util.Arrays;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 * */

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Long.MAX_VALUE;
        long left = 1;
        long right = (long)times[times.length-1]*n  / times.length;;
        while(left <= right){
            long expectTime = (left + right) / 2;
            long completeN = 0;
            for(int time:times)
                completeN += expectTime / time;

            if(completeN >= n){
                answer = expectTime < answer ? expectTime : answer;
                right = expectTime-1 ;
            }else
                left = expectTime+1;
        }
        return answer;
    }
}