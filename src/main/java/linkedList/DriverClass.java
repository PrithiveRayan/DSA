package linkedList;

public class DriverClass {

    public static void main(String[] args) {
        SinglyLinkedListUsingClass<Integer> slc = new SinglyLinkedListUsingClass<>();

//        slc.insertAtBegining(10);
//        slc.insertAtBegining(13);
//        slc.show();
//        slc.insertAtBegining(15);
//        slc.show();
//        slc.insertAtPos(2, 17);
//        slc.show();
//        slc.insertAtEnd(19);
//        slc.show();


        slc.insertAtBegining(10);
        slc.insertAtBegining(13);
        slc.insertAtBegining(17);
        slc.insertAtBegining(29);
        slc.insertAtBegining(15);
        slc.show();
        slc.reverseTheList();
        slc.show();
//        slc.deleteAtBegining();
//        slc.show();
//        slc.deleteAtEnding();
//        slc.show();
//        slc.deleteAtPos(3);
//        slc.show();

//        SinglyLinkedListUsingClass<String> slc2 = new SinglyLinkedListUsingClass<>();
//        slc2.insertAtBegining("one");
//        slc2.show();



    }
}
