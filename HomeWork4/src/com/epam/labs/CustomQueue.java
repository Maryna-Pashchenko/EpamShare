package com.epam.labs;

import javax.management.Query;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by Maryna on 28.01.2017.
 */
public class CustomQueue {
    private LinkedList<Object> linkedList;
    private int head, tail, count;

    public CustomQueue(){
        linkedList = new LinkedList<Object>();
        count=0;
    }

    public Object pop() {
        Object object =  linkedList.getFirst();
        linkedList.remove(0);
        head++;
        count--;
        return object;
    }
    public void push(Object object){
        linkedList.add(object);
        tail++;
        count++;
    }
    public int size(){
        return count;
    }
    public int isFull(){
        return count;
    }
}
