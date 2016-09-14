/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/largest-number
@Language: Java
@Datetime: 16-08-19 21:09
*/

public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
     
    //Point: Design a comparator that satisfies needs.
    //Attention: Pass String to the interface generics.
    private class NumberComparator implements Comparator<String> {
        public int compare(String num1, String num2) {
            return (num2 + num1).compareTo(num1 + num2);
        }
    }
    //O(nlogn). Sort.
    public String largestNumber(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return "0";
        }
        
        String[] numbers = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            numbers[i] = Integer.toString(num[i]);
        }
        
        //Sort string array using custermized comparator.
        Arrays.sort(numbers, new NumberComparator());
        //Use stringbuilder instead of + operand.
        //+ gives N objects. Not efficient.
        StringBuilder str = new StringBuilder();
        for (String number : numbers) {
            str.append(number);
        }
        String res = str.toString();
        
        //Remove 0s.
        int index = 0;
        while (index < res.length() && res.charAt(index) == '0') {
            index++;
        }
        //If all characters are 0s. Return 0 instead of "".
        if (index == res.length()) {
            return "0";
        }
        return res.substring(index);
    }
}