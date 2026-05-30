package org.dsa.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Practice {

    /**
      Leet code #144
      Pre-order traversal
     *
     *
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer=new ArrayList<>();
        traversePreOrder(root, answer);
//        traversePreOrderIterative(root, answer);
        return answer;
    }


    /**
     * LeetCode #94
     * In order traversal
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer= new ArrayList<>();
        traverseInorder(root,answer);
        return answer;
    }

    /**
     * LeetCode #145 Post Order traversal
     * @param root
     * @return answer
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<>();
        traversePostorder(root, answer);
        return answer;
    }

    private void traversePostorder(TreeNode node, List<Integer> answer) {
        if(node == null)return;
        traversePostorder(node.left, answer);
        traversePostorder(node.right, answer);
        answer.add(node.val);
    }

    private List<Integer> traversePreOrderIterative(TreeNode root, List<Integer> array){
        if(root!= null){
            Stack<TreeNode> callStack = new Stack<>();
            callStack.push(root);

            while(!callStack.isEmpty()){
                TreeNode currentNode = callStack.pop();
                if(currentNode!=null) {
                    array.add(currentNode.val);
                    if(currentNode.right!=null)callStack.push(currentNode.right);
                    if(currentNode.left!=null)callStack.push(currentNode.left);
                }
            }}
        return array;
    }

    private void traverseInorder(TreeNode node, List<Integer> answer) {
        if(node == null)return;
        traverseInorder(node.left, answer);
        answer.add(node.val);
        traverseInorder(node.right, answer);
    }

    private void traversePreOrder(TreeNode node, List<Integer> array){
        if(node == null) return;
        array.add(node.val);
        traversePreOrder(node.left,array);
        traversePreOrder(node.right,array);
    }

    private void traverseInorderIterative(TreeNode node, List<Integer> array){
        if(node == null) return ;
        Stack<TreeNode> callStack = new Stack<>();
        TreeNode currentNode=node;
        while (!callStack.isEmpty() || currentNode != null){
            while(currentNode!=null){
                callStack.push(currentNode);
                currentNode=currentNode.left;
            }
            currentNode = callStack.pop();
            array.add(currentNode.val);
            currentNode=currentNode.right;
        }
    }

}
