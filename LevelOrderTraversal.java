package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
public class LevelOrderTraversal {

    Node root;
    public List<List<Integer>> traversal(Node node ){

        List<List<Integer>>list = new ArrayList<>();
        if(node==null)return list;
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node>queue2 = new LinkedList<>();
        List<Integer> lst= new ArrayList<>();
        queue1.add(node);
        while(!queue1.isEmpty()){
            Node rv = queue1.remove();
            lst.add(rv.data);
            if(rv.left!=null) {
                queue2.add(rv.left);
            }
            if(rv.right!=null) {
                queue2.add(rv.right);
            }
            if(queue1.isEmpty()){
                queue1=queue2;
                queue2=new LinkedList();
                list.add(lst);
                lst= new ArrayList<>();
            }
        }
        return list;

    }

    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
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
