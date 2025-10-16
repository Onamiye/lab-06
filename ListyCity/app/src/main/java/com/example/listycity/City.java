package com.example.listycity;

/**
* This is a class that defines city and province
*/
public class City implements Comparable<City>{
    /**
     * The city field is defined as a string
     */
    public String city;
    /**
     * The province field is defined as a string
     */
    public String province;

    /**
     * The constructor takes in two parameters, city and province
     */
    City (String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * The following methods return the city
    */
    String getCityName(){
        return this.city;
    }


    /**
     * The following methods return the province
    */
    String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo (City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}
