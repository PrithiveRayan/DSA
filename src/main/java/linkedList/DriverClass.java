package linkedList;

public class DriverClass {

    public static void main(String[] args) {

       //SingleLinkedList
        SinglyLinkedListUsingClass<Integer> slc = new SinglyLinkedListUsingClass<>();

        slc.insertAtHead(10);
        slc.insertAtHead(13);
        slc.insertAtHead(17);
        slc.insertAtHead(29);
        slc.insertAtHead(15);
        slc.show();
        slc.deleteAtMiddle();
        slc.show();
        slc.reverseTheList();
        slc.show();
        slc.insertAtTail(23);
        slc.show();
        slc.insertAtPos(3, 43);
        slc.show();
        System.out.println(slc.getSize());
        slc.deleteAtPos(3);
        slc.deleteAtHead();
        slc.deleteAtTail();
        slc.show();


//        // Doubly Linked list
//        DoublyLinkedListUsingClass<Integer> dll = new DoublyLinkedListUsingClass<>();
//        dll.insertAtHead(10);
//        dll.insertAtHead(13);
//        dll.insertAtHead(11);
//        dll.insertAtHead(27);
//        dll.insertAtHead(38);
//
////        dll.insertAtTail(17);
////        dll.show();
////        dll.insertAtPos(3, 43);
//        dll.show();
////        dll.removeAtHead();
////        dll.show();
////        dll.removeAtTail();
//        dll.removetAtPos(4);
//        dll.show();



//        CircularLinkedListUsingClass<Integer> cll = new CircularLinkedListUsingClass<>();
//        cll.insertAtBegining(10);
//        cll.insertAtBegining(19);
//        cll.insertAtBegining(17);
////        cll.show();
//        cll.insertAtEnd(27);
//        cll.show();
////        cll.insertAtPos(2, 15);
////        cll.show();
////        cll.insertAtBegining(13);
////        cll.show();
//        cll.removeAtHead();
//        cll.show();
////        cll.removeAtTail();
////        cll.show();




    }
}
