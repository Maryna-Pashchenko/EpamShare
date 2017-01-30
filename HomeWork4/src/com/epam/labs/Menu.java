package com.epam.labs;

/**
 * Created by Maryna on 28.01.2017.
 */
public enum Menu {

    item1(1, "Test custom ArrayList"), item2(2, "Test String comparator")
    , item3(3, "Test custom queue");
    private int id;
    private String text;

    Menu(int id, String text){
        this.id = id;
        this.text=text;
    }

    public int getId(){
        return id;
    }
    public String getText(){
        return text;
    }
}