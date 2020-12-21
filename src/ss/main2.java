package ss;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


class Solution {
    public int soludtion(String[][] clothes) {

        IntStream intList = IntStream.iterate(0, (i) -> i < 100, (i) -> i*2);

        System.out.println(intList.toArray());

        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }

    public static void main(String[] args) {
        String[][] myArgs = new String[][]{ {"123","1"}, {"15","1"}, {"123","1"},{"123","2"},{"123","2"},{"123","3"}};
        Solution solution = new Solution();
        solution.soludtion(myArgs);
        System.out.println(solution.solution(myArgs));
    }

    public int comb(int[] arr){
        int ret = arr[0]+1;

        for(int i=1; i<arr.length; i++){
            ret = ret * (arr[i]+1);
        }
        return ret -1;
    }

    public int solution(String[][] clothes) {
        HashMap<String, Integer> cache = new HashMap<>();

        for(String[] clothe : clothes){
            cache.put(clothe[1], cache.getOrDefault(clothe[1],0) + 1);
        }

        int ret = 1;
        Iterator<Integer> iterator = cache.values().iterator();
        while(iterator.hasNext()){
            ret *= iterator.next().intValue() +1;
        }

        return ret-1;
    }

    public int combination(int[] arr, boolean[] isSelect, int r, int count, int b){

        int ret = 0;
        if(count == r){
            //System.out.println(Arrays.toString(isSelect));
            //System.out.format("r=%d, ret=%d\n",count,calcCombination(arr,isSelect));
            return calcCombination(arr,isSelect);
        }

        for(int i=b; i<arr.length; i++) {
            if(isSelect[i]) continue;
            isSelect[i] = true;
            ret += combination(arr, isSelect, r, count + 1,i);
            isSelect[i] = false;
        }

        return ret;
    }

    public int calcCombination(int[] arr, boolean[] isSelect){
        int ret = 0;

        for(int i=0; i<arr.length; i++){
            if(!isSelect[i]) continue;
            if(ret == 0)
                ret = arr[i];
            else
                ret = ret * arr[i];
        }
        return ret;
    }
}