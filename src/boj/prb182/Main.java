package boj.prb182;

/*
https://www.acmicpc.net/problem/14425
문자열 집합
 * */

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Set s = new TreeSet<Integer>();
        Set<String> ss = s;            // unchecked warning
        s.add(new Integer(42));        // another unchecked warning
        Iterator<String> iter = ss.iterator();
        while (iter.hasNext())
        {
            String str = iter.next();   // ClassCastException thrown
            System.out.println(str);
        }
        String[] r = (String[]) new Object[3];
        Test<String> test = new Test<>();
        test.getArray();
        test.setArr(0,"1");
        test.setArr(1,"2");
        String[] array = test.getArray();
        System.out.println(Arrays.toString(test.getArray()));;
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for(Object d : list.toArray()){
            String o = (String)d;
            System.out.println(o);
        }

    }

    public static void func(Test test){
        return;
    }
}

class Test<E> {
    private E[] arr = (E[])new Object[3];

    Test(){
        System.out.println("Test Created");
    }

    public void setArr(int idx, E value){
        arr[idx] = value;
    }
    E[] getArray() { return arr; }

}
 class MyStack<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public MyStack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 코드 29-4 배열을 사용한 코드를 제네릭으로 만드는 방법 2 (173쪽)
    // 비검사 경고를 적절히 숨긴다.
    public E pop() {
        if (size == 0)
            throw new RuntimeException();



        return (E) elements[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

}