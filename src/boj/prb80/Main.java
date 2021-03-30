package boj.prb80;

/*
https://www.acmicpc.net/problem/2331
반복수열
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(A);
        while (true){
            String num = String.valueOf(list.get(list.size()-1));
            int sum = 0;
            for(int i=0; i<num.length(); i++){
                sum += pow(Character.getNumericValue(num.charAt(i)), P);
            }
            int find = list.indexOf(sum);
            if(find >= 0){
                System.out.println(find);
                return;
            }else{
                list.add(sum);
            }
        }

    }
    public static int pow(int n, int p){
        return (int) Math.pow(n,p);
    }

}



