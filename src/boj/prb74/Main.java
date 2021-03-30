package boj.prb74;

/*
https://www.acmicpc.net/problem/2941
구현, 크로아티아 알파벳
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static List list = new ArrayList<String>(Arrays.asList("c=","c-","dz=","d-","lj","nj","s=","z="));
    public static Set<String> set = new HashSet<String >(){
        {
            addAll(list);
        }
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int i=0;
        int answer=0;
        while(i<s.length()){

            boolean isFind = false;
            for(int len=3; len >=2; len--){
                if(i+len > s.length()) continue;
                String substring = s.substring(i, i + len);
                if(set.contains(substring)){
                    answer++;
                    i += len;
                    isFind = true;
                    break;
                }
            }
            if(isFind) continue;
            answer++;
            i++;
        }
        System.out.println(answer);
    }

}



