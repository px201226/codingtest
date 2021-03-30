package boj.prb12;

/*
* https://programmers.co.kr/learn/courses/30/lessons/12900
* */
class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = 1;
        int b = 2;
        for(int i=3; i<=n; i++){
            answer = (a + b) % 1000000007;
            a = b;
            b = answer;
        }
        return answer;
    }
}