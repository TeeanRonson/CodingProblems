class AddTwoNumbersInLinkedList  {

    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        ListNode currOne = l1;
        ListNode currTwo = l2;
        ListNode dummy = new ListNode(0);
        ListNode mover = dummy;
        int carry = 0;
        int x, y;

        while (currOne != null || currTwo != null) {

            if (currOne != null) {
                x = currOne.val;
                currOne = currOne.next;
            } else {
                x = 0;
            }

            if (currTwo != null) {
                y = currTwo.val;
                currTwo = currTwo.next;
            } else {
                y = 0;
            }

            int sum = x + y + carry;
            carry = 0;

            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            }

            mover.next = new ListNode(sum);
            mover = mover.next;
        }

        if (carry != 0) {
            mover.next = new ListNode(carry);
        }

        return dummy.next;

    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode start = result;
        int carry = 0;

        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if (sum < 10) {
                result.next = new ListNode(sum);
                result = result.next;

            } else {
                int value = sum % 10;
                carry = 1;
                result.next = new ListNode(value);
                result = result.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l2 != null) {
            int sum = l2.val + carry;
            carry = 0;
            if (sum < 10) {
                result.next = new ListNode(sum);
                result = result.next;
            } else {
                int value = sum % 10;
                carry = 1;
                result.next = new ListNode(value);
                result = result.next;
            }
            l2 = l2.next;
        }

        while(l1 != null) {
            int sum = l1.val + carry;
            carry = 0;
            if (sum < 10) {
                result.next = new ListNode(sum);
                result = result.next;
            } else {
                int value = sum % 10;
                carry = 1;
                result.next = new ListNode(value);
                result = result.next;
            }
            l1 = l1.next;
        }

        if (carry != 0) {
            result.next = new ListNode(carry);
            result = result.next;
        }

        result = start;
        return result.next;


    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}