package boj.prb176;

/*
https://www.acmicpc.net/problem/1541
잃어버린 괄호
 * */
import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int answer = Integer.MIN_VALUE;
        while (st.hasMoreTokens()) {
            StringTokenizer sick = new StringTokenizer(st.nextToken(),"+");

            int sum=0;
            while(sick.hasMoreTokens()){
                sum += Integer.parseInt(sick.nextToken());
            }

            if(answer == Integer.MIN_VALUE){
                answer = sum;
            }else{
                answer -= sum;
            }
        }
        System.out.println(answer);
    }
}