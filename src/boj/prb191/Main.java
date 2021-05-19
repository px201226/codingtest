package boj.prb191;

/*
https://www.acmicpc.net/problem/10384
펜그램
 * */
import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            Map<Character, Integer> freqByChar = new HashMap<>();
            for(char c = 'A'; c<='Z'; c++)
                freqByChar.put(c,0);

            for(char ch : str.toCharArray()) {
                if(Character.isAlphabetic(ch))
                    freqByChar.put(Character.toUpperCase(ch), freqByChar.get(Character.toUpperCase(ch)) + 1);
            }
            String answer = "";
            int min = freqByChar.values().stream().mapToInt(a -> a).min().getAsInt();
            if(min == 0){
                answer = "Not a pangram";
            }else if(min == 1){
                answer = "Pangram!";
            }else if(min == 2){
                answer = "Double pangram!!";
            }else
                answer = "Triple pangram!!!";
            System.out.printf("Case %d: %s\n", i+1, answer);
        }
    }
}