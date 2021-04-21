package boj.prb163;

/*
https://www.acmicpc.net/problem/4889
안정된 문자열
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder("");
        int number = 1;
        while (true){
            String str = br.readLine();
            if(str.contains("-")){
                System.out.println(builder);
                return;
            }

            LinkedList<Character> list = new LinkedList<>();
            for(char c : str.toCharArray()){
                if(c == '{')
                    list.addLast('{');
                else if(c== '}'){
                    if(list.size() != 0 && list.getLast() == '{')
                        list.removeLast();
                    else
                        list.addLast('}');
                }
            }
            Iterator<Character> iterator = list.iterator();
            int idx = 0, answer = 0;
            while (iterator.hasNext()){
                Character next = iterator.next();
                if(idx % 2 == 0){
                    answer += next == '{' ? 0 : 1;
                }else{
                    answer += next == '}' ? 0 : 1;
                }
                idx++;
            }
            builder.append(number +". " + answer + "\n");
            number++;
        }

    }
}