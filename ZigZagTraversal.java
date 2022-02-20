package BinaryTree;
import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ZigZagTraversal {
    Node root;

    public List<List<Integer>> traversal(Node node) {

        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        List<Integer> lst = new ArrayList<>();
        int level = 1;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node rv = stack1.pop();
            lst.add(rv.data);
            if (level % 2 == 0) {
                if (rv.right != null) {
                    stack2.push(rv.right);
                }
                if (rv.left != null) {
                    stack2.push(rv.left);
                }
            } else {
                if (rv.left != null) {
                    stack2.push(rv.left);
                }
                if (rv.right != null) {
                    stack2.push(rv.right);
                }
            }
            if (stack1.isEmpty()) {
                stack1 = stack2;
                stack2 = new Stack<>();
                level++;
                list.add(lst);
                lst = new ArrayList<>();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ZigZagTraversal tree = new ZigZagTraversal();
        tree.root = new Node(5);
        tree.root.left = new Node(10);
        tree.root.right= new Node(20);
        tree.root.left.left=new Node(30);
        tree.root.left.right=new Node(40);
        tree.root.right.left=new Node(50);
        tree.root.right.right=new Node(60);
        tree.root.right.right.left=new Node(80);
        System.out.println("\nBinary tree: ");
        System.out.println(tree.traversal(tree.root));
    }
}




