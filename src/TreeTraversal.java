import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {
    static class Tree {
        Tree left;
        Tree right;
        char val;
        boolean visited;

        Tree(char c, Tree left, Tree right) {
            val = c;
            this.left = left;
            this.right = right;
        }
    }

    String pre(Tree t) {
        StringBuilder sb = new StringBuilder();
        Stack<Tree> stack = new Stack<>();
        stack.push(t);
        while (!stack.empty()) {
            Tree p = stack.pop();
            sb.append(p.val);
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }

        }
        return sb.toString();
    }

    String mid(Tree t) {
        StringBuilder sb = new StringBuilder();
        Tree p = t;
        Stack<Tree> stack = new Stack<>();
        while (p != null || stack.size() > 0) {
            if (p == null) {
                p = stack.pop();
                sb.append(p.val);
                p = p.right;
            } else {
                stack.push(p);
                p = p.left;
            }

        }
        return sb.toString();
    }

    String end(Tree t) {
        Stack<Tree> stka = new Stack<>();
        Stack<Tree> stkb = new Stack<>();
        stka.push(t);
        while (!stka.empty()) {
            Tree p = stka.pop();
            stkb.push(p);
            if (p.left != null) {
                stka.push(p.left);
            }
            if (p.right != null) {
                stka.push(p.right);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stkb.isEmpty()) {
            sb.append(stkb.pop().val);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
//        Tree i = new Tree("i", null, null);
//        Tree h = new Tree("h", null, null);
//        Tree g = new Tree("g", null, h);
//        Tree e = new Tree("e", null, null);
//        Tree f = new Tree("f", e, null);
//        Tree d = new Tree("d", null, null);
//        Tree c = new Tree("c", g, i);
//        Tree b = new Tree("b", d, f);
//        Tree a = new Tree("a", b, c);
//
//        TreeTraversal tt = new TreeTraversal();
//        System.out.println(tt.pre(a));
//        System.out.println(tt.mid(a));
//        System.out.println(tt.end(a));
    }
}
