public class LongestConsecutiveSequenceTree {

        int longest = 0;

        public LongestConsecutiveSequenceTree() {

        }

        public int solution(Node root) {
            helper(root, 0, 0);
            return longest;
        }


        public void helper(Node curr, int count, int prev) {

             if (curr != null) {
                if (curr.value == prev + 1) {
                    count++;
                    longest = Math.max(count, longest);
                }
                helper(curr.left, count, curr.value);
                helper(curr.right, count, curr.value);
            }
        }

        public static class Node {
            int value;
            Node left;
            Node right;

            public Node(int value) {
                this.value = value;
            }

            public void setLeft(Node node) {
                this.left = node;
            }

            public void setRight(Node node) {
                this.right = node;
            }
        }


    public static void main(String[] args) {

        Node one = new Node(1);
        Node two = new Node(7);
        Node three = new Node(1);
        Node four = new Node(8);
        Node five = new Node(8);
        Node fivea = new Node(9);
        Node fiveb = new Node(10);
        Node fivec = new Node(11);

        Node six = new Node(2);
        Node seven = new Node(9);


        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        four.left = seven;
        five.right = fivea;
        fivea.right = fiveb;
        fiveb.right = fivec;

        LongestConsecutiveSequenceTree s = new LongestConsecutiveSequenceTree();
        System.out.println(s.solution(one));

    }

}
