package boj.prb61;

/*
https://www.acmicpc.net/problem/1700
그리디 알고리즘
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> tabs = new LinkedList<>();
        LinkedList<Integer> waits = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            int item = Integer.parseInt(st.nextToken());
            waits.add(item);
        }

        int answer = 0;
        while (!waits.isEmpty()) {
            int waitItem = waits.get(0);

            //꼽을 아이템이 이미 꼽혀져 있으면
            if (tabs.contains(waitItem)) {
                waits.remove(0);
                System.out.println(waitItem);
                continue;
            }

            //빈 곳이 있을 경우
            if (tabs.size() < N) {
                tabs.offer(waits.remove(0));
                continue;
            }


            int predictNextIndex = -1;
            int removeTabsIndex = 0;

            //제일 마지막에 쓰이는거 구하기
            for (int i = 0; i < tabs.size(); i++) {
                int findIdx = waits.indexOf(tabs.get(i));
                if (findIdx > predictNextIndex) {
                    predictNextIndex = findIdx;
                    removeTabsIndex = i;
                } else if (findIdx == -1) {
                    removeTabsIndex = i;
                    break;
                }
            }

            tabs.remove(removeTabsIndex);
            tabs.offer(waits.remove(0));
            answer++;
        }
        System.out.println(answer);
    }

}

