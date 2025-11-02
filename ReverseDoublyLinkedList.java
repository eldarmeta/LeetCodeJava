public class ReverseDoublyLinkedList {
    static class DoublyNode {
        int val;
        DoublyNode prev, next;
        DoublyNode(int v) { this.val = v; }
    }

    static DoublyNode reverse(DoublyNode head) {
        DoublyNode curr = head;
        DoublyNode newHead = null;
        while (curr != null) {
            DoublyNode temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            newHead = curr;
            curr = curr.prev;
        }
        return newHead;
    }

    static DoublyNode fromArray(int[] arr) {
        if (arr.length == 0) return null;
        DoublyNode head = new DoublyNode(arr[0]);
        DoublyNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            DoublyNode node = new DoublyNode(arr[i]);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }
        return head;
    }

    static String toString(DoublyNode head) {
        StringBuilder sb = new StringBuilder();
        for (DoublyNode p = head; p != null; p = p.next) {
            sb.append(p.val);
            if (p.next != null) sb.append(" <-> ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyNode head = fromArray(new int[]{1,2,3,4,5});
        System.out.println("Before: " + toString(head));
        DoublyNode rev = reverse(head);
        System.out.println("After:  " + toString(rev));
    }
}
