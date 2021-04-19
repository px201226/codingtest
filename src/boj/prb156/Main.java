package boj.prb156;

/*
https://www.acmicpc.net/problem/5397
키로거
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String str = br.readLine();
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == '<') {
                    if (iterator.hasPrevious())
                        iterator.previous();
                }else if(str.charAt(j) == '>'){
                    if(iterator.hasNext()){
                        iterator.next();
                    }
                }else if(str.charAt(j)=='-'){
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                }else{
                    iterator.add(str.charAt(j));
                }

            }
            StringBuilder ans = new StringBuilder("");
            Iterator<Character> iterator1 = list.iterator();
            while (iterator1.hasNext())
                ans.append(iterator1.next());
            System.out.println(ans);
        }


    }

}