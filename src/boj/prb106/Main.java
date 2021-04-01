package boj.prb106;

/*
https://www.acmicpc.net/problem/6603
로또
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static ArrayList<Integer> arr;
    static ArrayList<Integer> order;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String tmp = br.readLine();
            if(tmp.equals("0")) break;
            StringTokenizer st = new StringTokenizer(tmp);
            st.nextToken();
            arr = new ArrayList();
            order = new ArrayList();
            while(st.hasMoreTokens())
                arr.add(Integer.parseInt(st.nextToken()));

            DFS(0,6,0);
            System.out.println("");
        }
    }

    public static void DFS( int k, int N, int next){
        if(k==N){
            for(int i : order)
                System.out.printf("%d ", i);
            System.out.printf("\n");
            return ;
        }

        for(int i=next; i<arr.size(); i++){
            order.add(arr.get(i));
            DFS(k+1,N,i+1);
            order.remove(order.size()-1);
        }
    }
}
