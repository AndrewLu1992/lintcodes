/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/stack-sorting
@Language: Java
@Datetime: 16-08-02 02:29
*/

public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        if (stack == null || stack.size() < 2) {
            return;
        }
        Stack<Integer> tmp = new Stack<>();
        
        while (!stack.empty()) {
            if (!stack.empty() && (tmp.empty() || 
                tmp.peek() >= stack.peek())) {
                tmp.push(stack.pop());
            } else {
                int value = stack.pop();
                while (!tmp.empty() && tmp.peek() <= value) {
                    stack.push(tmp.pop());
                }
                stack.push(value);
                while (!tmp.empty()) {
                    stack.push(tmp.pop());
                }
            }
        }
        
        while (!tmp.empty()) {
            stack.push(tmp.pop());
        }
    }
}