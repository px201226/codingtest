package boj.prb142;

/*
https://www.acmicpc.net/problem/1038
감소하는 수
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] numArrs = new int[]{0,1,2,3,4,5,6,7,8,9};
    public static List<Long> desc = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        comb(9,0L);
        Collections.sort(desc);
        System.out.println(N+1 >= desc.size() ? -1 :desc.get(N+1));
    }

    public static void comb(int idx, Long sum){
        if(idx == -1) {
            desc.add(sum);
            return;
        }

        comb(idx-1, sum);
        comb(idx-1,sum*10 + numArrs[idx]);
    }

}
