package boj.prb72;

/*
https://www.acmicpc.net/problem/14626
구현, ISBN
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();
        int index = isbn.indexOf('*');
        for(int replace=0; replace<10; replace++){
            StringBuilder str = new StringBuilder(isbn);
            str.setCharAt(index, (char) ((char)replace +'0'));
            int sum = 0;
            for(int i=0; i<13; i++){
                if(i%2 ==0){
                    sum += Character.getNumericValue(str.charAt(i));
                }else{
                    sum += Character.getNumericValue(str.charAt(i)) * 3;
                }
            }
            if(sum % 10 == 0) System.out.println(replace);
        }
    }

}



