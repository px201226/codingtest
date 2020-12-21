package kakao2021.main2;

import java.util.*;

public class main {
    public static void main(String[] args) {
        String[] order = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2,3, 4, 5};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(order, course)));
    }
}

class Menu implements Comparable<Menu> {
    public String id;
    public int count;

    public Menu(String id, int count) {
        this.id = id;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("(%s, %d)", id, count);
    }

    @Override
    public int compareTo(Menu o) {
        return id.length() == o.id.length() ? o.count - count : id.length() - o.id.length();
    }
}

class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answerList = new ArrayList<>();
        ArrayList<Menu> menus = new ArrayList<>();
        for (String order : orders) {
            String sortOrderSeq = getSortedOrder(order);
            addCombination(sortOrderSeq.toString(), new boolean[sortOrderSeq.length()], 0, 0);
        }

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = map.get(key);
            //System.out.println(key + "," + value);
            if (isContainCourse(course, value) == false) {
                iterator.remove();
            } else {
                menus.add(new Menu(key, value));
            }
        }

        Collections.sort(menus);

        int c = -1, maxCount = 0, minLengh = 0;
        for (Menu menu : menus){
            if (minLengh < menu.id.length()) {
                minLengh = menu.id.length();
                maxCount = menu.count;
                c = c >= course.length - 1 ? c : c + 1;
            }
            if (menu.id.length() == minLengh && menu.count == maxCount) {
                answerList.add(menu.id);
            }
        }

        answerList.sort((a, b) -> a.compareTo(b));
        return answerList.toArray(String[]::new);
    }

    private String getSortedOrder(String order) {
        ArrayList<Character> seq = new ArrayList<>();
        for (int i = 0; i < order.length(); i++) seq.add(order.charAt(i));
        seq.sort((a, b) -> a - b);
        StringBuilder answer = new StringBuilder();
        for (char c : seq) answer.append(c);
        return answer.toString();
    }

    private boolean isContainCourse(int[] course, int num) {
        for (int i = 0; i < course.length; i++) {
            if (course[i] == num) return true;
        }
        return false;
    }

    private void addCombination(String order, boolean[] visited, int idx, int start) {
        if (idx > order.length()) {
            return;
        }

        if (idx >= 2) {
            StringBuilder temp = new StringBuilder("");
            for (int i = 0; i < order.length(); i++) {
                if (visited[i]) temp.append(order.charAt(i));
            }
            map.put(temp.toString(), map.getOrDefault(temp.toString(), 0) + 1);
        }

        for (int i = start; i < order.length(); i++) {
            visited[i] = true;
            addCombination(order, visited, idx + 1, i + 1);
            visited[i] = false;
        }
    }

}
