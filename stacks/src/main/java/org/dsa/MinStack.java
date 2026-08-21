package org.dsa;

import java.util.ArrayDeque;

public class MinStack {
    private final ArrayDeque<Integer> mainStack;
    private final ArrayDeque<Integer> minStack;
    public MinStack() {
        mainStack=new ArrayDeque<>();
        minStack=new ArrayDeque<>();
    }

    public void push(int value) {
        int currentMin = minStack.isEmpty() ? value : Math.min(minStack.peek(), value);
        minStack.offerFirst(currentMin);
        mainStack.offerFirst(value);
    }

    public void pop() {
        minStack.poll();
        mainStack.poll();
    }

    public int top() {
        return mainStack.isEmpty()?-1:mainStack.peek();
    }

    public int getMin() {
        return minStack.isEmpty()?-1:minStack.peek();
    }

}
