package com.company;

public class MyLinkedList<T> {

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){

    }

    public int getSize(){
        return size;
    }

    public void add(T newItem){
        MyNode<T> newNode = new MyNode<>(newItem);
        if(head == null){
            head = tail = newNode;
        }else{
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
        if(index == 0) {
            if(head == null) add(newItem);
            else {
                MyNode<T> newNode = new MyNode<>(newItem);
                newNode.next = head;
                head = newNode;
                size++;
            }
        }
        else if(index >= size){
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
            MyNode<T> previous = head;
            T removed;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            MyNode<T> current = previous.next;
            previous.next = current.next;
            size--;
            return current.data;
        }
    }

    public void reverse(){
        tail = head;
        MyNode<T> prev = null;
        MyNode<T> current = head;
        while (current != null){
            MyNode<T> next = current.next;
            current.next = prev;
            prev = current;

            if (next == null)
                head = current;
            current = next;
        }
    }


    static class MyNode<E> {
        E data;
        MyNode<E> next;
        MyNode(E data){
            this.data = data;
        }
    }

}
