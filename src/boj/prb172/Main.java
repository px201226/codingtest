package boj.prb172;

/*
https://www.acmicpc.net/problem/4949
균형잡힌 세상
 * */
import java.util.*;
import java.io.*;
public class Main{

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i<N; i++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            for(int j=0; j<str.length(); j++){
                if(!stack.isEmpty() && stack.peek() == str.charAt(j)){
                    stack.pop();
                }else{
                    stack.push(str.charAt(j));
                }

            }
            if(stack.isEmpty()) answer++;
        }

        System.out.print(answer);
    }
}