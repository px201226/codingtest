package boj.prb65;

/*
https://www.acmicpc.net/problem/3568
3568
 * */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().replaceAll("[,;]", "");

        String[] s = str.split(" ");
        String base = s[0];
        String[][] words = new String[s.length-1][2];

        for(int i=1 ; i<s.length; i++){
            int j=0;
            for(; j<s[i].length(); j++){
                if(!Character.isDigit(s[i].charAt(j)) && !Character.isLetter(s[i].charAt(j)))
                    break;
            }
            String name = s[i].substring(0,j);
            String type = s[i].substring(j,s[i].length());
            words[i-1][0] = name;
            words[i-1][1] = type == null ? "" : new StringBuffer(type).reverse().toString().replace("][","[]");
        }

        for(int i=0; i<words.length; i++){
            System.out.println(base + words[i][1] + " " + words[i][0] +";");
        }


    }
}