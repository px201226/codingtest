package boj.prb34;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/12985#
 수학적인 규칙을 찾는것이 핵심
 * */
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        a = (a % 2 == 1 ? a+1 : a);
        b = (b % 2 == 1 ? b+1 : b);

        while((a=a/2) != (b=b/2)){
            a = (a % 2 == 1 ? a+1 : a);
            b = (b % 2 == 1 ? b+1 : b);
            answer++;
        }
        return answer;
    }
}