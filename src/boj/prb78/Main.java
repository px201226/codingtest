package boj.prb78;

/*
https://www.acmicpc.net/problem/2960
소수 찾기
 * */


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] cache = new boolean[N + 1];

        int k = 0;
        for (int i = 2; i <= N ; i++) {
            if (cache[i]) continue;
            for (int j = i; j <= N; j += i) {
                if (cache[j]) continue;
                cache[j] = true;
                k++;
                if (k == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }

}



