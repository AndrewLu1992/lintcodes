/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-in-a-big-sorted-array
@Language: Java
@Datetime: 16-05-16 06:20
*/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int index = 1;
        while (reader.get(index - 1) < target && reader.get(index - 1) != -1){
            index *= 2;
        }
        int start = 0, end = index - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target && reader.get(mid) != -1){
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (reader.get(start) == target){
            return start;
        }
        else if (reader.get(end) == target){
            return end;
        }
        else{
            return -1;
        }
        
    }
}