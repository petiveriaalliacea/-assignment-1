package com.company;


public class Main {


    public static void main(String[] args) {
        System.out.println("\nMyArrayList\n");
        MyArrayList<Integer> list = new MyArrayList<>();
        for(int i = 1; i < 11; i++){
            list.add(i);
        }

        System.out.println("Before:");
        for (int i = 0; i < list.getSize(); i++){
            System.out.println(list.take(i));
        }
        list.add(63,4);
        System.out.println("Find element: " +list.find(12));

        System.out.println("Removed item: " + list.remove(1));
        list.reverse();

        System.out.println("After:");
        for (int i = 0; i < list.getSize(); i++){
            System.out.println(list.take(i));
        }



        System.out.println("\nMyLinkedList:\n");
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        for(int i = 11; i < 21; i++){
            list2.add(i);
        }

        System.out.println("Before:");
        for (int i = 0; i < list2.getSize(); i++){
            System.out.println(list2.get(i));
        }

        list2.add(63,4);

        System.out.println("Find element: " + list2.find(12));

        System.out.println("Removed item: " + list2.remove(1));
        list2.reverse();

        System.out.println("\nAfter:");
        for (int i = 0; i < list2.getSize(); i++){
            System.out.println(list2.get(i));
        }



        //   Additional task   //

        System.out.println("\nMyDoubleLinkedList:\n");
        MyDoublyLinkedList<Integer> list3 = new MyDoublyLinkedList<>();
        for(int i = 21; i < 31; i++){
            list3.add(i);
        }

        System.out.println("Before:");
        for (int i = 0; i < list3.getSize(); i++){
            System.out.println(list3.get(i));
        }

        list3.add(63,4);

        System.out.println("Find element: " + list3.find(12));

        System.out.println("Removed item: " + list3.remove(1));
        list3.reverse();

        System.out.println("\nAfter:");
        for (int i = 0; i < list3.getSize(); i++){
            System.out.println(list3.get(i));
        }


    }
}
