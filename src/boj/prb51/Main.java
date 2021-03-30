package boj.prb51;

/*
https://www.acmicpc.net/problem/3460
 * */


import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int number = sc.nextInt();
            String toBinary = Integer.toBinaryString(number);
            printBinaryOne(toBinary);
        }
    }

    public static void printBinaryOne(String binary){
        for(int i=binary.length()-1; i>=0; i--){
            if(binary.charAt(i) == '1')
                System.out.print(Math.abs(binary.length()-1-i) + " ");
        }
        System.out.print("\n");
    }
}