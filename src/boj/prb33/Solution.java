package boj.prb33;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/12980
 수학적인 규칙을 찾는것이 핵심
 * */

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n != 0){
            if(n % 2 != 0){
                ans++;
                n--;
            }else{
                n = n / 2;
            }

        }
        return ans;
    }
}