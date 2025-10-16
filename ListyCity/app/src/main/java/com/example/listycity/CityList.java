package com.example.listycity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {

    /**
     * This is the constructor for the class
     */
    CityList() {

    }
    /**
     * This is a list of cities
     */

    private List<City> cities = new ArrayList<>();



    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *  This is a candidate city to add
     */

    public void add(City city){
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This checks if a city has already been added to the list or not
     * @param city
     *  This is the city we want to check
     * @return boolean
     * True if the city exists in the list, false if not
     */

    public boolean hasCity(City city){
        return cities.contains(city);
    }


    /**
     * This deletes a city from the list and throws an exception if the city does not exist
     * @param city
     *  This is the city we want to delete
     */

    public void delete(City city){
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not here");
        }
        cities.remove(city);
    }

    /**
     * This counts how many cities are on the list
     * @return count
     * returns the count of cities
     */

    public int countCities(){
        return cities.size();
    }



    /**
     * This returns a sorted list of cities
     * @return
     *  Return the sorted list
     */

    public List<City> getCities(){
        List<City>list = cities;
        Collections.sort(list);
        return list;
    }

}
