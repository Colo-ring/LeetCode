package Tree;

import java.util.*;

/**
 * @author IntelliYJC
 * @create 2022/7/9 15:15
 * NC15 求二叉树的层序遍历
 */
public class levelOrderSearch {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if (root == null) return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = q.size();
            while (size --> 0) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(level);
        }
        return res;
    }
}

class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
 }