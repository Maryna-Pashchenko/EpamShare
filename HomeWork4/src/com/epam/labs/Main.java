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
        for(int i =0 ; i<1000000; i++)
            arrayQueue.push(random.nextInt());

        for(int i =0 ; i<1000000; i++)
            arrayQueue.pop();
        System.out.format("Time token: %d\n", System.currentTimeMillis()-start );

        System.out.println("LinkedList based:");
         start = System.currentTimeMillis();
        for(int i =0 ; i<1000000; i++)
            linkedListQueue.push(random.nextInt());

        for(int i =0 ; i<1000000; i++)
            linkedListQueue.pop();
        System.out.format("Time token: %d\n", System.currentTimeMillis()-start );

        System.out.println("References based:");
        start = System.currentTimeMillis();
        for(int i =0 ; i<1000000; i++)
            referenceQueue.push(random.nextInt());

        for(int i =0 ; i<1000000; i++)
            referenceQueue.pop();
        System.out.format("Time token: %d\n", System.currentTimeMillis()-start );

    }

    public static void testStringComparator() {
        System.out.println(" 1. Test ArrayList of country-capital pairs\n 2. Test array of country-capital pairs\n");
        int chose = scanner.nextInt();
        switch (chose){
            case 1:
                testArrayListOfCountryCapitalPair();
                break;
            case 2:
                testArrayOfCountryCapitalPairs();
                break;
        }
    }

    private static void testArrayOfCountryCapitalPairs() {
        CountryCapital[] countryCapitals = new CountryCapital[5];
        for (int i = 0; i < 5; i++)
            countryCapitals[i] = generator.getPair();

        System.out.println("\nGenerated array of country-capital pairs:\n");
        for (int i = 0; i < countryCapitals.length; i++)
            System.out.format("%s - %s\n", countryCapitals[i].getCountry(), countryCapitals[i].getCapital());

        Arrays.sort(countryCapitals);

        System.out.println("\nSorted array of country-capital pairs by country:\n");
        for (int i = 0; i < countryCapitals.length; i++)
            System.out.format("%s - %s\n", countryCapitals[i].getCountry(), countryCapitals[i].getCapital());

        Arrays.sort(countryCapitals, new CustomComparator());
        System.out.println("\nSorted array of country-capital pairs by capital:\n");

        for (int i = 0; i < countryCapitals.length; i++)
            System.out.format("%s - %s\n", countryCapitals[i].getCountry(), countryCapitals[i].getCapital());

        CountryCapital key;
        System.out.println("\nEnter some country or capital from the list above");
        scanner.next();
        String city = scanner.nextLine();
        key = new CountryCapital("", city);
        int index = Arrays.binarySearch(countryCapitals, key, new CustomComparator());
        if (index >= 0)
            System.out.format("\n%s is the capital of %s\n", city, countryCapitals[index].getCountry());
        else {
            key = new CountryCapital(city, "");
            index = Arrays.binarySearch(countryCapitals, key);
            if (index >= 0)
                System.out.format("\n%s has capital -  %s\n", city, countryCapitals[index].getCapital());
            else
                System.out.println("binary search failed");
        }
    }

    private static void testArrayListOfCountryCapitalPair() {
        ArrayList<CountryCapital> arrayList = new ArrayList(5);

        for (int i = 0; i < 5; i++)
            arrayList.add(generator.getPair());
        System.out.println("ArrayList of country-capital pairs sorted by country\n");
        Collections.sort(arrayList);
        for (CountryCapital stringCompar :
                arrayList) {
            System.out.format("%s - %s\n", stringCompar.getCountry(), stringCompar.getCapital());
        }
        Collections.sort(arrayList, new CustomComparator());

        System.out.println("\nArrayList of country-capital pairs sorted by city\n");
        for (CountryCapital stringCompar :
                arrayList) {
            System.out.format("%s - %s\n", stringCompar.getCountry(), stringCompar.getCapital());
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
