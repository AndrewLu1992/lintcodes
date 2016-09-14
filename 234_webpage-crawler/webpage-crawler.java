/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/webpage-crawler
@Language: Java
@Datetime: 16-09-06 00:06
*/

/**
 * public class HtmlHelper {
 *     public static List<String> parseUrls(String url);
 *         // Get all urls from a webpage of given url. 
 * }
*/
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Thread;
import java.net.*;
import java.io.*;

class CrawlerThread extends Thread {
    private static BlockingQueue<String> queue = 
        new LinkedBlockingQueue<String>();
    private static HashSet<String> set = new HashSet<>();
    private static List<String> result = new ArrayList<String>();
    
    public static void setFirstUrl(String url) {
        try {
            queue.put(url);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static List<String> getResult() {
        return result;
    }
    
    @Override
    public void run() {
        while (true) {
            String url = "";
            try {
                url = queue.take();
            } catch (Exception e) {
                //e.printStackTrace();
                break;
            }
            
            if (!set.contains(url) && url.contains("wikipedia")) {
                set.add(url);
                result.add(url);
                List<String> urls = HtmlHelper.parseUrls(url);
                for (String u : urls) {
                    try {
                        queue.put(u);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class Solution {
    /**
     * @param url a url of root page
     * @return all urls
     */
    public List<String> crawler(String url) {
        // Write your code here
        CrawlerThread.setFirstUrl(url);
        CrawlerThread[] thread_pools = new CrawlerThread[7];
        
        for (int i = 0; i < thread_pools.length; i++) {
            thread_pools[i] = new CrawlerThread();
            thread_pools[i].start();
        }
        
        try {
            Thread.sleep(800);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (Thread t : thread_pools) {
            t.stop();
        }
        
        return CrawlerThread.getResult();
    }
}