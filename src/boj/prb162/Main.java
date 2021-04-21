package boj.prb162;

/*
https://www.acmicpc.net/problem/17503
맥주 축제, priorityQueue 우선순위 큐
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int lowerBound = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[K][2];
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int profit = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[k][0] = profit;
            arr[k][1] = cost;
        }

        long low = 0, high = 10000000000000L;
        while (low<high){
            long mid = (low+high) / 2;
            if(check(arr,N,lowerBound,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        System.out.println(high == 10000000000000L ? -1 : high);

    }

    public static boolean check(int[][] arr, int N, int M,long costMax){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if (arr[i][1] <= costMax)
                list.add(arr[i][0]);
        }
        if(list.size() < N) return false;
        Collections.sort(list);
        int sum = 0;
        for(int i=0; i<N; i++){
            sum += list.get(list.size()-i-1);
        }
        return (sum >= M);
    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int lowerBound = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        int[][] arr = new int[K][2];
//        for(int k=0; k<K; k++){
//            st = new StringTokenizer(br.readLine());
//            int profit = Integer.parseInt(st.nextToken());
//            int cost = Integer.parseInt(st.nextToken());
//            arr[k][0] = profit;
//            arr[k][1] = cost;
//        }
//        Arrays.sort(arr,(a,b) -> a[1] - b[1]);
//        int sum = 0;
//        for(int k=0; k<K; k++){
//            pq.offer(arr[k][0]);
//            sum += arr[k][0];
//
//            if(pq.size() > N){
//                sum -= pq.poll();
//            }
//            if(pq.size() == N && sum >= lowerBound){
//                System.out.println(arr[k][1]);
//                return;
//            }
//        }
//        System.out.println(-1);
//    }
}