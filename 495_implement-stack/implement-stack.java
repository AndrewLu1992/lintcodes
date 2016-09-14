/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/implement-stack
@Language: Java
@Datetime: 16-06-28 09:20
*/

class Stack {
    private LinkedList<Integer> list;
    // Push a new item into the stack
    public Stack() {
        list = new LinkedList<Integer>();
    }
    public void push(int x) {
        // Write your code here
        list.add(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        list.remove(list.size() - 1);
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        return list.get(list.size() - 1);
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return list.isEmpty();
    }    
}