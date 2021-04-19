package boj.prb155;

/*
https://www.acmicpc.net/problem/1406
에디터
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();
        for(int i=0; i<str.length(); i++) list.addLast(str.charAt(i));

        ListIterator<Character> iterator = list.listIterator(list.size());
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");

            if (cmd[0].equals("P")) {
                iterator.add(cmd[1].charAt(0));
            } else if (cmd[0].equals("L")) {
                if (iterator.hasPrevious()) iterator.previous();
            } else if (cmd[0].equals("D")) {
                if (iterator.hasNext()) iterator.next();
            } else {
                if(iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            }
        }
        StringBuilder ans = new StringBuilder("");
        Iterator<Character> t = list.iterator();
        while (t.hasNext())
            ans.append(t.next());
        System.out.println(ans);
    }

}