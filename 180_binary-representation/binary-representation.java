/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-representation
@Language: Java
@Datetime: 16-08-14 09:58
*/

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    private String parseInteger(String n) {
        if (n == null || n.equals("") || n.equals("0")) {
            return "0";
        }
        
        int num = Integer.parseInt(n);
        String binary = "";
        
        while (num != 0) {
            //Convert Integer to String
            //Attention: we need to add each bin to the top of string
            //Cannot use binary += ...
            binary = Integer.toString(num % 2) + binary;
            num = num / 2;
        }
        
        return binary;
    }
    
    private String parseFloat(String n) {
        if (n == null || n.equals("") || n.equals("0")) {
            return "0";
        }
        
        double num = Double.parseDouble("0." + n);
        HashSet<Double> decimals = new HashSet<>();
        String binary = "";
        
        while (num > 0) {
            if (binary.length() > 32 || decimals.contains(num)) {
                return "ERROR";
            }
            //Can only be placed here 
            //before changing num value.
            decimals.add(num);
            num *= 2;
            if (num >= 1) {
                binary += "1";
                num -= 1;
            } else {
                binary += "0";
            }
        }
        return binary;
    }
    
    public String binaryRepresentation(String n) {
        // write your code here
        if (n.indexOf(".") == -1) {
            return parseInteger(n);
        }
        
        String[] params = n.split("\\.");
        String decimal = parseFloat(params[1]);
        
        if (decimal.equals("ERROR")) {
            return "ERROR";
        }
        if (decimal.equals("0")) {
            return parseInteger(params[0]);
        }
        
        String intNum = parseInteger(params[0]);
        return intNum + "." + decimal;
    }
}