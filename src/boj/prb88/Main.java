package boj.prb88;

/*
https://www.acmicpc.net/problem/15658
연산자 끼워넣기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> list = new ArrayList<>();
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++)
            list.add(Integer.parseInt(st.nextToken()));

        int[] opt = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            opt[i] = Integer.parseInt(st.nextToken());

        DFS(list,1,opt[0],opt[1],opt[2],opt[3],list.get(0));
        System.out.printf("%d\n%d",max,min);
    }

    public static void DFS(List<Integer> list, int index, int plus, int minus, int mult, int div, int num){
        if(list.size() == index){
            max = Math.max(num,max);
            min = Math.min(num,min);
            return;
        }

        if(plus > 0) DFS(list,index+1, plus-1, minus,mult,div, num+list.get(index));
        if(minus > 0) DFS(list,index+1, plus, minus-1,mult,div, num-list.get(index));
        if(mult > 0) DFS(list,index+1, plus, minus,mult-1,div, num*list.get(index));
        if(div > 0) DFS(list,index+1, plus, minus,mult,div-1, num/list.get(index));
    }
}



