package org.dsa;

import java.util.ArrayDeque;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
    public boolean isValid(String s) {
        Map<Character, Character> paranthesisMap = Map.of(')', '(', ']', '[', '}', '{');
        ArrayDeque<Character> charStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (paranthesisMap.containsKey(c)) {
                if(charStack.isEmpty()||charStack.pop()!=paranthesisMap.get(c))return false;
            } else {
                charStack.push(c);
            }
        }
        return charStack.isEmpty();
    }

    public String removeOuterParentheses(String s) {
        ArrayDeque<Character> charStack = new ArrayDeque<>();
        StringBuilder output= new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c =='('){
                charStack.push(c);
                if(charStack.size()>1) output.append(c);
            }else{
                if(charStack.size()>1){
                    output.append(c);
                }
                charStack.pop();
            }
        }

        return output.toString();
    }

    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                Integer result = computeResult(token, b, a);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static Integer computeResult(String token, Integer b, Integer a) {
        return switch (token) {
            case "+" -> b + a;
            case "-" -> b - a;
            case "*" -> b * a;
            default -> b / a;
        };
    }

}