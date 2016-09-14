/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/mini-cassandra
@Language: Java
@Datetime: 16-09-01 18:07
*/

/**
 * Definition of Column:
 * public class Column {
 *     public int key;
 *     public String value;
 *     public Column(int key, String value) {
 *         this.key = key;
 *         this.value = value;
 *    }
 * }
 */
public class MiniCassandra {
    //!!! instead of 2 hashmaps. map raw_key to a hashmap.
    
    private HashMap<String, NavigableMap<Integer, String>> hash; 
    
    public MiniCassandra() {
        // initialize your data structure here.
        hash = new HashMap<String, NavigableMap<Integer, String>>();
    }
    
    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return void
     */
    public void insert(String raw_key, int column_key, String column_value) {
        // Write your code here
        if (!hash.containsKey(raw_key)) {
            hash.put(raw_key, new TreeMap<Integer, String>());
        }
        hash.get(raw_key).put(column_key, column_value);
    }

    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
        // Write your code here
        ArrayList<Column> res = new ArrayList<>();
        if (!hash.containsKey(raw_key)) {
            return res;
        }
        //Attention to the collection hirachy.
        NavigableMap<Integer, String> colToVal = hash.get(raw_key);
        NavigableMap<Integer, String> sub = colToVal.subMap(column_start, true, column_end, true);
        
        for(Map.Entry<Integer, String> pair : sub.entrySet()) {
            res.add(new Column(pair.getKey(), pair.getValue()));
        }
        return res;
    }
}