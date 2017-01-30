package com.epam.labs;

/**
 * Created by Maryna on 28.01.2017.
 */
public class CustomArrayList {
    private String[] array;
    private int size, capacity;

    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        array = new String[capacity];
    }

    public String getString(int index) {
        return array[index];
    }

    public void addString(String newString) {
        if (size() >= capacity)
            resizeList(capacity*2);
        array[size++] = newString;

    }
    public void addString(String newString, int index) {
        if (size() >= capacity)
            resizeList(capacity*2);
        if(index>capacity)
            resizeList(index*2);
        String[] arrayCopy= new String[size-index];
        for(int i=index, j=0; i<size;i++,j++)
            arrayCopy[j]=array[i];
        array[index]=newString;
        size++;
        for(int i=index+1, j=0; i<size;i++,j++)
            array[i]= arrayCopy[j];
    }

    private void resizeList(int newSize) {
        String[] copyArray= array.clone();
        array = new String[newSize];
        capacity=newSize;
        for(int i=0; i<copyArray.length;i++)
        array[i] = copyArray[i];
    }

    public int size() {
        return size;
    }
    public int getCapacity(){
        return capacity;
    }
}
