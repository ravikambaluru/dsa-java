package org.dsa;

import java.util.ArrayDeque;

public class MyQueue {
    private final ArrayDeque<Integer> stack;
    private final ArrayDeque<Integer> helper;
    public MyQueue() {
        stack = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        fillHelperStack();
        return helper.isEmpty()?-1: helper.pop();
    }

    public int peek() {
        fillHelperStack();
        return helper.isEmpty()? -1:helper.peek();
    }

    public boolean empty() {
        return stack.isEmpty()&&helper.isEmpty();
    }
    private void fillHelperStack() {
        if(helper.isEmpty()){
            int stackSize=stack.size();
            for(int i=0;i<stackSize;i++){
                helper.push(stack.pop());
            }
        }
    }
}
