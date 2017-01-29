package com.epam.labs;

import java.util.Comparator;

/**
 * Created by Maryna on 29.01.2017.
 */
public class StringComparator implements Comparable<StringComparator>, Comparator<StringComparator> {
    private String string1, string2;
public StringComparator(String string1, String string2){
    this.string1=string1;
    this.string2=string2;
}
public StringComparator(){}

    @Override
    public int compareTo(StringComparator o) {
        return string1.compareTo(o.getString1());
    }

    public String getString1(){
    return string1;
    }
    public String getString2(){
    return string2;
    }

    @Override
    public int compare(StringComparator o1, StringComparator o2) {
        return o1.getString2().compareTo(o2.getString2());
    }
}
