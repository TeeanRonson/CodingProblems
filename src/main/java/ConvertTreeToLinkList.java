import java.util.LinkedList;
import java.util.List;

public class ConvertTreeToLinkList {


    public static LinkedList<Node> convertTree(Node root) {

        LinkedList<Node> result = new LinkedList<>();

        extractTree(root, result);

        for (Node i: result) {
            System.out.print(i.key + " ");
        }

        ListNode node = new ListNode(result.getFirst().key);
        ListNode curr = node;
        for (Node x: result) {
            ListNode next = new ListNode(x.key);
            curr.next = next;
            curr = curr.next;

        }

        node.next = node.next.next;

        ListNode curr1 = node;
        while (curr1 != null) {
            System.out.print(curr1.key + " ");
            curr1 = curr1.next;
        }


        return result;

    }

    /**
     * Inorder Traversal extraction
     * @param root
     * @param list
     */
    private static void extractTree(Node root, LinkedList<Node> list) {

        if (root == null) return;
        extractTree(root.left, list);
        list.add(root);
        extractTree(root.right, list);

    }
    /**
     * Node class
     */
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    /**
     * Node class
     */
    static class ListNode {
        int key;
        ListNode next, prev;

        public ListNode(int item) {
            key = item;
            next = prev = null;
        }
    }


    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {

        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        convertTree(root);


    }


}
