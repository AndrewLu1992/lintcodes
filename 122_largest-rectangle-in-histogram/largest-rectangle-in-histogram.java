/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/largest-rectangle-in-histogram
@Language: Java
@Datetime: 16-06-25 07:36
*/

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int curr = 0;
        for (int i = 0; i <= height.length; i++) {
            if (i == height.length) {
                curr = -1;
            } else {
                curr = height[i];
            }
            while (!stack.empty() && curr <= height[stack.peek()]) {
                int h = height[stack.pop()];
                //This is because for the intger in the bottom of stack
                //It is < All previous intgers and < All post integers.
                //Therefore for this one, the width is i.
                //For other integers in the stack, because of the previous
                // barrier (< both side). The width can only be i - peek - 1.
                int w = stack.empty() ? i : i - stack.peek() - 1;
                if (h * w > max) {
                    max = h * w;
                }
            }
            stack.push(i);
        }
        return max;
    }
}
