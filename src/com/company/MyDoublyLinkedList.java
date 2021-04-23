package com.company;

public class MyDoublyLinkedList<T> {

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyDoublyLinkedList(){
    }

    public int getSize(){
        return size;
    }
    public void add(T newItem){
        MyNode<T> newNode = new MyNode<>(newItem);
        if (head == null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T get(int index){
        MyNode<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }


    //   Main Tasks:  //

    public void add(T newItem, int index){
        if(index == 0) { // if it is the first element
            if(head == null) add(newItem);
            else {
                MyNode<T> newNode = new MyNode<>(newItem);
                newNode.next = head;
                head = newNode;
                size++;
            }
        }
        else if(index >= size){ // if index is bigger
            MyNode<T> newNode = new MyNode<>(newItem);
            if(tail == null) head = tail = newNode;
            else {
                tail.next = newNode;
                tail = tail.next;
            }
            size++;
        }
        else{
            MyNode<T> current = head;
            for (int i = 1; i < index; i++) current = current.next;
            MyNode<T> temp = current.next;
            current.next = new MyNode<>(newItem);
            (current.next).next = temp;
            size++;
        }

    }


    public int find(T keyItem){
        MyNode<T> current = head;
        for(int i = 0; i < size; i++){
            if(current.data == keyItem) return i;
            current = current.next;
        }
        return -1;
    }

    public T remove(int index){
        if(index < 0 || index > size) return null;
        else if(index == 0){
            if (size == 0) return null;
            else {
                MyNode<T> temp = head;
                head = head.next;
                size--;
                return temp.data;
            }
        }
        else {
            MyNode<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            T removed = (T) current.next.data;
            current.previous = current.next;
            current.next = current.previous.next;
            size--;
            return removed;
        }
    }


    public void reverse(){
        MyNode<T> temp = null;
        MyNode<T> current = head;
        while (current != null) {
            current.previous = current.next;
            current.next = temp;
            temp = current;

            if (current.previous == null) head = current;
            current = current.previous;
        }

    }

    private static class MyNode<E>{
        E data;
        MyNode<E> next;
        MyNode<E> previous;
        MyNode(E data){ this.data = data;}
    }
}
