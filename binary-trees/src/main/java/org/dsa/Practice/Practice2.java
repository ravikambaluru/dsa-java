package org.dsa.Practice;

import java.util.ArrayList;
import java.util.List;

public class Practice2 {

    private boolean ans=true;

    /**
     * LeetCode 226 invert tree
     * @param root node
     * @return root node
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * LeetCode 100 Same Tree
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q == null)return true;
        else if(p==null || q==null) return false;
        else {
            return p.val==q.val&&
                    isSameTree(p.left,q.left)&&
                    isSameTree(p.right, q.right);
        }
    }

    /**
     * LeetCode 110 Balanced binary tree
     *
     */
    public boolean isBalanced(TreeNode root) {
        this.ans= true;
        calculateDepth(root);
        return  ans;
    }
    private int calculateDepth(TreeNode node){
        if(node==null) return 0;
        int lefDepth=calculateDepth(node.left);
        int rightDepth=calculateDepth(node.right);
        int balanceFactor=lefDepth-rightDepth;
        if(balanceFactor>1)this.ans=false;
        return Math.max(lefDepth, rightDepth)+1;
    }

    /**
     * LeetCode 543 Diameter of Tree
     * @param root
     * @return
     */
    private int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverseTree(root);
        return diameter;
    }

    private int traverseTree(TreeNode node) {
        if(node==null) return 0;
        int leftDepth = traverseTree(node.left);
        int rightDepth = traverseTree(node.right);
        int currentDepth=leftDepth+rightDepth;
        diameter=Math.max(currentDepth, diameter);
        return 1+(Math.max(leftDepth,rightDepth));
    }

    /**
     *
     103. Binary Tree Zigzag Level Order Traversal
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        traverseZigZag(root, 1, ans);
        return ans;
    }

    private void traverseZigZag(TreeNode node, int level, List<List<Integer>> ans) {
        if(node == null) return;
        if(ans.size()<level){
            ArrayList<Integer> levelArray = new ArrayList<Integer>();
            ans.add(level-1, levelArray);
        }
        if(level%2==0)ans.get(level-1).addFirst(node.val);
        else ans.get(level-1).addLast(node.val);
        traverseZigZag(node.left, level+1, ans);
        traverseZigZag(node.right, level+1, ans);
    }

    /**
     * LeetCode 572 Subtree of another
     * Algorithm:
     * Traverse using Pre-order
     * Serialize both tree into string
     * Check if one string contains another
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder rootHash= traverseAndSerializeTree(root,new StringBuilder());
        StringBuilder subRootHash= traverseAndSerializeTree(subRoot, new StringBuilder());
        return rootHash.toString().contains(subRootHash.toString());
    }
    private StringBuilder traverseAndSerializeTree(TreeNode node, StringBuilder stringBuilder){
        if(node==null){
            stringBuilder.append(";null");
            return stringBuilder;
        }
        stringBuilder.append(";").append(node.val);
        traverseAndSerializeTree(node.left, stringBuilder);
        traverseAndSerializeTree(node.right, stringBuilder);
        return stringBuilder;
    }

    /**
     * LeetCode 236 Least Common Ancestor
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverseAndCheck(root, p, q);
        return lca;
    }

    private int traverseAndCheck(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)return 0;
        int hasNodeFoundOnLeft=traverseAndCheck(root.left, p, q);
        traverseAndCheck(root.right, p,q);

        return 23;
    }
}
