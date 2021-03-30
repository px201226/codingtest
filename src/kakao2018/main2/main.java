package kakao2018.main2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        String[] time1 = {"08:00", "08:01", "08:02", "08:03"};
        String[] time2 = {"09:10", "09:09", "08:00"};
        String[] time3 = {"09:00", "09:00", "09:00", "09:00"};
        String[] time4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        String[] time5 = {"23:59"};
        String[] time6 = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
        Solution solution = new Solution();
        solution.solution(1,1,5,time1);
        solution.solution(2,10,2,time2);
        solution.solution(2,1,2,time3);
        solution.solution(1,1,5,time4);
        solution.solution(1,1,1,time5);
        solution.solution(10,60,45,time6);
    }
}

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        ArrayList<Integer> timeList = new ArrayList<>();
        for(String time : timetable){
            String[] sliceTime = time.split(":");
            int minuteTime = Integer.parseInt(sliceTime[0]) * 60 + Integer.parseInt(sliceTime[1]);
            timeList.add(minuteTime);
        }

        Collections.sort(timeList);

        int arriveTime = 540;
        for(int i=0; i<n; i++){
            int count = 0;
            int lastTime = 0;
            Iterator<Integer> iterator = timeList.iterator();
            while (iterator.hasNext()){
                int time = iterator.next();
                if(time <= arriveTime && count < m){
                    count++;
                    lastTime = time;
                    iterator.remove();
                }else{
                    break;
                }
            }

            if(i == n-1){
                if(count < m)
                    answer = String.format("%02d",  arriveTime / 60) + ":" +String.format("%02d",  arriveTime % 60);
                else{
                    answer = String.format("%02d",(lastTime-1) / 60) + ":" + String.format("%02d",(lastTime-1) % 60);
                }
            }
            arriveTime+= t;
        }
        System.out.println(answer);
        return answer;
    }
}