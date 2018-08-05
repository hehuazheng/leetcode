import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class P114 {
    static TreeNode buildTree(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        String[] arr = str.split(",");
        TreeNode[] treeNodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String item = arr[i];
            if ("null".equals(item)) {
                treeNodes[i] = null;
            } else {
                treeNodes[i] = new TreeNode(Integer.parseInt(item));
            }
        }
        int i = 0;
        int j = 1;
        while (j < arr.length) {
            if (treeNodes[i] != null) {
                treeNodes[i].left = treeNodes[j];
                treeNodes[i].right = treeNodes[j + 1];
            }
            j += 2;
            i++;
        }
        return treeNodes[0];
    }

    TreeNode prev = null;

    public void flatten(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode p = root, previous = null;
//        stack.push(root);
//        while (!stack.empty()) {
//            p = stack.pop();
//            if (p.right != null) {
//                stack.push(p.right);
//            }
//            if (p.left != null) {
//                stack.push(p.left);
//            }
//            p.left = previous;
//            if (previous != null) {
//                previous.right = p;
//            }
//            previous = p;
//        }

        if(root != null){
            flatten(root.right);
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }
    }

    static void printTree(TreeNode tn) {
        while (tn != null) {
            System.out.print(tn.val + ",");
            tn = tn.right;
        }
    }

    public static void main(String[] args) {
        TreeNode tn = buildTree("1,2,5,3,4,null,6");
        new P114().flatten(tn);
        printTree(tn);
    }
}