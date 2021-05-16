package boj.prb188;

/*
문장 반전
This is a Carrer Monk String ->
String Monk Carrer a is This
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Test test1 = new Test();
        System.out.println("main" + System.identityHashCode(test1.value));
        Test test2 = new Test();
        System.out.println("main" + System.identityHashCode(test2.value));
        test1.print();
        test2.print();
        Test test3 = new Test();
        test3.print();
        test1.print();

        int s = 2;
        System.out.println(System.identityHashCode(s));
        s++;
        System.out.println(System.identityHashCode(s));
    }


    public static void reverse(char[] chars, int start, int end){
        for(;start<end; start++,end--){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }
    }
}

class Test{
    public static StringBuilder value = new StringBuilder("");
    Test(){
        value.append("dd");
        System.out.println(System.identityHashCode(value));
    }

    public void print(){
        System.out.println(System.identityHashCode(value));
    }

}