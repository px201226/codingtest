package boj.prb124;

/*
https://www.acmicpc.net/problem/1543
문서검색
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doucument = br.readLine();
        String find = br.readLine();

        int answer =0;
        int pointer = 0;
        while(pointer+find.length() <= doucument.length()){
            boolean isFind = true;
            for(int i=0; i<find.length(); i++){
                if(find.charAt(i) != doucument.charAt(pointer+i)){
                    isFind = false;
                    break;
                }
            }
            if(isFind){
                answer++;
                pointer += find.length();
            }else{
                pointer++;
            }
        }
        System.out.println(answer);
    }


}
