package total;

public class main2 {
}

class SolutionA {
    public int solution(String s) {
        int answer = s.length();
        StringBuilder result = new StringBuilder();

        for(int slice=1; slice<=s.length() / 2; slice++){
            String prefix = s.substring(0, slice);
            int frequency = 1;

            for(int j=slice; j<s.length(); j+=slice){

                String nextPrefix = s.substring(j, j+slice>s.length() ? s.length() : j+slice );
                if(prefix.equals(nextPrefix)){
                    frequency++;
                    continue;
                }

                if(frequency != 1)
                    result.append(frequency);
                result.append(prefix);
                prefix = nextPrefix;
                frequency = 1;
            }

            if(frequency != 1)
                result.append(frequency);
            result.append(prefix);
            answer = Math.min(result.length(),answer);
            result.delete(0,result.length());

        }
        return answer;
    }
}