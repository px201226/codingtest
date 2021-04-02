package boj.prb112;

/*
https://www.acmicpc.net/problem/2580
스도쿠
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        List<int[]> list = new ArrayList<>();
        for(int h=0; h<9; h++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int w=0; w<9; w++){
                arr[h][w] = Integer.parseInt(st.nextToken());
                if(arr[h][w] == 0) list.add(new int[]{w,h});
            }
        }
        DFS(arr,list,0);
        for(int[] ar : arr){
            for(int n : ar){
                System.out.print(n + " ");
            }
            System.out.println("");
        }
    }

    public static boolean DFS(int[][] arr, List<int[]> list, int depth){
        if(list.size() == depth){
            return true;
        }
        for(int i=1; i<=9; i++){
            int[] ints = list.get(depth);
            if(isPromise(arr,ints[0],ints[1],i)){
                arr[ints[1]][ints[0]] = i;
                if(DFS(arr,list,depth+1))
                    return true;
                arr[ints[1]][ints[0]] = 0;
            }


        }
        return false;
    }

    private static boolean isPromise(int[][] arr, int x, int y, int i) {
        for (int k = 0; k < 9; k++) {
            if (arr[y][k] == i || arr[k][x] == i) {
                return false;
            }
        }
        for (int k = (y / 3) * 3; k < (y / 3) * 3 + 3; k++) {
            for (int j = (x / 3) * 3; j < (x / 3) * 3 + 3; j++) {
                if (arr[k][j] == i) {
                    return false;
                }
            }
        }
        return true;

    }
}
