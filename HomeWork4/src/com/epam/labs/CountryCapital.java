package com.epam.labs;

/**
 * Created by Maryna on 29.01.2017.
 */
public class CountryCapital implements Comparable<CountryCapital>{
    private String country, capital;
public CountryCapital(String string1, String string2){
    this.country=string1;
    this.capital =string2;
}
    @Override
    public int compareTo(CountryCapital o) {
        return country.compareTo(o.getCountry());
    }

    public String getCountry(){
    return country;
    }
    public String getCapital(){
    return capital;
    }

}
