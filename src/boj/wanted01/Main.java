package boj.wanted01;


import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) -1;
        List<Integer> answer = new ArrayList<>();
        int[] wait = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            wait[i] = Integer.parseInt(st.nextToken());


        while (answer.size() < N){
            if(wait[K] ==0){
                K = (K+1) % N;
                continue;
            }

            wait[K]--;
            if (wait[K] == 0) {
                answer.add(K+1);
            }
            K = (K+1) % N;
        }

        answer.forEach(i -> System.out.print(i + " "));
    }

}

