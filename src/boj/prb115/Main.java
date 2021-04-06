package boj.prb115;

/*
https://www.acmicpc.net/problem/2003
수들의 합 2 투포인터
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (true) {
            System.out.println(sum);
            if (sum > m) {
                sum -= arr[left++];
            } else if (right == n) {
                break;
            } else {
                sum += arr[right++];
            }

            if (sum == m)
                count++;


        }

//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += arr[j];
//                if (sum == m) {
//                    count++;
//                    break;
//                } else if (sum > m) {
//                    break;
//
//
//                }
//            }
//
//        }
        System.out.println(count);


    }
}
