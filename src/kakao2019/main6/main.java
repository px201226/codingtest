package kakao2019.main6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) {

        String[] pages = new String[]{
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                        "<head>\n" +
                        "  <meta charset=\"utf-8\">\n" +
                        "  <meta property=\"og:url\" content=\"https://a.com\"/>\n" +
                        "</head>  \n" +
                        "<body>\n" +
                        "Blind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n" +
                        "<a href=\"https://b.com\"> Link to b </a>\n" +
                        "</body>\n" +
                        "</html>"
                ,
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                        "<head>\n" +
                        "  <meta charset=\"utf-8\">\n" +
                        "  <meta property=\"og:url\" content=\"https://b.com\"/>\n" +
                        "</head>  \n" +
                        "<body>\n" +
                        "Suspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n" +
                        "<a href=\"https://a.com\"> Link to a </a>\n" +
                        "blind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n" +
                        "<a href=\"https://c.com\"> Link to c </a>\n" +
                        "</body>\n" +
                        "</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                        "<head>\n" +
                        "  <meta charset=\"utf-8\">\n" +
                        "  <meta property=\"og:url\" content=\"https://c.com\"/>\n" +
                        "</head>  \n" +
                        "<body>\n" +
                        "Ut condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n" +
                        "<a href=\"https://a.com\"> Link to a </a>\n" +
                        "</body>\n" +
                        "</html>"
        };
        Solution solution = new Solution();
        solution.solution("blind", pages);
    }
}

class Page{

    public HashSet<String> linkTo = new HashSet<>();
    public HashSet<String> linkFrom = new HashSet<>();
    public int idx;
    public String url;
    public String html;
    public double point = 0;

    public Page(String html,int idx) {
        this.html = html;
        this.idx = idx;
        this.url = getMyUrl();
    }

    private String getMyUrl(){
        Pattern pattern = Pattern.compile("<meta.*content=\"(.*)\"");
        Matcher matcher = pattern.matcher(html);
        while(matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public void getLinkToFrom(HashMap<String, Page> pageMap){
        Pattern pattern = Pattern.compile("<a href=\"(.*)\"");
        Matcher matcher = pattern.matcher(html);
        while(matcher.find()) {
            linkTo.add(matcher.group(1));
            if(pageMap.containsKey(matcher.group(1))) {
                pageMap.get(matcher.group(1)).linkFrom.add(url);
            }
        }
    }

    public void getMatchWord(String html, String word){
        int find = html.indexOf(word);

        while(find != -1) {
            char prev = html.charAt(find-1);
            char next = html.charAt(find + word.length());
            if ((prev < 'a' || prev > 'z') && (next < 'a' || next > 'z')) point++;

            find = html.indexOf(word,find+1);

        }
    }

    //전체 점수
    public double getTotalGrade(HashMap<String,Page> pageHashMap) {

        double sum = point;
        for (String link : linkFrom) {//외부 점수를 구하기 위해 어디로부터 참조되었는지 검사
            if (pageHashMap.containsKey(link)) {//페이지 정보에 존재하는 외부 링크라면
                Page page = pageHashMap.get(link);
                if (page.linkTo.size() > 0) {//해당 페이지의 링크 사이즈를 통해 전체 점수를 구한다.
                    sum += (double) page.point/page.linkTo.size();
                }
            }
        }
        return sum;
    }
}
class Solution {
    public int solution(String word, String[] pages) {

        HashMap<String,Page> pageHashSet = new HashMap<>();
        int idx=0;
        for(String strPage  : pages){
            Page page = new Page(strPage,idx++);
            page.getMatchWord(strPage,word);
            System.out.println(page.point);
            pageHashSet.put(page.url, page);
        }

        for(Page page : pageHashSet.values()){
            page.getLinkToFrom(pageHashSet);
        }

        int answer = 0;
        double max = 0;
        for (Page page : pageHashSet.values()) {
            double total = page.getTotalGrade(pageHashSet);
            if (total > max) {
                max = total;
                answer = page.idx;
            }
        }

        return answer;
    }

}
