package com.epam.labs;

import java.util.Comparator;

/**
 * Created by Maryna on 29.01.2017.
 */
public class CustomComparator implements Comparator<CountryCapital> {
    @Override
    public int compare(CountryCapital o1, CountryCapital o2) {
        return o1.getCapital().compareTo(o2.getCapital());
    }
}
