// 34. Traverse a binary tree in zigzag order
// n + n time n space

package tree_problems;

import tree.TreeNode;

import java.util.*;

public class ZigzagTraversal {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(zigzag(root));
    }

    private static List<ArrayList<Integer>> zigzag(TreeNode root) {
        List<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        boolean reverse = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        List<Integer> current = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                current.add(temp.data);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            } else {
                if (reverse) {
                    ArrayList<Integer> array = new ArrayList<>(current);
                    result.add(array);
                    current.clear();
                } else {
                    Stack<Integer> stack = new Stack<>();
                    stack.addAll(current);
                    ArrayList<Integer> array = new ArrayList<>();
                    while (!stack.isEmpty())
                        array.add(stack.pop());
                    result.add(array);
                    current.clear();
                }

                if (!queue.isEmpty()) {
                    queue.offer(null);
                    reverse = !reverse;
                }
            }
        }
        return result;
    }
}
