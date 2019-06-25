

public class ReverseLinkedList {


    /**
     *
     * 0 -> 1 -> 2 -> 3 -> 4
     *
     *
     *
     * @param node
     */
    public static Node reverseLinkedList(Node node) {

        Node prev = null;
        Node curr = node;
        Node after = null;

        while(curr != null) {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        node = prev;
        return node;

    }


    public static void print(Node node) {

        Node current = node;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

    }

    static class Node {
        int value;
        Node next;
        Node(int val) {
            value = val;
            next = null;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(0);
        Node curr = head;
        for (int i = 1; i <= 5; i++) {
            curr.next = new Node(i);
            curr = curr.next;
        }

        print(head);
        Node fresh = reverseLinkedList(head);
        System.out.println();
        print(fresh);



    }

}
