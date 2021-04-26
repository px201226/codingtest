package boj.prb174;

/*
https://www.acmicpc.net/problem/1427
소트인사이드
 * */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer[] ints = str.chars().mapToObj(i ->  i-'0').toArray(Integer[]::new);
        Arrays.sort(ints, Comparator.reverseOrder());
        for(int i=0; i<ints.length; i++) System.out.print(ints[i]);
    }
}