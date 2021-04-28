package boj.prb175;

/*
https://www.acmicpc.net/problem/1181
단어정렬
 * */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> arrays = new ArrayList<>();

        for(int i=0; i<N; i++){
            arrays.add(br.readLine());
        }

        Collections.sort(arrays, (a,b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for(String word : arrays) set.add(word);
        for(String word : set) System.out.println(word);
    }
}