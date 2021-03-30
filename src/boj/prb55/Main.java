package boj.prb55;

/*
https://www.acmicpc.net/problem/2609
최대공약수, 최소공배수
 * */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = getGcd(a>=b?a:b,a>=b?b:a);
        int lcm = a * b / gcd;
        System.out.printf("%d\n%d",gcd,lcm);
    }

    public static int getGcd(int a, int b){
        if(a % b == 0)
            return b;
        return getGcd(b,a%b);
    }
}