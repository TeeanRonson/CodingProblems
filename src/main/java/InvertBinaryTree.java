import java.util.ArrayDeque;
import java.util.ArrayList;

    public class InvertBinaryTree {
        public static void invertBinaryTree(BinaryTree tree) {

            ArrayList<Integer> store = new ArrayList<>();
            collectValues(tree, store);

            ArrayList<BinaryTree> queue = new ArrayList<>();
            BinaryTree newTree = new BinaryTree(store.remove(0));
            queue.add(tree);
            System.out.println("Tree.value: " + tree.value);

            while(!queue.isEmpty()) {
                System.out.println("IN");
                BinaryTree curr = queue.remove(0);
                if (curr == null) continue;
                if (!store.isEmpty() && curr.right != null) {
                    curr.right.value = store.remove(0);
                    System.out.println("Right:" + curr.right.value);
                    queue.add(curr.right);
                }
                if (!store.isEmpty() && curr.left != null) {
                    curr.left.value = store.remove(0);
                    System.out.println("Left:" + curr.left.value);
                    queue.add(curr.left);
                }
            }

//            tree = newTree;
            print(tree);
        }

        public static void print(BinaryTree tree) {
            ArrayList<BinaryTree> queue = new ArrayList<>();
            queue.add(tree);
            System.out.println("Printer:");
            while(!queue.isEmpty()) {
                BinaryTree curr = queue.remove(0);
                System.out.println("Curr:" + curr.value + " ");
                System.out.println("Left:" + curr.left.value);
                System.out.println("Right:" + curr.right.value);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }

        public static void collectValues(BinaryTree tree, ArrayList<Integer> store) {

            ArrayList<BinaryTree> queue = new ArrayList<>();
            queue.add(tree);

            System.out.println("Collecting Values: ");
            while(!queue.isEmpty()) {
                BinaryTree curr = queue.remove(0);
                store.add(curr.value);
                System.out.print(curr.value + " ");
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            System.out.println();
        }

        static class BinaryTree {
            public int value;
            public BinaryTree left;
            public BinaryTree right;

            public BinaryTree(int value) {
                this.value = value;
            }
        }

        public static void main(String[] args) {


            BinaryTree tree = new BinaryTree(1);
            tree.left = new BinaryTree(2);
            tree.right = new BinaryTree(3);
            tree.left.left = new BinaryTree(4);
            tree.left.right = new BinaryTree(5);
            tree.right.left = new BinaryTree(6);
            tree.right.right = new BinaryTree(7);


            invertBinaryTree(tree);


        }
    }
