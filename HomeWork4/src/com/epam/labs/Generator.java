package com.epam.labs;

import java.util.Random;

/**
 * Created by Maryna on 30.01.2017.
 */
public class Generator {
    String[][] countryCapital;
    Random random = new Random();

    Generator(){
        countryCapital= new String[][]{{"Ukraine", "Kyiv"},{"Russia", "Moscow"}, {"Poland", "Warsaw"}, {"Belarus", "Minsk"}, {"France", "Paris"},
                {"Italy", "Rome"}, {"Spain", "Madrid"},{"Hungary", "Budapest"}, {"Great Britain", "London"}, {"United States of America","Washington"},
                {"Canada","Ottawa"}, {"Brasil","Brasilia"}, {"Portugal","Lisbon"}, {"Greece","Athens"}, {"Turkey","Ankara"}, {"Israel","Jerusalem"}, {"Australia","Sidney"}, {"Japan","Tokyo"}, {"China","Beijing"}};
    }
    public String getCountry(int index){
        return countryCapital[index][0];
    }
    public String getCapital(int index){
        return countryCapital[index][1];
    }
    public CountryCapital getPair(){
        int index=random.nextInt(countryCapital.length);
        return new CountryCapital(getCountry(index), getCapital(index));
    }
}
