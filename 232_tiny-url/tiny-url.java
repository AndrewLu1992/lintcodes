/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/tiny-url
@Language: Java
@Datetime: 16-09-06 18:23
*/

public class TinyUrl {
    /**
     * @param url a long url
     * @return a short url starts with http://tiny.url/
     */
    public static int GLOBAL_ID = 0;
    
    private HashMap<String, Integer> urlToId = new HashMap<>();
    private HashMap<Integer, String> idToUrl = new HashMap<>();
    
    private String getShortKey(String url) {
        return url.substring("http://tiny.url/".length());
    }
    
    //62based mapping
    private int base62(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        return c - 'A' + 36;
    }
    
    private int keyToId(String key) {
        int res = 0;
        for (int i = 0; i < key.length(); i++) {
            //Attention here. It is base62 so we need to multiply 62 each time.
            res = res * 62 + base62(key.charAt(i));
        }
        return res;
    }
    
    private String idToKey(int id) {
        String candidates =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Use StringBuilder instead of '+'.
        StringBuilder sb = new StringBuilder(6);
        while (id > 0) {
            sb.insert(0, candidates.charAt(id % 62));
            id = id / 62;
        }
        while (sb.length() < 6) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
    
    public String longToShort(String url) {
        // Write your code here
        if (urlToId.containsKey(url)) {
            return "http://tiny.url/" + idToKey(urlToId.get(url));
        }
        GLOBAL_ID++;
        urlToId.put(url, GLOBAL_ID);
        idToUrl.put(GLOBAL_ID, url);
        return "http://tiny.url/" + idToKey(GLOBAL_ID);
    }

    /**
     * @param url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String url) {
        // Write your code here
        String key = getShortKey(url);
        int id = keyToId(key);
        return idToUrl.get(id);
    }
}