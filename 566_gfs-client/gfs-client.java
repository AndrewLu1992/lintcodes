/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/gfs-client
@Language: Java
@Datetime: 16-09-06 04:20
*/

/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */
 
public class GFSClient extends BaseGFSClient {
    
    private int chunkSize;
    private HashMap<String, List<Integer>> nameToIndices;

    public GFSClient(int chunkSize) {
        // initialize your data structure here
        this.chunkSize = chunkSize;
        nameToIndices = new HashMap<String, List<Integer>>();
    }
    
    // @param filename a file name
    // @return conetent of the file given from GFS
    public String read(String filename) {
        // Write your code here
        if (!nameToIndices.containsKey(filename)) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        for (Integer index : nameToIndices.get(filename)) {
            res.append(readChunk(filename, index));
        }
        return res.toString();
    }

    // @param filename a file name
    // @param content a string
    // @return void
    public void write(String filename, String content) {
        // Write your code here
        //Whenever write to an new or existing file, overwrite the
        //previous one.
        nameToIndices.put(filename, new ArrayList<Integer>());
        
        for (int i = 0; i < content.length(); i += chunkSize) {
            int end = i + chunkSize < content.length() ? 
                i + chunkSize : content.length();
            String s = content.substring(i, end);
            nameToIndices.get(filename).add(i);
            writeChunk(filename, i, s);
        }
    }
}