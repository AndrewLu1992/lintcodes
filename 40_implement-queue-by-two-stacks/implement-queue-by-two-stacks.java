/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/implement-queue-by-two-stacks
@Language: Java
@Datetime: 16-06-25 15:14
*/

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    private void stackChange(Stack s1, Stack s2) {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
    }
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if (stack2.empty()) {
            stackChange(stack1, stack2);
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if (stack2.empty()) {
            stackChange(stack1, stack2);
        }
        return stack2.peek();
    }
}