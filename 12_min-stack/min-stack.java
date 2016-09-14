/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/min-stack
@Language: Java
@Datetime: 16-06-23 09:14
*/

public class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        //use isEmpty to detect if it is the first time number
        //added into the minStack
        if (minStack.empty()) {
            minStack.push(number);
        } else {
            //Important must have equal
            //otherwise will cause error. Over poped.
            if (Integer.parseInt(minStack.peek().toString()) >= number) {
                minStack.push(number);
            }
        }
    }

    public int pop() {
        // write your code here
        // must use .equals but not ==.
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
