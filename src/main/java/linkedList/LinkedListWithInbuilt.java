package linkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListWithInbuilt {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);
        list.addFirst(40);
        System.out.println(list);
        list.addLast(50);
        System.out.println(list);
    }
}
