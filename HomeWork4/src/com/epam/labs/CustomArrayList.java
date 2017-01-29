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
            resizeList(size + 1);
        array[size++] = newString;

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
}
