package boj.prb64;

/*
라인 코니 블라운
 * */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int co = sc.nextInt();
        int br = sc.nextInt();

        System.out.println(solve(co,br));


    }

    public static int solve(int conyPosition, int brownPosition) {
        int time = 0;
        boolean[][] visit = new boolean[200001][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{brownPosition, 0});

        while (true) {
            conyPosition += time;
            System.out.println(conyPosition);
            if (conyPosition > 200000)
                return -1;
            if (visit[conyPosition][time % 2])
                return time;

            for (int i = 0, size = queue.size(); i < size; i++) {
                int currentPosition = (queue.peek())[0];
                int newTime = ((queue.peek())[1] + 1) % 2;
                int newPosition;

                queue.poll();

                newPosition = currentPosition - 1;
                if (newPosition >= 0 && !visit[newPosition][newTime]) {
                    visit[newPosition][newTime] = true;
                    queue.add(new int[]{newPosition, newTime});
                }

                newPosition = currentPosition + 1;
                if (newPosition < 200001 && !visit[newPosition][newTime]) {
                    visit[newPosition][newTime] = true;
                    queue.add(new int[]{newPosition, newTime});
                }

                newPosition = currentPosition * 2;
                if (newPosition < 200001 && !visit[newPosition][newTime]) {
                    visit[newPosition][newTime] = true;
                    queue.add(new int[]{newPosition, newTime});
                }
            }
            time++;
        }
    }
}