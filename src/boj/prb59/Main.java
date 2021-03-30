package boj.prb59;

/*
https://www.acmicpc.net/problem/1062
조합
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for(int i=0; i<N; i++)
            words[i] = br.readLine();

        boolean[] isUsed = new boolean[26];
        isUsed['a'-'a'] = isUsed['c'-'a'] = isUsed['i'-'a'] = isUsed['n'-'a'] = isUsed['t'-'a'] = true;
        K-=5;
        System.out.print(DFS(isUsed,0,0,K));
    }

    public static int DFS(boolean[] isUsed, int idx, int count, int K){
        if(count == K){
            return getPassedWord(isUsed);
        }

        int answer = 0;
        for(int i=idx; i<26; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                answer = Math.max(answer,DFS(isUsed,i,count+1,K));
                isUsed[i] = false;
            }
        }
        return answer;
    }

    public static int getPassedWord(boolean[] isUsed){
        int answer = 0;
        for(String word:words){
            boolean isPassed = true;
            for(int i=0; i<word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(!isUsed[index]){
                    isPassed = false;
                    break;
                }
            }

            if(isPassed) answer++;
        }

        return answer;
    }

}