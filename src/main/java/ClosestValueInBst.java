import java.lang.Math;

public class ClosestValueInBst {

    public static int findClosestValueInBst(BST tree, int target) {

        int gblmin = Integer.MAX_VALUE;
        int result = tree.value;

        return helper(tree, target, gblmin, result);

    }

    public static int helper(BST tree, int target, int min, int result) {

        if (tree == null) {
            return result;
        }

        int curr = Math.abs(tree.value - target);

        if (curr < min) {
            min = curr;
            result = tree.value;
        }

        if (target > tree.value) {
            return helper(tree.right, target, min, result);
        } else {
            return helper(tree.left, target, min, result);
        }
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.right = new BST(15);
        tree.left.left = new BST(2);
        tree.left.left.left = new BST(1);
        tree.left.right = new BST(6);
        tree.right.left = new BST(13);
        tree.right.left.right = new BST(14);
        tree.left.right = new BST(22);

        System.out.println(findClosestValueInBst(tree, 12));


/**
 * 	array.add(this.name);

 for (Node x: this.children) {
 x.depthFirstSearch(array);
 }

 return array;

 */
    }
}
