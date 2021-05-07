package boj.prb183;

/*
https://www.acmicpc.net/problem/14425
문자열 집합
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {


        int[] list = new int[]{7, 3, 1, 2, 9, 2, 0, 1, 3, 4, 8, 2, 3};
        Sorter sorter = new Sorter();
        sorter.bubbleSort(list);
        System.out.println(Arrays.toString(list));

        list = new int[]{7, 3, 1, 2, 9, 2, 0, 1, 3, 4, 8, 2, 3};
        sorter.selectionSort(list);
        System.out.println(Arrays.toString(list));


        list = new int[]{7, 3, 1, 2, 9, 2, 0, 1, 3, 4, 8, 2, 3};
        sorter.insertionSort(list);
        System.out.println(Arrays.toString(list));

        list = new int[]{7, 3, 1, 2, 9, 2, 0, 1, 3, 4, 8, 2, 3};
        sorter.mergeSort(list,0,list.length-1);
        System.out.println("합병정렬");
        System.out.println(Arrays.toString(list));

        list = new int[]{7, 3, 1, 2, 9, 2, 0, 1, 3, 4, 8, 2, 3};
        sorter.quickSort(list,0,list.length-1);
        System.out.println("퀵정렬");
        System.out.println(Arrays.toString(list));
    }
}

class Sorter {


    /* (pass >=2 ) = (pass>0)
     * 안정성
     * 장점 : swap 플래그를 사용하면 입력 목록이 이미 정렬되어 있는지 탐지할 수 있음*/
    public void bubbleSort(int[] list) {
        System.out.println("버블정렬");
        for (int pass = list.length; pass > 0; pass--) {
            for (int i = 0; i < pass - 1; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }

        }
    }

    /* 장점 : 구현이 쉽다, 제자리 정렬
     *  단점 : 데이터 양에 우연하지 않음 */
    public void selectionSort(int[] list) {
        System.out.println("선택정렬");
        for (int i = 0; i < list.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[min] > list[j])
                    min = j;
            }
            int temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
    }

    /* 이미 정렬된 상태면 O(n)
     * 안정정렬 */
    public void insertionSort(int[] list) {
        System.out.println("삽입정렬");
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;
            for (; j >= 0 && list[j] > key; j--)
                list[j + 1] = list[j];
            list[j + 1] = key;
        }
    }

    /* 이미 정렬된 리스트면 O(n)
     *  안정적인 정렬 방법
     *  연결리스트로 구성하면 데이터 이동은 무시할 수 있을 정도로 작아짐 (제자리 정렬로 구현가능)
     *  단점 : 제자리 정렬이 아님*/
    public void mergeSort(int[] list, int left, int right) {
        if (right > left) {
            int mid = (right + left) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(int[] list, int left, int mid, int right) {
        int i = left, j = mid + 1, pos = i;
        int[] temp = new int[list.length];

        while (i <= mid && j <= right) {
            if (list[i] < list[j])
                temp[pos++] = list[i++];
            else
                temp[pos++] = list[j++];
        }
        while (i <= mid)
            temp[pos++] = list[i++];
        while (j <= right)
            temp[pos++] = list[j++];

        for(int k=left; k<=right; k++){
            list[k] = temp[k];
        }
    }

    public void quickSort(int[] list, int left, int right){
        if(right > left){
            int pivot = partition(list,left,right);
            quickSort(list,left,pivot-1);
            quickSort(list,pivot,right);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low <= high) {
            while (arr[low] < pivot) low++;
            while (arr[high] > pivot) high--;
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
        return low;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}