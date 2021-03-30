package boj.prb89;

/*
https://www.acmicpc.net/problem/5430
AC
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T; t++){
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String temp = br.readLine().replace("[","").replace("]","").replace(","," ");
            StringTokenizer st = new StringTokenizer(temp);
            int[] list = new int[N];
            for(int i=0; i<N; i++)
                list[i] = Integer.parseInt(st.nextToken());

            int[] pointer = new int[]{0,N};
            int reverse = 0;
            for(int c=0; c<command.length(); c++){

                if(command.charAt(c) == 'R')
                    reverse = (reverse + 1) % 2;

                if(command.charAt(c) == 'D')
                    increasePointer(pointer,reverse);

                if(pointer[0] > pointer[1])
                    break;
            }

            if(pointer[0] > pointer[1])
                System.out.println("error");
            else{
                List<Integer> collect = Arrays.stream(Arrays.copyOfRange(list, pointer[0], pointer[1] )).boxed().collect(Collectors.toList());
                if(reverse == 1) Collections.reverse(collect);
                System.out.println(Arrays.toString(collect.toArray()).replace(" ",""));
            }
        }
    }

    private static void increasePointer(int[] pointer, int idx){
        if(idx ==0) pointer[0]++;
        else pointer[1]--;
    }
}



