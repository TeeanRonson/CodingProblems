import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

public class LevelsOfTree {


    public static ArrayList<LinkedList<Node>> findLevels(Node root) {

        ArrayList<LinkedList<Node>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        LinkedList<Node> curr = new LinkedList<>();
        curr.add(root);

        while(!curr.isEmpty()) {
            result.add(curr);
            LinkedList<Node> parents = curr;
            curr = new LinkedList<>();
            for (Node node: parents) {
                if (node.left != null) {
                    curr.add(node.left);
                }
                if (node.right != null) {
                    curr.add(node.right);
                }
            }

        }
        return result;

    }

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }



    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        for (LinkedList<Node> x: findLevels(root)) {
            for (Node y: x) {
                System.out.print(y.value + " ");
            }
            System.out.println();
        }

    }
}
