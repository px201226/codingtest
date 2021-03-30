package boj.prb82;

/*
https://www.acmicpc.net/problem/1213
팰린드롬 만들기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] frequency = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i=0; i<str.length();i++)
            frequency[str.charAt(i)-'A']++;

        boolean foundOddFreqyency = false;
        char oddAlphabet = 255;

        for(int i=0; i<frequency.length; i++){
            if(frequency[i] % 2 == 1){
                if(foundOddFreqyency == false) {
                    foundOddFreqyency = true;
                    oddAlphabet = (char) ((char)i + 'A');
                }else{
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        StringBuilder answer = new StringBuilder("");
        if(foundOddFreqyency){
            answer.append(oddAlphabet);
            frequency[oddAlphabet-'A']--;
        }

        for(int i=frequency.length-1; i>=0; i--){
            int repeat = frequency[i] / 2;
            if(repeat == 0) continue;
            String repeatAlphabet = String.valueOf((char)((char)i + 'A'));
            String appendStr = repeatAlphabet.repeat(repeat);
            answer.insert(0, appendStr);
            answer.append(appendStr);
        }
        System.out.println(answer);
    }

}



