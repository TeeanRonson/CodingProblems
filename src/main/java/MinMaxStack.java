import java.util.LinkedList;

public class MinMaxStack {
    // Feel free to add new properties and methods to the class.

    static class Node {
        Integer value;
        Integer prevMin;
        Integer prevMax;

        Node(int val, int pre, int max) {
            value = val;
            prevMin = pre;
            prevMax = max;
        }
    }

    static class MinMax {

        static LinkedList<Node> stack = new LinkedList<>();
        static Integer minValue = Integer.MAX_VALUE;
        static Integer maxValue = Integer.MIN_VALUE;

        public Integer peek() {
            if (stack.isEmpty()) {
                return null;
            }
            return stack.getLast().value;
        }

        public Node getTopNode() {
            return stack.getLast();
        }

        public Integer pop() {
            if (peek() == null) {
                return null;
            }
            if (peek() == minValue) {
                minValue = getTopNode().prevMin;
            }
            if (peek() == maxValue) {
                maxValue = getTopNode().prevMax;
            }
            
            return stack.removeLast().value;
        }


        public void push(Integer number) {

            Node newNode;
            if (stack.isEmpty()) {
                minValue = number;
                maxValue = number;
                newNode = new Node(number, number, number);
                stack.add(newNode);
            }

            //If number is the new largest
            // else is it the new smallest?
            //else just add it
            newNode = new Node(number, minValue, maxValue);
            if (number < minValue) minValue = number;
            if (number > maxValue) maxValue = number;
            stack.add(newNode);
        }


        public Integer getMin() {
            return minValue;
        }

        public Integer getMax() {
            return maxValue;
        }
    }

    public static void main(String[] args) {

        MinMaxStack.MinMax stack = new MinMaxStack.MinMax();

        System.out.println("\nInsert 5");
        stack.push(5);
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
        System.out.println(stack.peek());

        System.out.println("\nInsert 7");
        stack.push(7);
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
        System.out.println(stack.peek());

        System.out.println("\nInsert 2");
        stack.push(2);
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
        System.out.println(stack.peek());

        System.out.println("\nPOP");
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("\nFinalCheck");
        System.out.println(stack.peek());
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());





    }



}