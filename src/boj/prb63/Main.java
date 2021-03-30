package boj.prb63;

/*
https://www.acmicpc.net/problem/1916
숨바꼭질
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N,0});
        boolean[] isVisited = new boolean[100001];
        while(true){

            int[] point = queue.poll();
            System.out.println(Arrays.toString(point));
            int curPos = point[0];
            int curTime = point[1];

            isVisited[curPos] = true;
            if(curPos == K){
                System.out.println(curTime);
                return;
            }

            if(curPos-1 > 0 && !isVisited[curPos-1]) queue.add(new int[]{curPos-1,curTime+1});
            if(curPos+1 < isVisited.length && !isVisited[curPos+1]) queue.add(new int[]{curPos+1,curTime+1});
            if(curPos*2 < isVisited.length && !isVisited[curPos*2]) queue.add(new int[]{curPos*2,curTime+1});
        }


    }

}

