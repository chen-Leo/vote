package com.example.demo.util;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentUtils {
    private static Pattern NUMBER_PATTERN = Pattern.compile("studentId=\\S+?;");
    private static Pattern NUMBER_PATTERN2 = Pattern.compile("collegeName=\\S+?;");

    public static String[] contentFind(String content) throws Exception {
        String[] result = new String[2];
        Matcher m = NUMBER_PATTERN.matcher(content);
        if(m.find()){
            result[0] = m.group().substring(m.group().indexOf('='),m.group().indexOf(';'));
        }
         m = NUMBER_PATTERN2.matcher(content);
        if(m.find()){
            result[1] = m.group().substring(m.group().indexOf('='),m.group().indexOf(';'));
        }
        return  result;
    }
}
