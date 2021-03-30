package boj.prb99;

/*
https://www.acmicpc.net/problem/1790
수 이어 쓰기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long tempK = K, numLength = 1, numCount = 9, totalNum = 0;
        while (tempK > numLength * numCount){
            totalNum += numCount;
            tempK -= numLength * numCount;
            numLength++;
            numCount *= 10;
        }
        System.out.println(tempK-1);
        System.out.println(numLength);
        System.out.println((tempK-1) / numLength+1);
        totalNum += (tempK-1) / numLength+1;
        System.out.println(totalNum);
        if(totalNum>N){
            System.out.println("-1");
            return;
        }
        int mod = (int) ((tempK-1) % numLength);
        int base = 1;
        for (int i = 0; i < numLength - 1; i++)
            base *= 10;

        long result = base + (tempK-1) / numLength;
        System.out.println(String.valueOf(result).charAt(mod));

    }


}



