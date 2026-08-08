package org.dsa;

import java.util.ArrayDeque;

class MyStack {

    private ArrayDeque<Integer> queue;
    public MyStack() {
        queue=new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size()-1; i++) {
            Integer message = queue.poll();
            queue.offer(message);
        }
    }

    public int pop() {
        return queue.isEmpty()?0:queue.poll();
    }

    public int top() {
        return queue.isEmpty()?0:queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
