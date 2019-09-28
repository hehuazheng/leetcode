//import java.util.ArrayList;
//import java.util.List;
//
//public class P236 {
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == p || root == q || root == null) {
//            return root;
//        }
//
//        TreeNode r1 = lowestCommonAncestor(root.left, p, q);
//        TreeNode r2 = lowestCommonAncestor(root.right, p, q);
//        if(r1 != null && r2 != null) {
//            return root;
//        }
//        return r1 != null ? r1 : r2;
//    }
//
//    static TreeNode buildTree(String str) {
//        if (str == null || str.trim().equals('')) {
//            return null;
//        }
//        String[] arr = str.split(',');
//        TreeNode[] treeNodes = new TreeNode[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            String item = arr[i];
//            if ('null'.equals(item)) {
//                treeNodes[i] = null;
//            } else {
//                treeNodes[i] = new TreeNode(Integer.parseInt(item));
//            }
//        }
//        int i = 0;
//        int j = 1;
//        while (j < arr.length) {
//            if (treeNodes[i] != null) {
//                treeNodes[i].left = treeNodes[j];
//                treeNodes[i].right = treeNodes[j + 1];
//            }
//            j += 2;
//            i++;
//        }
//        return treeNodes[0];
//    }
//}
