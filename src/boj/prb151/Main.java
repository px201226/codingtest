package boj.prb151;

/*
https://www.acmicpc.net/problem/10828
스택
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();

        for (int i = 0; i < N; i++) {
            try {
                String cmd = br.readLine();
                String[] s = cmd.split(" ");
                if (s[0].equals("push")) {
                    stack.push(Integer.parseInt(s[1]));
                } else if (s[0].equals("pop")) {
                    System.out.println(stack.pop());
                } else if (s[0].equals("size")) {
                    System.out.println(stack.size());
                } else if (s[0].equals("empty")) {
                    System.out.println(stack.empty());
                } else {
                    System.out.println(stack.top());
                }
            } catch (Exception e) {
                System.out.println("-1");
            }
        }


    }

}

class MyStack {
    private List<Integer> arr = new ArrayList<>();

    public void push(int num) {
        arr.add(num);
    }

    public int pop() {
        if (arr.size() == 0) throw new RuntimeException();
        return arr.remove(arr.size() - 1);
    }

    public int top() {
        if (arr.size() == 0) throw new RuntimeException();
        return arr.get(arr.size() - 1);
    }

    public int size() {
        return arr.size();
    }

    public int empty() {
        return arr.size() == 0 ? 1 : 0;
    }
}