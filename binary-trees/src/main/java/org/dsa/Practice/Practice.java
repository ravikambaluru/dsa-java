package org.dsa.Practice;

import java.util.*;

public class Practice {
    private boolean ans=false;

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

    /**
     * LeetCode 102 Level Order traversal
     * BFS Iterative approach
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        ArrayDeque<TreeNode> q1 = new ArrayDeque<>();

        if(root != null){
            q1.offer(root);
            while(!q1.isEmpty()){
                ArrayList<Integer> levelArray = new ArrayList<>();
                int size= q1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode currentNode=q1.poll();
                    if(currentNode.left!=null)q1.offer(currentNode.left);
                    if(currentNode.right!=null)q1.offer(currentNode.right);
                    levelArray.add(currentNode.val);
                }
                answer.add(levelArray);
            }

        }
        return answer;
    }
    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        traverseBFS(root,0, ans);
        return ans;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftMaxDepth=maxDepth(root);
        int rightMaxDepth=maxDepth(root);
        return Math.max(leftMaxDepth, rightMaxDepth);
    }

    /**
     * LeetCode 112 PathSum
     * @return boolean
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return traverse(root, targetSum, 0);
    }
    private boolean traverse(TreeNode node, int targetSum, int pathSum){
        pathSum+= node.val;
        if(node.left==null&&node.right==null&&pathSum==targetSum){
            ans=true;
        }
        if(node.left!=null)traverse(node.left, targetSum, pathSum+node.val);
        if(node.right!=null)traverse(node.right, targetSum, pathSum+node.val);
        return ans;
    }

    /**
     * LeetCode 101 Symmetric Tree
     * @param root which is tree node
     * @return boolean
     */
    public boolean isSymmetric(TreeNode root) {
        return areTheySymmetric(root.left, root.right);
    }

    private boolean areTheySymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        else
            return left.val == right.val
                && areTheySymmetric(left.right, right.left)
                && areTheySymmetric(left.left, right.right);
    }
    private void traverseBFS(TreeNode root, int level, List<List<Integer>> ans){
        if(root == null) return;
        if(level>ans.size())ans.add(level,new ArrayList<Integer>());
        ans.get(level).add(root.val);
        if(root.left!=null)traverseBFS(root.left,level+1, ans);
        if(root.right!=null)traverseBFS(root.right,level+1, ans);
    }

    private void traversePostorder(TreeNode node, List<Integer> answer) {
        if(node == null)return;
        traversePostorder(node.left, answer);
        traversePostorder(node.right, answer);
        answer.add(node.val);
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

    private void traversePostorderIterative(TreeNode node, List<Integer> array){
        if(node==null) return ;
        Stack<TreeNode> childrenStack = new Stack<>();
        Stack<Integer> answerStack = new Stack<>();
        childrenStack.push(node);
        while(!childrenStack.isEmpty()){
            TreeNode current = childrenStack.pop();
            answerStack.push(current.val);
            if(current.left!=null)childrenStack.push(current.left);
            if(current.right!=null)childrenStack.push(current.right);
        }
        while(!answerStack.isEmpty()){
            array.add(answerStack.pop());
        }

    }
    private void traversePostorderIterativeOneStack(TreeNode node, List<Integer> array){
        if(node==null) return ;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode currentNode=node;
        TreeNode lastVisitedNode=node;
        while(!stack.isEmpty()||currentNode!=null){
            while(currentNode!=null){
                stack.push(currentNode);
                currentNode=currentNode.left;
            }
            TreeNode peakNode=stack.peek();
            if(peakNode.right!=null && peakNode.right != lastVisitedNode){
                currentNode=peakNode.right;
            }else {
                array.add(peakNode.val);
                lastVisitedNode=stack.pop();
            }
        }
    }

}
