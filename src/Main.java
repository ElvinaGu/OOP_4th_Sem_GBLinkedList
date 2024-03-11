import gb_collections.GBList;
import gb_collections.lists.GBArrayList;
import gb_collections.lists.GBLinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

//        GBList<Integer> list = new GBArrayList<>();
//
//        System.out.println(list.size());
//        list.add(7);
//        list.add(3);
//        list.add(72);
//        list.add(17);
//        list.add(7);
//        list.add(3);
//        list.add(72);
//        list.add(17);
//        list.add(7);
//        list.add(3);
//        list.add(72);
//        list.add(17);
//        list.add(7);
//        list.add(3);
//        list.add(72);
//        list.add(17);
//
//        System.out.println(list);
//
//        list.removeByIndex(2);
//        System.out.println(list);
//        list.remove(3);
//        System.out.println(list);
//        System.out.println(list.get(5));

        GBLinkedList<Integer> r = new GBLinkedList<>();
        r.add(9);
        r.add(7);
        r.add(5);
        r.add(3);
        r.add(53);
        System.out.println(r);
        r.removeByIndex(2);
        System.out.println(r);


    }
}