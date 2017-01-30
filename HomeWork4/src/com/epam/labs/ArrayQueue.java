package com.epam.labs;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Maryna on 30.01.2017.
 */
public class ArrayQueue {
    Object[] queue;
    int head, tail, capacity, count;
    final static int DEFAULT_CAPACITY = 10;

    public ArrayQueue() {
        queue = new Object[DEFAULT_CAPACITY];
        head = 0;
        tail = 0;
        capacity = DEFAULT_CAPACITY;
        count = 0;
    }

    private void resizeQueue() {
        Object[] copy;

        copy = new Object[queue.length * 2];

        // Copy elements that are logically in the queue
        for (int i = 0; i < count; i++,head++)
            copy[i] = queue[head];

        queue = copy;
        head = 0;
        tail = capacity - 1;
        capacity*=2;
    }

    public void push(Object object) {
        if (count >= capacity)
            resizeQueue();
        count++;
        queue[tail] = object;
        tail++;
    }

    public Object pop() {
        if (isFull() <= 0)
            return null;
        count--;
        Object result = queue[head];
        queue[head] = null;
        head++;
        return result;
    }

    private int isFull() {
        return count;
    }
}
