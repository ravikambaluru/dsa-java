package org.dsa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
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

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> ngeMap = populateNgeElements(nums2);
        return Arrays.stream(nums1).map(ngeMap::get).toArray();
    }

    private static HashMap<Integer, Integer> populateNgeElements(int[] nums2) {
        ArrayDeque<Integer> ngeStack = new ArrayDeque<>();
        HashMap<Integer, Integer> ngeMap = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int currentEl = nums2[i];
            while (!ngeStack.isEmpty() && ngeStack.peek() <= currentEl) {
                ngeStack.pop();
            }
            ngeMap.put(currentEl, ngeStack.isEmpty() ? -1 : ngeStack.peek());
            ngeStack.push(currentEl);
        }
        return ngeMap;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            int currentTemperature = temperatures[i];
            while (!stack.isEmpty() && currentTemperature > temperatures[stack.peek()]) {
                Integer popped = stack.pop();
                ans[popped] = i - popped;
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] linearArray = new int[nums.length * 2];
        int[] ans = new int[nums.length * 2];
        System.arraycopy(nums, 0, linearArray, 0, nums.length);
        System.arraycopy(nums, 0, linearArray, nums.length, nums.length);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = linearArray.length - 1; i >= 0; i--) {
            int currentElement = linearArray[i];
            while (!stack.isEmpty() && currentElement >= stack.peek()) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(currentElement);
        }
        return Arrays.copyOfRange(ans, 0, nums.length);
    }

}