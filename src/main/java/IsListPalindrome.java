import java.util.Stack;

public class IsListPalindrome {

    private static class ListNode<T> {

       ListNode(T x) {
         value = x;
        }

       T value;
       ListNode<T> next;
    }



    public static boolean isPalindrome(ListNode<Integer> l) {

        ListNode<Integer> headOne = l;
        ListNode<Integer> headTwo = l;
        Stack<Integer> store = new Stack<>();
        int i = 0;
        int j = 0;

        while(headTwo != null && headTwo.next != null) {
            headTwo = headTwo.next.next;
            i++;
        }

        System.out.println(i);
        //If odd
        if (i % 2 != 0) {
            while (headOne != null) {
                if (j < i) {
                    store.push(headOne.value);
                } else if (j > i) {
                    if (store.pop() != headOne.value) {
                        return false;
                    }
                }
                headOne = headOne.next;
                j++;

            }
            //if even
        } else {
            while (headOne != null) {
                if (j < i) {
                    store.push(headOne.value);
                } else {
                    if (store.pop() != headOne.value) {
                        return false;
                    }
                }
                headOne = headOne.next;
                j++;
            }
        }

        return true;

    }


    public static void main(String[] args) {


        ListNode<Integer> one = new ListNode<Integer>(1);
        ListNode<Integer> two = new ListNode<Integer>(2);
        ListNode<Integer> three = new ListNode<Integer>(3);
        ListNode<Integer> four = new ListNode<Integer>(3);
        ListNode<Integer> five = new ListNode<Integer>(2);
        ListNode<Integer> six = new ListNode<Integer>(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = null;

        System.out.println(isPalindrome(one));

    }
}
