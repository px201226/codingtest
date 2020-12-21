package kakao2019.main5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {


    public static void main(String[] args) {

        int[][] info = new int[][]
                {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        Solution solution = new Solution();
        solution.solution(info);
    }

}


class Solution {

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];

        int[][] sortNodeinfo = new int[nodeinfo.length][3];
        for(int i=0; i<nodeinfo.length; i++){
            sortNodeinfo[i][0] = nodeinfo[i][0];
            sortNodeinfo[i][1] = nodeinfo[i][1];
            sortNodeinfo[i][2] = i;
        }

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Arrays.sort(sortNodeinfo, ((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : -(o1[1] - o2[1])));
        Node root = null;
        for (int i = 0; i < sortNodeinfo.length; i++) {
            root = insert(root, sortNodeinfo[i][0], sortNodeinfo[i][1], sortNodeinfo[i][2]);
        }

        preOrder(root, pre);
        postOrder(root, post);

        answer[0] = pre.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = post.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public Node insert(Node root, int x, int y, int index) {
        if (root == null) {
            return new Node(x, y, index);
        }

        Node cur;
        if (x <= root.x) {
            cur = insert(root.left, x, y, index);
            root.left = cur;
        } else {
            cur = insert(root.right, x, y, index);
            root.right = cur;
        }
        return root;
    }

    public void preOrder(Node root, List<Integer> seq){
        if(root!=null){
            seq.add(root.index + 1);
            preOrder(root.left, seq);
            preOrder(root.right,seq);
        }
    }
    public void postOrder(Node root, List<Integer> seq){
        if(root!=null){
            postOrder(root.left, seq);
            postOrder(root.right,seq);
            seq.add(root.index + 1);
        }
    }


}

class Node {
    int x, y, index;
    Node left, right;

    public Node(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}