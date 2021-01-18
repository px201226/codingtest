package s2.s2;

import java.util.*;
import java.util.stream.Collectors;


public class main {
    public static final List<PlaysOfGenres> totalList2 =
            Arrays.asList(
                    new PlaysOfGenres("발라드",100,0),
                    new PlaysOfGenres("힙합",100,1),
                    new PlaysOfGenres("발라드",10,2),
                    new PlaysOfGenres("힙합",50,3),
                    new PlaysOfGenres("댄스",200,4),
                    new PlaysOfGenres("댄스",200,5)

            );

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

class PlaysOfGenres  {
    public String genres;
    public int plays;
    public int index;

    public PlaysOfGenres(String genres, int plays, int index) {
        this.genres = genres;
        this.plays = plays;
        this.index = index;
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]", plays, index);
    }
}


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<PlaysOfGenres> list = new ArrayList<>();
        for(int i=0; i<genres.length; i++){
            list.add( new PlaysOfGenres(genres[i],plays[i],i));
        }

        Map<Integer,List<PlaysOfGenres>> totalPlaysOfGenresAndPlayList = list.stream()
               .collect(Collectors.groupingBy( a -> a.genres ))         // 장르별 이름으로 그륩핑하고
               .entrySet().stream().collect(                            // 그륩핑된 개별 엔트리에 대해서
                    Collectors.toMap(
                        x -> x.getValue().stream().mapToInt( a -> a.plays ).sum()   // Map의 키는 plays들의 합
                        , x -> x.getValue().stream()                                // value는 내림차순된 plays 객체들
                                    .sorted( ((o1, o2) -> o2.plays - o1.plays))
                                    .collect(Collectors.toList())
                        , (o1, o2) -> o1                                                // key가 같은 경우, 모든 장르마다 재생 수가 다르기 때문에 상관x
                        , () ->{ return new TreeMap<>(Collections.reverseOrder());} )   // 만들어진 스트림을 내림차순 TreeMap으로 반환
               );

        int[] answer  = totalPlaysOfGenresAndPlayList.values().stream()
                .map((o) -> o.stream().limit(2).mapToInt((x) -> x.index).toArray())
                .collect(Collectors.toList())
                .stream()
                .flatMapToInt(Arrays::stream)
                .toArray();

        //System.out.println(totalPlaysOfGenresAndPlayList);
        //System.out.println(Arrays.toString(answer));
        return answer;
    }

}
