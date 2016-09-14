/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/mini-twitter
@Language: Java
@Datetime: 16-08-19 19:16
*/

/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */
public class MiniTwitter {
    
    private class Node {
        public int timeStamp;
        public Tweet tweet;
        
        public Node(int time, Tweet t) {
            this.timeStamp = time;
            this.tweet = t;
        }
        
    }
    
    private class SortByTime implements Comparator {
        public int compare(Object obj1, Object obj2) {
            Node n1 = (Node) obj1;
            Node n2 = (Node) obj2;
            if (n1.timeStamp < n2.timeStamp) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    
    private Map<Integer, List<Node>> users_tweets;
    private Map<Integer, Set<Integer>> friends;
    private int timeStamp;

    public MiniTwitter() {
        // initialize your data structure here.
        this.users_tweets = new HashMap<Integer, List<Node>>();
        this.friends = new HashMap<Integer, Set<Integer>> ();
        this.timeStamp = 0;
    }
    
    private List<Node> getLastTen(List<Node> tmp) {
        int last = 10;
        if (tmp.size() < last) {
            last = tmp.size();
        }
        return tmp.subList(tmp.size() - last, tmp.size());
    }
    
    private List<Node> getFirstTen(List<Node> tmp) {
        int first = 10;
        if (tmp.size() < first) {
            first = tmp.size();
        }
        return tmp.subList(0, first);
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        Tweet t = Tweet.create(user_id, tweet_text);
        timeStamp += 1;
        Node n = new Node(timeStamp, t);
        
        if (users_tweets.containsKey(user_id)) {
            users_tweets.get(user_id).add(n);
        } else {
            users_tweets.put(user_id, new ArrayList<Node>());
            users_tweets.get(user_id).add(n);
        }
        
        return t;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        List<Node> tmp = new ArrayList<>();
        if (users_tweets.containsKey(user_id)) {
            tmp.addAll(getLastTen(users_tweets.get(user_id)));
        }
        //Pull Model
        if (friends.containsKey(user_id)) {
            for (int friend : friends.get(user_id)) {
                if (users_tweets.containsKey(friend)) {
                    tmp.addAll(getLastTen(users_tweets.get(friend)));
                }
            }
        }
        
        Collections.sort(tmp, new SortByTime());
        ArrayList<Tweet> res = new ArrayList<>();
        tmp = getFirstTen(tmp);
        for (Node n : tmp) {
            res.add(n.tweet);
        }
        return res;
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        List<Node> tmp = new ArrayList<>();
        if (users_tweets.containsKey(user_id)) {
            tmp.addAll(getLastTen(users_tweets.get(user_id)));
        }
        
        ArrayList<Tweet> res = new ArrayList<>();
        Collections.sort(tmp, new SortByTime());
        for(Node node : tmp) {
            res.add(node.tweet);
        }
        return res;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!friends.containsKey(from_user_id)) {
           friends.put(from_user_id, new HashSet<Integer>()); 
        }
        friends.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (friends.containsKey(from_user_id)) {
            friends.get(from_user_id).remove(to_user_id);
        }
    }
}