/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 16-05-09 03:03
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (S == null || S.size() == 0){
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(S);
        search(S, result, list, 0);
        return result;
    }
    
    private void search(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int index){
        
        result.add(new ArrayList<Integer>(list));
        
        for(int i=index; i<nums.size(); i++){
            if (i != index && nums.get(i).equals(nums.get(i-1))){
                continue;
            }
            list.add(nums.get(i));
            search(nums, result, list, i + 1);
            list.remove(list.size()-1);
        }
    }
}
