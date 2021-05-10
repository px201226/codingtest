package boj.prb186;

/*
https://www.acmicpc.net/problem/1764
듣도잡
 * */


import java.io.IOException;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) throws IOException {
        Test<String> test = new Test<>();
        test.setT("dd");
        String t = test.getT();

        Stack1<Integer> stack1 = new Stack1<>();
        Object[] array = stack1.getArray();
        array[0] = "dd";


        stack1.push(1);
        Object pop1 = stack1.pop();
        System.out.println(pop1);

        Stack2 stack2 = new Stack2<Integer>();
        stack2.push(1);
        Object pop = stack2.pop();
        System.out.println(pop);
    }


}

class Test<T>{
    T t;
    T[] array = (T[]) new Object[10];
    public void setT(T v){t=v;}
    public T getT(){return t;}

}

class Stack1<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    public Object[] getArray(){return  elements;}
    public Stack1(){
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0){
            throw new EmptyStackException();
        }

        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}

class Stack2<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    public E getArray(){return (E) elements;}
    public Stack2(){
        elements = new Object [DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0){
            throw new EmptyStackException();
        }

        E result = (E) elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
