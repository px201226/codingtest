package kakao2020intership.main6;

import java.util.ArrayList;
import java.util.Stack;

public class main {

    public static void main(String[] args) {

    }
}


class Solution {

    ArrayList<Integer>[] edges;
    public boolean solution(int n, int[][] paths, int[][] orders) {

        edges = new ArrayList[n];
        int[] beforeVisit = new int[n];
        int[] stopCause = new int[n];
        boolean[] isVisit = new boolean[n];

        for(int i=0; i<edges.length; i++){
            edges[i] = new ArrayList<>();
        }

        for(int[] path : paths){
            edges[path[0]].add(path[1]);
            edges[path[1]].add(path[0]);
        }

        for(int[] order : orders) beforeVisit[order[1]] = order[0];

        if(beforeVisit[0] != 0) return false;

        isVisit[0] = true;
        for(int v : edges[0]) DFS(v,isVisit,beforeVisit,stopCause);

        for(boolean is : isVisit) if(!is) return false;


        return true;
    }

    public void DFS(int x, boolean[] isVisit, int[] beforeVisit, int[] stopCause){
        Stack<Integer> stack = new Stack<>();
        stack.add(x);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (isVisit[u]) continue;
            if (!isVisit[beforeVisit[u]]) {
                stopCause[beforeVisit[u]] = u;
                continue;
            }

            isVisit[u] = true;
            stack.add(stopCause[u]);
            for (int v : edges[u]) {
                stack.add(v);
            }
        }
    }
}