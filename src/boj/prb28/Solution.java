package boj.prb28;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/72413
  Floyd 알고리즘을 이용해 A,B 탑승자의 K 지점을 구해
  * cost(s,k) + cost(k,a) + cost(k,b)가 최소가 되는 점을 구한다.
 * */


class Solution {

    public static void main(String[] args) {

        String play_time = "99:59:59";
        String adv_time = "25:00:00";
        String[] logs = new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        Solution solution = new Solution();
        System.out.println(solution.solution(play_time,adv_time,logs));
    }
    public String solution(String play_time, String adv_time, String[] logs) {

        int[] cache = new int[timeToSec(play_time)+1];
        int[] sum = new int[timeToSec(play_time)+2];

        for(String log : logs){
            String[] times = log.split("-");
            int start = timeToSec(times[0]);
            int end = timeToSec(times[1]);
            for(int i=start; i<=end; i++)
                cache[i]++;
        }

        int i = 0;
        int temp =0;
        sum[i++] = temp;
        for(int num : cache) {
            temp += num;
            sum[i++] = temp;
        }

        int maxbegin = 0;
        long max = 0L;
        int advSize = timeToSec(adv_time);

        for(int begin = 1; begin < cache.length - advSize; begin++){
          //  System.out.printf("%d-%d=%d\n",begin,begin+advSize,prefixSum(sum,begin,begin+advSize));
            if(max < prefixSum(sum,begin,begin+advSize)){
                max =  prefixSum(sum,begin,begin+advSize);
                maxbegin = begin;
            }
        }

        maxbegin = maxbegin == 0 ? 0 : maxbegin-1;

        return  String.format("%02d:%02d:%02d",maxbegin / 60 / 60, maxbegin / 60 % 60,maxbegin % 60);
    }

    private int timeToSec(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        int sec = Integer.parseInt(time.substring(6,8));

        return hour * 3600 + min * 60 + sec;
    }

    private long prefixSum(int[] sum, int start, int end){
        return sum[end] - sum[start-1];
    }
}