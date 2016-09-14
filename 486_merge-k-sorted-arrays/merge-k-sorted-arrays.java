/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-arrays
@Language: Java
@Datetime: 16-06-29 02:01
*/

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    private class Element {
        int row, col, value;
        public Element(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
        
        private void setCol(int col) {
            this.col = col;
        }
        
        private void setValue(int val) {
            value = val;
        }
        
        private void setRow(int row) {
            this.row = row;
        }
    }
    
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        if (arrays == null || arrays.length == 0
            || arrays[0] == null || arrays[0].length == 0) {
                return new ArrayList<Integer>();
            }
        Comparator<Element> elemComparator = new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                return e1.value - e2.value;
            }
        };
        Queue<Element> pq = new PriorityQueue<>(arrays.length, elemComparator);
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            size += arrays[i].length;
            Element e = new Element(i, 0, arrays[i][0]);
            pq.offer(e);
        }
        ArrayList<Integer> result = new ArrayList<>(size);
        while (!pq.isEmpty()) {
            Element min = pq.poll();
            result.add(min.value);
            if (min.col + 1 < arrays[min.row].length) {
                min.setCol(min.col + 1);
                min.setValue(arrays[min.row][min.col]);
                pq.offer(min);
            }
        }
        return result;
    }
}