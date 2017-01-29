package com.epam.labs;

import java.util.Comparator;

/**
 * Created by Maryna on 29.01.2017.
 */
public class CustomComparator implements Comparator<StringComparator> {
    @Override
    public int compare(StringComparator o1, StringComparator o2) {
        return o1.getString2().compareTo(o2.getString2());
    }
}
