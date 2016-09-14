/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/url-parser
@Language: Java
@Datetime: 16-09-01 19:49
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HtmlParser {
    /**
     * @param content source code
     * @return a list of links
     */
    private static final String HERF_PATTERN = 
        "\\s*(?i)href\\s*=\\s*\"?'?([^\"'>\\s]*)";
    public List<String> parseUrls(String content) {
        // Write your code here
        List<String> res = new ArrayList<String>();
        Pattern pattern = Pattern.compile(HERF_PATTERN);
        Matcher matcher = pattern.matcher(content);
        
        String url = "";
        while(matcher.find()) {
            url = matcher.group(1);
            if (url.length() == 0 || url.startsWith("#"))
                continue;
            res.add(url);
        }
        return res;
    }
}
