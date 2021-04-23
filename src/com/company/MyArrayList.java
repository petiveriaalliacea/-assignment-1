package com.company;

import java.util.Iterator;

public class MyArrayList<T> {
    private Object[] array;
    private int size = 0;
    private int capacity = 10;

    public  MyArrayList(){
        array = new Object[capacity];
    }

    public int getSize(){
        return size;
    }

    public void add(T newItem){
        if (size == capacity){
            increaseBuffer();
        }
        array[size++] = newItem;
    }

    public T take(int index){
        return (T) array[index];
    }

    public void increaseBuffer(){
        capacity = (int) (1.5 * capacity);
        Object[] array2 = new Object[capacity];
        for (int i = 0; i < size; i++){
            array2[i] = array[i];
        }
        array = array2;
    }




    //   Main Tasks:  //


    public void add(T newItem, int index){
        if (size == capacity){
            increaseBuffer();
        }
        for (int i = size; i > index; i--){
            array[i] = array[i - 1];
        }
        size++;
        array[index] = newItem;
    }


    public int find(T keyItem){
        for(int i = 0; i < size; i++){
            if(keyItem == array[i]) return i;
        }
        return -1;
    }

    public T remove(int index){
        T removed = (T) array[index];
        for (int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
        return removed;
    }

    public void reverse(){
        Object[] array2 = new Object[capacity];
        int indexOfArr2 = 0;
        for (int i = size - 1; i >= 0; i--){
            array2[indexOfArr2] = array[i];
            indexOfArr2++;
        }
        array = array2;
    }



}
