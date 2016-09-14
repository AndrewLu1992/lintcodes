/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/tiny-url-ii
@Language: Java
@Datetime: 16-09-06 22:16
*/

public class TinyUrl2 {
    private HashMap<Long, String> id2url = new HashMap<>();
    private HashMap<String, Long> url2id = new HashMap<>();
    
    private HashMap<String, String> custom_ltos = new HashMap<>();
    private HashMap<String, String> custom_stol = new HashMap<>();
    
    public static long GLOBAL_ID = 1000;
    public static String TINY_URL = "http://tiny.url/";
    public static String CANDIDATES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    private int toBase62(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }
    
    private long shortKeytoId(String key) {
        long id = 0;
        for (int i = 0; i < key.length(); i++) {
            id = id * 62 + toBase62(key.charAt(i));
        }
        return id;
    }
    
    private String idToShortKey(long id) {
        StringBuilder sb = new StringBuilder(6);
        while (id > 0) {
            sb.insert(0, CANDIDATES.charAt((int)id % 62));
            id = id / 62L;
        }
        while (sb.length() < 6) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
    
    private boolean isNormalShortKey(String key) {
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (toBase62(c) == -1) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * @param long_url a long url
     * @param a short key
     * @return a short url starts with http://tiny.url/
     */
    String createCustom(String long_url, String short_key) {
        // Write your code here
        if (isNormalShortKey(short_key)) {
            long id = shortKeytoId(short_key);
            if (id2url.containsKey(id)) {
                if (!long_url.equals(id2url.get(id))) {
                    return "error";
                } 
            }
            if (url2id.containsKey(long_url)) {
                if (id != url2id.get(long_url)) {
                    return "error";
                } 
            }
            if (id2url.containsKey(id) || url2id.containsKey(long_url)) {
                return TINY_URL + short_key;
            }
        }
        
        if (custom_ltos.containsKey(long_url) && !custom_ltos.get(long_url).equals(short_key)) {
            return "error";
        }
        if (custom_stol.containsKey(short_key) && !custom_stol.get(short_key).equals(long_url)) {
            return "error";
        }
        custom_ltos.put(long_url, short_key);
        custom_stol.put(short_key, long_url);
        return TINY_URL + short_key;
    }

    /**
     * @param long_url a long url
     * @return a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        // Write your code here
        if (custom_ltos.containsKey(long_url)) {
            return TINY_URL + custom_ltos.get(long_url);
        }
        if (url2id.containsKey(long_url)) {
            return TINY_URL + idToShortKey(url2id.get(long_url));
        }
        url2id.put(long_url, GLOBAL_ID);
        id2url.put(GLOBAL_ID, long_url);
        GLOBAL_ID += 1;
        return TINY_URL + idToShortKey(url2id.get(long_url));
    }

    /**
     * @param short_url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String short_url) {
        // Write your code here
        short_url = short_url.substring(TINY_URL.length());
        if (custom_stol.containsKey(short_url)) {
            return custom_stol.get(short_url);
        }
        long id = shortKeytoId(short_url);
        return id2url.get(id);
    }
}