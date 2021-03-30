package stack1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class main {

    public static void main(String[] args) {

        int ret = new Solution().solution(2,10,new int[]{7,4,5,6});
        System.out.println(ret);
    }
}

class Entity{
    public final int length;
    public final int weight;
    public int time=1;

    Entity(int length, int weight) {
        this.length = length;
        this.weight = weight;
    }

    public int next(){
        return ++time;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int count = 0;
        int availableWeight = weight;

        int nearestEntity = bridge_length;
        Queue<Entity> queue = new LinkedList<>();
        Queue<Entity> waitQueue = new LinkedList<>();

        for(int w : truck_weights){
            waitQueue.add(new Entity(bridge_length, w));
        }

        while (!waitQueue.isEmpty() || !queue.isEmpty()){
            Iterator<Entity> iterator = queue.iterator();
            count ++;
            while(iterator.hasNext()){
                Entity entity = iterator.next();
                int nextTime = entity.next();
                if(nextTime > bridge_length) {
                    availableWeight += entity.weight;
                    iterator.remove();
                }else{
                    nearestEntity = nextTime;
                }
            }
            if(waitQueue.isEmpty()) continue;
            if(nearestEntity == 1) continue;
            Entity entity = waitQueue.peek();
            if(availableWeight < entity.weight) continue;

            queue.add(waitQueue.poll());
            availableWeight -= entity.weight;

        }

        return count;
    }
}

