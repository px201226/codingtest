package leetcode.prb001;
/*
https://leetcode.com/problems/two-sum/submissions/
* */

import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) map.put(nums[i],i);

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }
}