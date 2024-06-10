package Day3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Bai2 {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    class Result {

        /*
         * Complete the 'removeDuplicates' function below.
         *
         * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
         * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
         */

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */

        public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
            // Write your code here
            SinglyLinkedListNode curr = llist;

            /* Traverse list till the last node */
            while (curr != null) {
                SinglyLinkedListNode temp = curr;
            /*Compare current node with the next node and
            keep on deleting them until it matches the
            current node data */
                while (temp != null && temp.data == curr.data) {
                    temp = temp.next;
                }
            /*Set current node next to the next different
            element denoted by temp*/
                curr.next = temp;
                curr = curr.next;
            }
            return llist;
        }

    }
}
