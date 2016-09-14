/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/implement-stack-by-two-queues
@Language: Java
@Datetime: 16-06-25 15:40
*/

class Stack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public Stack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    private void move() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
    }
    
    private void swap() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        queue1.offer(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        move();
        queue1.poll();
        swap();
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        move();
        int ans = queue1.poll();
        queue2.offer(ans);
        swap();
        return ans;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return queue1.isEmpty();
    }    
}