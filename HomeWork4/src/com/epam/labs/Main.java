package com.epam.labs;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        CustomArrayList customArrayList = new CustomArrayList(5);
        customArrayList.addString("gjjk");
        customArrayList.addString("gjjnmk");
        customArrayList.addString("gjjk");
        customArrayList.addString("gjjk");
        customArrayList.addString("gjnbjk");
        customArrayList.addString("gjnbjkmm");
        customArrayList.addString("gjnbjkdfsmm");
        for (int i = 0; i < customArrayList.size(); i++)
            System.out.println(customArrayList.getString(i));


        CustomQueue customQueue = new CustomQueue();
        customQueue.push("desfa");
        customQueue.push("deawcasfa");
        customQueue.push("dddscesfa");

        while (customQueue.isFull() > 0)
            System.out.println(customQueue.pop());
        StringComparator[] stringComparators = new StringComparator[4];
        stringComparators[0] = new StringComparator("kfsd", "efdefd");
        stringComparators[1] = new StringComparator("afgfsd", "efdefd");
        stringComparators[2] = new StringComparator("aadfgfsd", "efdefd");
        stringComparators[3] = new StringComparator("Ukraine", "Lviv");
        for (int i = 0; i < stringComparators.length; i++)
            System.out.println(stringComparators[i].getString1() + stringComparators[i].getString2());


        Arrays.sort(stringComparators);
        for (int i = 0; i < stringComparators.length; i++)
            System.out.println(stringComparators[i].getString1() + " " + stringComparators[i].getString2());


        Arrays.sort(stringComparators, new CustomComparator());
        System.out.println("Sorted with custom comparator");

        for (int i = 0; i < stringComparators.length; i++)
            System.out.println(stringComparators[i].getString1() + " " + stringComparators[i].getString2());

        StringComparator key = new StringComparator("124", "123");
        String city = scanner.nextLine();
        key = new StringComparator("", city);
        int index = Arrays.binarySearch(stringComparators, key, new CustomComparator());
        if (index >= 0)
            System.out.println(stringComparators[index].getString1() + " " + stringComparators[index].getString2());
        else
            System.out.println("binary search failed");
    }


}
