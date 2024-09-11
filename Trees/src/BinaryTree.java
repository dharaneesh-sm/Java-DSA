import java.util.*;
public class BinaryTree {
    public BinaryTree() {
    }
    private static class Node{
        public Node(int val) {
            this.val = val;
        }
        int val;
        Node left;
        Node right;
    }
    private Node root;

    public void populate(Scanner sc){
        System.out.println("Enter the root node");
        int val = sc.nextInt();
        root = new Node(val);
        populate(sc, root);
    }
    private void populate(Scanner sc,Node node){
        System.out.println("Do you want to Enter left of "+node.val);
        boolean left = sc.nextBoolean();
        if(left) {
            System.out.println("Enter the value of left of "+node.val);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc, node.left);
        }

        System.out.println("Do you want to Enter right of "+node.val);
        boolean right = sc.nextBoolean();
        if(right) {
            System.out.println("Enter the value of right of " + node.val);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc, node.right);
        }
    }

    public void display(){
        display(root,"");
    }
    private void display(Node node,String indent){
        if(node == null){
            return;
        }
        System.out.println(indent+node.val);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");
    }

}
