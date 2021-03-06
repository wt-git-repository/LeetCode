package project.algorithm.Binary_Search_Tree_to_Greater_Sum_Tree;

public class Main {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return new TreeNode(0);
        int temp = bstToGst(root.right).val;
        root.val += (temp > max ? temp : max);
        max = root.val > max ? root.val : max;
        if (root.left != null) {
            int temp2 = bstToGst(root.left.right).val;
            root.left.val += max > temp2 ? max : temp2;
            max = max > root.left.val ? max : root.left.val;
            bstToGst(root.left.left);
        }
        return root;
    }
}

