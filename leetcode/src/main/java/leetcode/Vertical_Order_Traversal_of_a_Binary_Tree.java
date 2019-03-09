package leetcode;

import java.util.List;

public class Vertical_Order_Traversal_of_a_Binary_Tree {

    public static void main(String[] args) {
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    static class TreeNode {
        int val;
        int x, y;
        TreeNode left;
        TreeNode right;

        TreeNode(int v, int x, int y) {
            val = v;
            this.x = x;
            this.y = y;
        }
    }

    static class Solution {



        public TreeNode buildTree(List<Integer> data) {
            TreeNode root = new TreeNode(data.get(0), 0, 0);
            for (int i = 1; i < data.size(); i++) {
                insertNode(root, data.get(i));
            }
            return root;
        }

        public void insertNode(TreeNode node, Integer data) {
            if (node.left != null) {
                insertNode(node.left, data);
            } else if (node.right != null) {
                insertNode(node.right, data);
            }
            if (node.left == null) {
                node.left = new TreeNode(data, node.x - 1, node.y - 1);
            } else if (node.right == null) {
                node.right = new TreeNode(data, node.x + 1, node.y - 1);
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {

            return null;
        }
    }

}
