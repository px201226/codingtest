package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("\\bcat\\b");
        Matcher matcher = pattern.matcher("cat catten cat123 cat@cat.com");
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }


}

