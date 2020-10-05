//import LinkedListNodeImplementation;
//import LinkedListImplementation;
import java.util.*;
public class LinkedListInterview {

    // Take linked list and delete the kth node ~from the end~.  0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7-> 8 -> 9. k(3) = delete 7.

    public static void main(String[] args) {
        // Initialize Linked List

        LinkedListImplementation<Integer> list = new LinkedListImplementation<Integer>();
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        list.display();

        //list = deleteKArrayList(list, 1);
        list = deleteKSlowPointer(list, 0);

        list.display();


        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(9);
        linkedList.add(8);
        linkedList.add(7);
        linkedList.add(6);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(0);
        //System.out.println(linkedList.toString());
    }

    public static LinkedListImplementation deleteKArrayList(LinkedListImplementation list, int k) {
        LinkedListNodeImplementation currNode = list.head;
        int index = -1;

        ArrayList<LinkedListNodeImplementation> arrList = new ArrayList<LinkedListNodeImplementation>();

        while(currNode != null) {
            arrList.add(currNode);
            index++;
            currNode = currNode.next;
        }

        if(arrList.size() >= k) {
            int deleteIndex = index+1 - k;
            if(deleteIndex > 0) {
                arrList.get(deleteIndex-1).next = arrList.get(deleteIndex).next;
            }
            else {
                list.head = list.head.next;
            }
        }

        return list;
    }

    public static LinkedListImplementation deleteKSlowPointer(LinkedListImplementation list, int k) {
        LinkedListNodeImplementation fastPointer = list.getHead();
        int fastPointerIndex = 0;

        LinkedListNodeImplementation slowPointer = null;
        LinkedListNodeImplementation slowPointerPrevious = null;

        if(k <= 0) {
            return list;
        }

        while(fastPointer != null) {
            if(fastPointerIndex+1 == k) {
                slowPointer = list.head;
            }
            else if(fastPointerIndex+1 > k) {
                slowPointerPrevious = slowPointer;
                slowPointer = slowPointer.next;
            }


            fastPointer = fastPointer.next;
            fastPointerIndex++;
        }

        if(slowPointer == null) {
            return list;
        }
        else if(slowPointerPrevious == null) {
            list.head = list.head.next;
        }
        else {
            slowPointerPrevious.next = slowPointer.next;
        }

        return list;
    }
}
