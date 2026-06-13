package org.dsa.Practice;

public class Practice2 {

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
}
