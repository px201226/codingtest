package boj.prb83;

/*
https://www.acmicpc.net/problem/1966
구현, 프린터 큐
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int[] priority = new int[10];
            Queue<int []> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++) {
                int p = Integer.parseInt(st.nextToken());
                queue.add(new int[]{i,p});
                priority[p]++;
            }

            int idx = 9;
            int answer = 0;
            while (!queue.isEmpty()){
                if(priority[idx] == 0){
                    idx--;
                    continue;
                }
                int[] poll = queue.poll();
                if(poll[1] == idx) {
                    answer++;
                    priority[idx]--;
                    if(poll[0] == target){
                        System.out.println(answer);
                        break;
                    }
                }else{
                    queue.add(poll);
                }
            }

        }
    }

}



