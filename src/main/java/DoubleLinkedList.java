// Feel free to add new properties and methods to the class.
   public class DoubleLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {

            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);

        }

        public void setTail(Node node) {

            if (tail == null) {
                setHead(node);
            }
            insertAfter(tail, node);
        }

        public void insertBefore(Node node, Node nodeToInsert) {

            if (nodeToInsert == head && nodeToInsert == tail) {
                return;
            }
            remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            if (node.prev == null) {
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;

        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) {
                return;
            }
            remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;
            if(node.next == null) {
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;

        }

        public void insertAtPosition(int position, Node nodeToInsert) {

            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }
            Node curr = head;
            int currPos = 1;
            while (curr != null && currPos++ != position) {
                curr = curr.next;
            }
            if (curr != null) {
                insertBefore(curr, nodeToInsert);
            } else {
                setTail(nodeToInsert);
            }

        }

        public void removeNodesWithValue(int value) {

            Node curr = head;
            while(curr != null) {
                Node nodeToRemove = curr;
                curr = curr.next;
                if (nodeToRemove.value == value) {
                    remove(nodeToRemove);
                }
            }

        }

        public void remove(Node node) {
            Node dummy = new Node(-1);
            Node curr = head;
            dummy.next = curr;

            if (node == head) {
                head = head.next;
            }
            if (node == tail) {
                tail = tail.prev;
            }

            removeNodeBindings(node);
        }

        public void removeNodeBindings(Node node) {

            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if(node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = null;

        }


        public boolean containsNodeWithValue(int value) {
            Node curr = head;

            while(curr != null) {
                if (curr.value == value) {
                    return true;
                }
                curr = curr.next;
            }

            return false;
        }
    }

    // Do not edit the class below.
    class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
