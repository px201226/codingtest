package boj.prb67;

/*
https://www.acmicpc.net/problem/16506
CPU
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private final static String[][] map = new String[][]
            {
                    {"###", "#.#", "#.#", "#.#", "###"},
                    {".#.", ".#.", ".#.", ".#.", ".#.",},
                    {"###", "..#", "###", "#..", "###"},
                    {"###", "..#", "###", "..#", "###"},
                    {"#.#", "#.#", "###", "..#", "..#"},
                    {"###", "#..", "###", "..#", "###"},
                    {"###", "#..", "###", "#.#", "###"},
                    {"###", "..#", "..#", "..#", "..#"},
                    {"###", "#.#", "###", "#.#", "###"},
                    {"###", " #.#", "###", "..#", "###"}

            };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String message = br.readLine();

        String[] arr = new String[5];
        int width = message.length() / 5;
        for (int r = 0; r < 5; r++) {
            int start = r * width;
            int end = start + width;
            arr[r] = message.substring(start, end);
        }


        StringBuilder answer = new StringBuilder("");
        int col = 0;
        while (col < width){
            if(arr[0].charAt(col) == '#'){
                String s = checkNumberException1(arr, col);
                answer.append(s);
                if(s.equals("1")) col++;
                else
                    col += 3;
            }else
                col++;
        }
        System.out.println(answer.toString());
    }

    public static String checkNumberException1(String[] arr, int baseX) {

        if(baseX + 3 > arr[0].length())
            return String.valueOf(1);

        for (int num = 0; num < 10; num++) {
            boolean isEqual = true;
            for (int r = 0; r < 5; r++) {
                String split = arr[r].substring(baseX, baseX + 3);
                String number = map[num][r];
                if (!split.equals(number)) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                return String.valueOf(num);
            }
        }
        return String.valueOf(1);
    }
}



