package boj.prb114;

/*
https://www.acmicpc.net/problem/1339
단어수학
 * */

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        List<Character> list = new ArrayList<>();

        for(int n=0; n<N; n++){
            strings[n] = br.readLine();
            for(char c : strings[n].toCharArray()) if(!list.contains(c)) list.add(c);
        }
        System.out.println(max(strings,list,new boolean[10], new int[10],0));
    }

    public static int max(String[] strings, List<Character> list, boolean[] isSelect,int[] num, int depth){
        int answer = 0;
        if(depth == list.size()){
            int sum = 0;
            for(String string : strings){
                int cToNum = 0;
                for (int j = 0; j < string.length(); j++) {
                    cToNum *= 10;
                    cToNum += num[list.indexOf(string.charAt(j)) ];
                }
                sum += cToNum;
            }
            return sum;
        }

        for(int i=0; i<10; i++){
            if(isSelect[i]) continue;
            isSelect[i] = true;
            num[depth] = i;
            answer = Math.max(answer,max(strings,list,isSelect,num,depth+1));
            isSelect[i] = false;
        }

        return answer;
    }

}
