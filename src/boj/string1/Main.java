package boj.string1;

/*
https://www.acmicpc.net/problem/16206
롤케이크
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static int K;
    public static void main(String[] args) throws IOException {
        String msg1 = "Hello";
        String msg2 = "Hello";
        String msg3 = new String("Hello");
        String msg4 = new String("Hello");
        String msg5 = new String("Hello").intern();
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.toString());
        System.out.println(msg1 == msg2); // "Hello" == "Hello”
        System.out.println(msg3 == msg4); // new String("Hello") == new String("Hello")
        System.out.println(msg1 == msg3); // "Hello" == new String("Hello")
        System.out.println(msg1 == msg5); // "Hello" == new String("Hello").intern()


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

}
