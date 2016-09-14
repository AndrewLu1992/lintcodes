/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/lfu-cache
@Language: Java
@Datetime: 16-08-03 06:49
*/

public class LFUCache {
    
    private class CacheNode {
        final int k;
        int v;
        int frequency;
        
        public CacheNode(int key, int value, int freq) {
            k = key;
            v = value;
            frequency = freq;
        }
    }
    
    private final Map<Integer, CacheNode> cache;
    private final LinkedHashSet[] frequencyList;
    private int lowestFrequency;
    private int maxFrequency;
    private final int maxSize;
    
    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        this.cache = new HashMap<Integer, CacheNode>(capacity);
        this.frequencyList = new LinkedHashSet[capacity * 2];
        this.lowestFrequency = 0;
        this.maxFrequency = capacity * 2 - 1;
        this.maxSize = capacity;
        
        for (int i = 0; i <= maxFrequency; i++) {
            frequencyList[i] = new LinkedHashSet<CacheNode>();
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        CacheNode currentNode = cache.get(key);
        if (currentNode == null) {
            if (cache.size() == maxSize) {
                doEviction();
            }
            LinkedHashSet<CacheNode> nodes = frequencyList[0];
            currentNode = new CacheNode(key, value, 0);
            nodes.add(currentNode);
            cache.put(key, currentNode);
            lowestFrequency = 0;
        } else {
            currentNode.v = value;
        }
        addFrequency(currentNode);
    }

    public int get(int key) {
        // Write your code here
        CacheNode currentNode = cache.get(key);
        if (currentNode != null) {
            addFrequency(currentNode);
            return currentNode.v;
        } else {
            return -1;
        }
    }
    
    private void addFrequency(CacheNode currentNode) {
        int currentFrequency = currentNode.frequency;
        if (currentFrequency < maxFrequency) {
            int nextFrequency = currentFrequency + 1;
            LinkedHashSet<CacheNode> currentNodes = frequencyList[currentFrequency];
            LinkedHashSet<CacheNode> newNodes = frequencyList[nextFrequency];
            moveToNextFrequency(currentNode, nextFrequency, currentNodes, newNodes);
            cache.put(currentNode.k, currentNode);
            if (lowestFrequency == currentFrequency && currentNodes.isEmpty()) {
                lowestFrequency = nextFrequency;
            }
        } else {
            // Hybrid with LRU: put most recently accessed ahead of others:
            LinkedHashSet<CacheNode> nodes = frequencyList[currentFrequency];
            nodes.remove(currentNode);
            nodes.add(currentNode);
        }
    }
    
    private void doEviction() {
        int currentlyDeleted = 0;
        double target = 1; // just one
        while (currentlyDeleted < target) {
            LinkedHashSet<CacheNode> nodes = frequencyList[lowestFrequency];
            if (nodes.isEmpty()) {
                continue;
            } else {
                Iterator<CacheNode> it = nodes.iterator();
                while (it.hasNext() && currentlyDeleted++ < target) {
                    CacheNode node = it.next();
                    it.remove();
                    cache.remove(node.k);
                }
                if (!it.hasNext()) {
                    findNextLowestFrequency();
                }
            }
        }
    }
    
    private void moveToNextFrequency(CacheNode currentNode, int nextFrequency,
                                     LinkedHashSet<CacheNode> currentNodes,
                                     LinkedHashSet<CacheNode> newNodes) {
        currentNodes.remove(currentNode);
        newNodes.add(currentNode);
        currentNode.frequency = nextFrequency;
    }

    private void findNextLowestFrequency() {
        while (lowestFrequency <= maxFrequency && frequencyList[lowestFrequency].isEmpty()) {
            lowestFrequency++;
        }
        if (lowestFrequency > maxFrequency) {
            lowestFrequency = 0;
        }
    }
}