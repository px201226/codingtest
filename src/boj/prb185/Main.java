package boj.prb185;

/*
https://www.acmicpc.net/problem/1764
듣도잡
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.add(4);
        queue.add(5);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Integer[] a = {1,2,3,4};
        Number[] b = a;
        b[0] = 3.14;
    }


}

class MyQueue<E>{
    Stack<E> in = new Stack<>();
    Stack<E> out = new Stack<>();

    public void add(E element){
        in.push(element);
    }

    public E poll(){
        if(out.isEmpty() && in.isEmpty())
            throw new RuntimeException();

        if(!out.isEmpty()) {
            return out.pop();
        }else{
            while (!in.isEmpty())
                out.push(in.pop());
            return out.pop();
        }

    }
}

class MyStack<E> {
    Queue<E> queue1 = new LinkedList<>();
    Queue<E> queue2 = new LinkedList<>();

    public void push(E element){
        if(queue1.isEmpty())
            queue2.add(element);
        else queue1.add(element);
    }

    public E pop(){
        if(queue1.isEmpty() && queue2.isEmpty())
            throw new EmptyStackException();

        if(!queue1.isEmpty()){

            for(int size = queue1.size(); size > 1; size--)
                queue2.add(queue1.poll());
            return queue1.poll();

        }else{
            for(int size = queue2.size(); size > 1; size--)
                queue1.add(queue2.poll());
            return queue2.poll();
        }
    }
}