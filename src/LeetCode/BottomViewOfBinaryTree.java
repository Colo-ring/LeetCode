package LeetCode;
import java.util.*;
/**
 * @author IntelliYJC
 * @create 2022/9/2 16:47
 * 二叉树，底视图 https://www.geeksforgeeks.org/bottom-view-binary-tree/
 */
public class BottomViewOfBinaryTree {
    public static void main(String[] args) {
        BottomViewOfBinaryTree s = new BottomViewOfBinaryTree();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        s.bottmVied(root);
    }

    public void bottmVied(TreeNode root) {
        if (root == null) return;
        int id = 0;
        int level = 0;

        Deque<TreeNode> q = new ArrayDeque<>();
        Map<Integer, TreeNode> m = new TreeMap<>();

        root.id = id;
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            id = node.id;
            level = node.level;
            if (!m.containsKey(id) || m.get(id).level != level || node.val < m.get(id).val) {
                m.put(id, node);
            }

            if (node.left != null) {
                node.left.id = id - 1;
                node.left.level = level + 1;
                q.offer(node.left);
            }

            if (node.right != null) {
                node.right.id = id + 1;
                node.right.level = level + 1;
                q.offer(node.right);
            }
        }

        for (TreeNode node : m.values()) {
            System.out.println(node.val);
        }
    }
}

class TreeNode {
    int val, id, level;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        level = Integer.MIN_VALUE;
        this.id = Integer.MAX_VALUE;
        left = right = null;
    }
}
