package boj.prb52;

/*
https://www.acmicpc.net/problem/10818
 * */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i=0; i<N; i++)
            array[i] = sc.nextInt();

        int min = 1000000;
        int max = -1000000;
        for(int number : array){
            if(number < min) min = number;
            if(number > max) max = number;
        }

        System.out.printf("%d %d",min,max);
    }


}