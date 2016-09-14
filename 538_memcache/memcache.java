/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/memcache
@Language: Java
@Datetime: 16-09-01 16:40
*/

public class Memcache {
    
    private class Resource {
        public int value;
        public int expireTime;
        
        public Resource(int v, int e) {
            value = v;
            expireTime = e;
        }
    }
    
    private HashMap<Integer, Resource> cache;

    public Memcache() {
        // Initialize your data structure here.
        cache = new HashMap<Integer, Resource>();
    }

    public int get(int curtTime, int key) {
        // Write your code here
        if (!cache.containsKey(key)) {
            return Integer.MAX_VALUE;
        }
        Resource res = cache.get(key);
        if (res.expireTime >= curtTime || res.expireTime == -1) {
            return res.value;
        }
        return Integer.MAX_VALUE;
    }

    public void set(int curtTime, int key, int value, int ttl) {
        // Write your code here
        int expire = curtTime + ttl - 1;
        if (ttl == 0) {
            expire = -1;
        }
        cache.put(key, new Resource(value, expire));
    }

    public void delete(int curtTime, int key) {
        // Write your code here
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }
    
    public int incr(int curtTime, int key, int delta) {
        // Write your code here
        if (cache.containsKey(key)) {
            cache.get(key).value += delta;
            return get(curtTime, key);
        }
        return Integer.MAX_VALUE;
    }

    public int decr(int curtTime, int key, int delta) {
        // Write your code here
        if (cache.containsKey(key)) {
            cache.get(key).value -= delta;
            return get(curtTime, key);
        }
        return Integer.MAX_VALUE;
    }
}