package boj.prb149;

/*
https://www.acmicpc.net/problem/7785
회사에 있는 사람
 * */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder());
        for(int i=0; i<N; i++){
            String[] split = br.readLine().split(" ");
            if(split[1].equals("enter")){
                set.add(split[0]);
            }else{
                set.remove(split[0]);
            }
        }
        for(String str : set) System.out.println(str);
    }

}