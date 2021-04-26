package boj.prb173;

/*
https://www.acmicpc.net/problem/4949
균형잡힌 세상
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(solve("aaaaaaaaaaaaaaaaaaaa","abcd", new int[]{0,1,2,3,4,5,6}));
    }

    public static String solve(String str, String keyword, int[] skips){
        System.out.println((int)'a');
        System.out.println((int)'A');
        System.out.println((char)('a' - 32));
        StringBuilder answer = new StringBuilder(str);
        int idx = 0;
        for(int i=0; i<skips.length; i++){
            int skip = skips[i];
            char ch = keyword.charAt(i % keyword.length());
            if(idx+skip > answer.length()){
                return answer.toString();
            }
            int end = idx+skip;
            for(int j=idx; j<end; j++){
                if(answer.charAt(j) == ch) break;
                idx++;
            }

            answer.insert(idx++,Character.toUpperCase(ch));
            System.out.println(idx);
            System.out.println(answer + "," + answer.length());
        }
        return answer.toString();
    }
}