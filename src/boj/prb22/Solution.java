package boj.prb22;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 * DP dynamic programming, 변수의 범위를 알아야 풀 수 있는 문제
 * */


import java.math.BigInteger;

public class Solution {
    public int solution(int n) {
        return fibo(n) ;
    }

    public int fibo(int n){
        BigInteger cache[] = new BigInteger[n+1];
        cache[0] = BigInteger.valueOf(0);
        cache[1] = BigInteger.valueOf(1);

        for(int i=2; i<=n; i++){
            cache[i] = cache[i-1].add(cache[i-2]);
        }
        return cache[n].mod(BigInteger.valueOf(1234567)).intValue();
    }
}