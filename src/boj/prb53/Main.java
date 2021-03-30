package boj.prb53;

/*
https://www.acmicpc.net/problem/2460
 * */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int temp = 0;
        for(int i=0; i<10; i++){
            int minus = sc.nextInt();
            int plus = sc.nextInt();
            temp -= minus;
            temp += plus;
            max = Math.max(temp,max);
        }

        System.out.print(max);
    }
}