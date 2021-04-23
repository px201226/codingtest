package boj.prb170;

/*
https://www.acmicpc.net/problem/4949
균형잡힌 세상
 * */
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str.equals(".")) return;

            Stack<Character> stack = new Stack<>();
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '('){
                    stack.push(')');
                }else if (str.charAt(i) == '[') {
                    stack.push(']');
                }
                else if(str.charAt(i) == ']' || str.charAt(i)==')'){
                    if(!stack.isEmpty() && stack.peek() == str.charAt(i)){
                        stack.pop();
                    }else{
                        stack.push('x');
                    }
                }
            }
            System.out.println(stack.isEmpty() ? "yes" : "no");
        }
    }
}
