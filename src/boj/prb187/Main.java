package boj.prb187;

/*
문장 반전
This is a Carrer Monk String ->
String Monk Carrer a is This
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        reverse(chars,0,chars.length-1);
        for(int start=0,end=0; end < chars.length; end++){
            if(chars[end] != ' '){
                start = end;
                while (end < chars.length && chars[end] != ' ')
                    end++;
                reverse(chars,start,end-1);

            }
        }
        System.out.println(chars);
    }


    public static void reverse(char[] chars, int start, int end){
        for(;start<end; start++,end--){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }
    }
}
