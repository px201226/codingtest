package kakao2018.main1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class main {

    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "aaaaa";
        Solution solution = new Solution();
        System.out.println(solution.solution(str1, str2));
    }
}


class Solution {
    public int solution(String str1, String str2) {

        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();
        ArrayList<String> list1 = new ArrayList<>(1000);
        ArrayList<String> list2 = new ArrayList<>(1000);
        int largeSize = Math.max(arr1.length, arr2.length);
        for(int i = 0; i < largeSize - 1; i++) {
            if(i < arr1.length - 1 && Character.isLetter(arr1[i]) && Character.isLetter(arr1[i+1])) {
                list1.add("" + arr1[i] + arr1[i+1]);
            }
            if(i < arr2.length - 1 && Character.isLetter(arr2[i]) && Character.isLetter(arr2[i+1])) {
                list2.add("" + arr2[i] + arr2[i+1]);
            }
        }

        int intersection = getIntersactionSize(list1,list2);
        int union = getUnionSetSize(list1,list2);
        return (intersection == 0 && union == 0) ? 65536 : (int) ((intersection/ (double) union) * 65536); }

    public int getUnionSetSize(ArrayList<String> set1, ArrayList<String> set2){
        ArrayList<String> biggerSet = (ArrayList) (set1.size() >= set2.size() ? set1 : set2).clone();
        ArrayList<String> smollerSet =  (ArrayList) (set1.size() < set2.size() ? set1 : set2).clone();
        for(int i = 0; i<smollerSet.size(); i++){
            String element = smollerSet.get(i);
            if(biggerSet.contains(element)){
                biggerSet.remove(element);
            }
        }
        return biggerSet.size() + smollerSet.size();
    }

    public int getIntersactionSize(ArrayList<String> set1, ArrayList<String> set2){
        ArrayList<String> biggerSet = (ArrayList) (set1.size() >= set2.size() ? set1 : set2).clone();
        ArrayList<String> smollerSet =  (ArrayList) (set1.size() < set2.size() ? set1 : set2).clone();
        int size = 0;
        for(int i = 0; i<smollerSet.size(); i++){
            String element = smollerSet.get(i);
            if(biggerSet.contains(element)){
                biggerSet.remove(element);
                size++;
            }
        }
        return size;
    }
}

