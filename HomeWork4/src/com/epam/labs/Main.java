package com.epam.labs;


import java.util.*;

public class Main {
    static Generator generator = new Generator();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        for (Menu menu : Menu.values()) {
            System.out.format("%d.) %s\n", menu.getId(), menu.getText());
        }
        int chose = scanner.nextInt();
        switch (chose) {
            case 1:
                testCustonArray();
                break;
            case 2:
                testStringComparator();
                break;
            case 3:
                testCustomQueues();
                testLinkedListQueue();
                testArrayQueue();
                break;

        }
    }

    public static void testCustomQueues() {
        System.out.println("1. Test array based queue\n2. Test linked list based queue\n 3. Test references based queue\n 4. Compare queues");
        int chose = scanner.nextInt();
        switch (chose) {
            case 1:
                testArrayQueue();
                break;
            case 2:
                testLinkedListQueue();
                break;
            case 3:
                testReferenceQueue();
                break;
            case 4:
                compareQueues();
        }

    }
    public static void compareQueues(){
        System.out.println("Array based:");
        ArrayQueue arrayQueue = new ArrayQueue();
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        Random random = new Random(1000);
        long start = System.currentTimeMillis();
        for(int i =0 ; i<1000; i++)
            arrayQueue.push(random.nextInt());

        for(int i =0 ; i<1000; i++)
            arrayQueue.pop();
        System.out.format("Time token: %d\n", System.currentTimeMillis()-start );

    }

    public static void testStringComparator() {
        testArrayListOfCountryCapitalPair();
        testArrayOfCountryCapitalPairs();

    }

    private static void testArrayOfCountryCapitalPairs() {
        StringComparator[] stringComparators = new StringComparator[5];
        for (int i = 0; i < 5; i++)
            stringComparators[i] = generator.getPair();

        System.out.println("\nGenerated array of country-capital pairs:\n");
        for (int i = 0; i < stringComparators.length; i++)
            System.out.println(stringComparators[i].getString1() + stringComparators[i].getString2());

        Arrays.sort(stringComparators);

        System.out.println("\nSorted array of country-capital pairs by country:\n");
        for (int i = 0; i < stringComparators.length; i++)
            System.out.println(stringComparators[i].getString1() + " " + stringComparators[i].getString2());

        Arrays.sort(stringComparators, new CustomComparator());
        System.out.println("\nSorted array of country-capital pairs by capital:\n");

        for (int i = 0; i < stringComparators.length; i++)
            System.out.println(stringComparators[i].getString1() + " " + stringComparators[i].getString2());

        StringComparator key = new StringComparator("124", "123");

        System.out.println("\nEnter some country or capital from the list above");
        scanner.next();
        String city = scanner.nextLine();
        key = new StringComparator("", city);
        int index = Arrays.binarySearch(stringComparators, key, new CustomComparator());
        if (index >= 0)
            System.out.format("\n%s is the capital of %s\n", city, stringComparators[index].getString1());
            // System.out.println(stringComparators[index].getString1() + " " + stringComparators[index].getString2());
        else {
            key = new StringComparator(city, "");
            index = Arrays.binarySearch(stringComparators, key);
            if (index >= 0)
                System.out.format("\n%s has capital -  %s\n", city, stringComparators[index].getString2());
            else
                System.out.println("binary search failed");
        }
    }


    private static void testArrayListOfCountryCapitalPair() {
        ArrayList<StringComparator> arrayList = new ArrayList(5);

        for (int i = 0; i < 5; i++)
            arrayList.add(generator.getPair());
        System.out.println("ArrayList of country-capital pairs sorted by country\n");
        Collections.sort(arrayList);
        for (StringComparator stringCompar :
                arrayList) {
            System.out.format("%s - %s\n", stringCompar.getString1(), stringCompar.getString2());
        }
        Collections.sort(arrayList, new CustomComparator());

        System.out.println("\nArrayList of country-capital pairs sorted by city\n");
        for (StringComparator stringCompar :
                arrayList) {
            System.out.format("%s - %s\n", stringCompar.getString1(), stringCompar.getString2());
        }

    }

    public static void testCustonArray() {
        CustomArrayList customArrayList = new CustomArrayList(5);
        for (int i = 0; i < customArrayList.getCapacity(); i++)
            customArrayList.addString(generator.getCapital(i));
        customArrayList.addString("Lviv");
        customArrayList.addString("Ternopil");
        customArrayList.addString("Khmelnytskyi");
        customArrayList.addString("Rivne", 7);
        System.out.println("Custom array of strings:\n");
        for (int i = 0; i < customArrayList.size(); i++)
            System.out.println(customArrayList.getString(i));
    }

    public static void testLinkedListQueue() {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.push(generator.getCountry(0));
        linkedListQueue.push(generator.getCountry(1));
        linkedListQueue.push(generator.getCountry(2));


        System.out.println("\nCustom queue:\n");
        while (linkedListQueue.isFull() > 0)
            System.out.println(linkedListQueue.pop());

    }

    public static void testArrayQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.push(3);
        arrayQueue.push(4);
        arrayQueue.push(5);
        arrayQueue.push(6);
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());

    }

    public static void testReferenceQueue() {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        referenceQueue.push(7);
        referenceQueue.push(8);
        referenceQueue.push(9);

        System.out.println(referenceQueue.pop());
        System.out.println(referenceQueue.pop());
        System.out.println(referenceQueue.pop());
        System.out.println(referenceQueue.pop());
    }


}
