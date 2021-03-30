package kakao2019winter.main4;

import java.util.Arrays;
import java.util.HashMap;

public class main {

    public static void main(String[] args) {
        long[] room = new long[]{1,3,4,1,3,1};
        Solution solution = new Solution();
        long[] solution1 = solution.solution(10, room);
        System.out.println(Arrays.toString(solution1));
    }
}

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        int idx=0;
        HashMap<Long, Long> roomTable = new HashMap<>();
        for(long number : room_number){
            if(!roomTable.containsKey(number)){
                roomTable.put(number, number+1);
                answer[idx] = number;
            }else{
                long key = find(number, roomTable);
                roomTable.put(key, key+1);
                answer[idx] = key;
            }
            idx++;
        }
        return answer;
    }

    public long find(long x, HashMap<Long, Long> map){
        if(!map.containsKey(x)){
            return x;
        }
        long temp = find(map.get(x), map);
        map.put(x, temp);
        return temp;
    }
}