package org.dsa.Practice;

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
}
