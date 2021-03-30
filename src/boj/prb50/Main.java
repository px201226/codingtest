package boj.prb50;

/*
https://www.acmicpc.net/problem/2501
 * */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        for(int i=1; i<=N; i++){
            if(N % i == 0) K--;
            if(K == 0) {
                System.out.println(i);
                return ;
            }
        }
        System.out.println("0");
    }
}