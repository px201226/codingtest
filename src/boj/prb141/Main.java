package boj.prb141;

/*
https://www.acmicpc.net/problem/2589
보물섬
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void DFS(ArrayList<? extends Comparable<?>> list){

    }
    public static int[][] dirent = new int[][]{
            {0,-1},{1,0},{0,1},{-1,0}
    };
    public static void main(String[] args) throws IOException {

        Heap<String> heap = new Heap<>(new String[]{"123","456"});
        System.out.println(heap.toString());

    }

}

class Heap<E extends Comparable<E>>{

    private E[] arr;

    Heap(E[] arr){
        this.arr = arr;
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }

    public static <T extends Comparable<T>> int func(T element){


        return 1;
    }
}