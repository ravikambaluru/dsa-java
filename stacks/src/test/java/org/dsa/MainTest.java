package org.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main=new Main();
    private MinStack minStack=new MinStack();

    @Test
    void isValid() {
        assertEquals(true, main.isValid("){"));
    }

    @Test
    void testMinStackSequence() {
        // ["push", -10]
        minStack.push(-10);

        // ["push", 14]
        minStack.push(14);

        // ["getMin"] -> -10
        assertEquals(-10, minStack.getMin());

        // ["getMin"] -> -10
        assertEquals(-10, minStack.getMin());

        // ["push", -20]
        minStack.push(-20);

        // ["getMin"] -> -20
        assertEquals(-20, minStack.getMin());

        // ["getMin"] -> -20
        assertEquals(-20, minStack.getMin());

        // ["top"] -> -20
        assertEquals(-20, minStack.top());

        // ["getMin"] -> -20
        assertEquals(-20, minStack.getMin());

        // ["pop"] -> removes -20
        minStack.pop();

        // ["push", 10]
        minStack.push(10);

        // ["push", -7]
        minStack.push(-7);

        // ["getMin"] -> expected -10 (your output was -20)
        assertEquals(-10, minStack.getMin());

        // ["push", -7]
        minStack.push(-7);

        // ["pop"] -> removes -7
        minStack.pop();

        // ["top"] -> -7
        assertEquals(-7, minStack.top());

        // ["getMin"] -> expected -10 (your output was -20)
        assertEquals(-10, minStack.getMin());

        // ["pop"] -> removes -7
        minStack.pop();
    }

    @Test
    void removeOuterParentheses() {
        String actual = main.removeOuterParentheses("(()())(())(()(()))");
        assertEquals("()()()()(())",actual);
    }
}