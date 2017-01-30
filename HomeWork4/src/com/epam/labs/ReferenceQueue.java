package com.epam.labs;

import java.security.PublicKey;

/**
 * Created by Maryna on 30.01.2017.
 */
public class ReferenceQueue {
    private class Item{
        private Object item;
        private Item next;
    }
    private Item head, tail;
    private int count;
    public ReferenceQueue(){
        head=new Item();
        tail=new Item();
    }

    public void push(Object object){
        if(isFull()<=0) {
            head.item= object;
            head.next =tail;
            tail=head;
            count++;
        }
        else {
            Item newTail= new Item();
            newTail.item=object;
            newTail.next=null;
            tail.next = newTail;
            tail= newTail;
            count++;
        }

    }
    public Object pop(){
        if(isFull()<=0){
            return null;
        }
        Object object = head.item;
        head.item= null;
        head= head.next;
        count--;
        return object;
    }
    public int isFull(){
        return count;
    }
}
