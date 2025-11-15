// Leetcode 103
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {

        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (node == null)
            return ans;
        ms.push(node);
        int level = 1;
        while (ms.size() > 0) {
            node = ms.pop();
            list.add(node.val);
            if (level % 2 != 0) {
                if (node.left != null)
                    cs.push(node.left);
                if (node.right != null)
                    cs.push(node.right);
            } else {
                if (node.right != null)
                    cs.push(node.right);
                if (node.left != null)
                    cs.push(node.left);
            }

            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack<>();
                ans.add(list);
                list = new ArrayList<>();
                level++;
            }

        }
        return ans;
    }

    
===============================================================
// simple solution using queue and List.add(0,ele)
// drawback: O(N) for adding in list

public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    boolean leftToRight = true;

    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();

            // Insert based on the direction
            if (leftToRight) {
                level.add(node.val);
            } else {
                level.add(0, node.val);  // reverse insert
            }

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        ans.add(level);
        leftToRight = !leftToRight; // flip direction
    }

    return ans;
}
===============================================================

// efficient using linkedList;
// List<List<Integer>> can accept LinkedList<Integer>



public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);

    boolean leftToRight = true;

    while (!queue.isEmpty()) {
        int size = queue.size();
        LinkedList<Integer> level = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            TreeNode node = queue.removeFirst();

            if (leftToRight) {
                level.addLast(node.val);
            } else {
                level.addFirst(node.val);
            }

            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }

        ans.add(level);
        leftToRight = !leftToRight;
    }

    return ans;
}








    
}
