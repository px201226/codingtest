package boj.prb81;

/*
https://www.acmicpc.net/problem/1244
스위치
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] switcs = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (st.nextToken().equals("1"))
                switcs[i] = true;
        }

        int K = Integer.parseInt(br.readLine());
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")){
                man(switcs,Integer.parseInt(st.nextToken()));
            }else{
                woman(switcs,Integer.parseInt(st.nextToken())-1,0);
            }
        }
        int i=0;
        for(boolean bool : switcs){
            if(i%20 ==0 && i!=0) System.out.println("");
            if(bool) System.out.print("1 ");
            else System.out.print("0 ");
            i++;
        }
    }

    public static void man(boolean[] swichs, int x){
        for(int i=x; i<=swichs.length; i+=x)
            swichs[i-1] = !swichs[i-1];
    }

    public static void woman(boolean[] switchs, int x, int len){
        if(x-len < 0 || x+len >= switchs.length) return;
        boolean left = switchs[x-len];
        boolean right= switchs[x+len];
        if(left == right) {
            switchs[x-len] = switchs[x+len] = !switchs[x+len];
            woman(switchs,x,len+1);
        }
    }
}



