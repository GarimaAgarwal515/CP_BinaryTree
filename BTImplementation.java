package BinaryTree;

import java.util.*;

public class BTImplementation {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;

        }
    }
    Scanner sc = new Scanner(System.in);
     private Node root;
    public BTImplementation() {

        this.root=insert();
    }
    public Node insert() {

        int item = sc.nextInt();
        Node newnode = new Node(item);
        boolean leftBT = sc.nextBoolean();
        if (leftBT == true) {
            newnode.left = insert();
        }
        boolean rightBT = sc.nextBoolean();
        if (rightBT == true) {
            newnode.right = insert();
        }
        return newnode;
    }
    public void Display(){
        display(this.root);
    }
    public void display(Node node){
        if (node == null) {
            return;
        }
        String str = "<--" + node.data + "-->";
        if (node.left != null) {
            str = node.left.data + str;
        } else {
            str = "." + str;
        }
        if (node.right != null) {
            str = str + node.right.data;
        } else {
            str = str + ".";
        }
        System.out.println(str);
        display(node.left);
        display(node.right);


    }



    }


