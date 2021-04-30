package boj.prb177;

/*
https://www.acmicpc.net/problem/5525
IOI
 * */
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.readLine();
        char[] str = br.readLine().toCharArray();

        int answer = 0;
        int repeat = 0;
        for(int i=1; i<str.length-1; i++){
            if(str[i-1] == 'I' && str[i] == 'O' && str[i+1] == 'I'){
                repeat++;
                i++;
                if(repeat >= N) answer++;
            }else{
                repeat = 0;
            }
        }

        System.out.println(answer);
    }
}