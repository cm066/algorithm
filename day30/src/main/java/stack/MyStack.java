package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cm
 * @create 2022/1/3-9:50 下午
 * 用队列实现栈 ，队列是先进先出，而栈是先进后出
 */
public class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public MyStack() {
    }

    public void push(int x) {
        q1.add(x);
        if (q2.size() == 0){
            q2.add(q1.poll());
        }else {
            while (!q2.isEmpty()){
                q1.add(q2.poll());
            }
            while (!q1.isEmpty()){
                q2.add(q1.poll());
            }
        }
    }

    public int pop() {
        return q2.isEmpty()?-1:q2.poll();
    }

    public int top() {
        if (q2.isEmpty()){
            return -1;
        }
        return q2.peek();
    }

    public boolean empty() {
        return q2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
