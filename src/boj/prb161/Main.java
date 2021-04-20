package boj.prb161;

/*
https://www.acmicpc.net/problem/15810
풍선공장
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String args[]) {
        int arr[] = { 1, 3, 3, 5, 7 };
        int key = 1;

        System.out.printf("upperBound of %d is %d(Index)\n",
                key, upperBound(arr, 0, arr.length-1, key));
        System.out.printf("lowerBound of %d is %d(Index)\n",
                key, lowerBound(arr, 0, arr.length-1, key));
    }

    public static int upperBound(int arr[], int front, int rear, int key){
        int mid;
        while(front<rear){
            mid = (front + rear) / 2;
            System.out.printf("%d,%d,arr[%d]=%d\n",front,rear,mid,arr[mid]);
            if(arr[mid] <= key) front = mid + 1;
            else rear = mid;
        }
        return rear;
    }

    public static int lowerBound(int arr[], int front, int rear, int key){
        int mid;
        while(front<rear){
            mid = (front + rear) / 2;
            System.out.printf("%d,%d,arr[%d]=%d\n",front,rear,mid,arr[mid]);
            if(arr[mid] < key) front = mid + 1;
            else rear = mid;
        }
        return rear;
    }

//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int[] arr = new int[N];
//        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
//
//        long low = 0, high = 1000000000000L;
//        while (low<high){
//            long mid = (low + high ) / 2;
//            long available = 0;
//            for(int i=0; i<N; i++){
//                available += (mid / arr[i]);
//            }
//            if(available < K) low = mid+1;
//            else high = mid;
//        }
//        System.out.println(high);
//    }

}