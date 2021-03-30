package boj.prb35;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/12953
 3개 수의 최소공배수는 = a,b의 최소공배수 r 과 c의 최소공배수
 * */
class Solution {
    public int solution(int[] arr) {
        int lcm1 = 1;
        for (int i = 0; i < arr.length; i++) {

            lcm1 = lcm(lcm1, arr[i]);

        }
        return lcm1;
    }


    int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}