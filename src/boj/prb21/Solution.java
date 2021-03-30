package boj.prb21;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/12941
 * 정렬문제
 * */

import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length ; i++){
            answer += A[i] * B[A.length - 1 - i];
        }

        return answer;
    }
}