package com.company;

import java.util.Arrays;

public class DynamicArray {


    int[] array;
    int counter;

    // default constructor (without params);
    public DynamicArray(){
        array = new int[4];
        counter = 0;
    }

    public void add(int value){
        if(array.length == counter){
            createBiggerArray();
        }
        array[counter++] = value;

    }

    public void add(int index, int value){
        if(index >= counter){
            throw new IndexOutOfBoundsException();  // like return it stops the method.
        }
        if(array.length == counter){
            createBiggerArray();
        }
        for (int i = 0; i < (counter-index); i++) {//[3,5,44,2,12,32] counter=6  index =3
            array[counter-i] = array[counter-1-i];
        }
        array[index] = value;
        counter++;
    }

    public  void set(int index , int value){
        if(index >= counter){
            throw new IndexOutOfBoundsException();  // like return it stops the method.
        }
        array[index] =value;

    }

    public void clear(){
        counter=0;
    }

    public  boolean contains(int value){
        for (int i = 0; i < counter; i++) {
            if(array[i]==value){
                return true;
            }
        }
        return false;
    }

    public  int indexOf(int value){
        for (int i = 0; i < counter; i++) {
            if(array[i]==value){
                return i;
            }
        }
        return -1;
    }

    public  int get(int index){
        if(index<counter){
          return (array[index]);
        }
        return 0;
    }

    public void remove(int index){
        if(index >= counter||index<0){
            throw new IndexOutOfBoundsException();  // like return it stops the method.
        }

            for (int i = 0; i < counter-index; i++) {
                array[index+i] = array[index+i+1];
            }
            counter--;

    }


    public  void addAll(DynamicArray arr){

        for (int i = 0; i < arr.counter; i++) {
            add(arr.array[i]);
        }

    }

    public  boolean isEmpty(){
        if(counter==0){
            return true;
        }
        return false;
    }
    public int size(){
        return counter;
    }

    public void createBiggerArray(){
        // create an array with twice the space;
        int[] temp = new int[counter * 2];
        // copy the values from original array to new array;
        for(int i = 0; i < counter; i++){
            temp[i] = array[i];
        }
        // call the new array "array";
        array = temp;
    }

    public void printArray(){
        //System.out.println("[20,50,-5,7,12]");
        System.out.print("[");
        for(int i = 0; i < counter; i++){
            System.out.print(array[i]);
            if(i < counter - 1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }



}
