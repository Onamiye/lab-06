package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");

    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City ("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));

    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        //This line checks if the first city in the cityList is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        //This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        //Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));

    }

    @Test
    void testhasCity() {
        CityList cityList = mockCityList();
        City old = cityList.getCities().get(0);
        //to check if the list has a city we added
        assertTrue(cityList.hasCity(old));

        City newCity = new City("Fort McMurray", "Alberta");
        //we check if the list has a city we didnt add
        assertFalse(cityList.hasCity(newCity));

        City city = new City("Regina", "Saskatchewan");
        //we check if the list has a city we didnt add
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City deleted = cityList.getCities().get(0);
        cityList.delete(deleted);
        //checks if the deleted city is in the list
        assertFalse(cityList.hasCity(deleted));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        //try to delete a city not in the list
        City missing = new City("Toronto", "Ontario");
        //check if it throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(missing);
        });
    }

    @Test
    void testcountCities() {
        CityList cityList = new CityList();
        //check if the count is 0 if list is empty
        assertEquals(0, cityList.countCities());

        City oneCity = new City("Regina", "Saskatchewan");
        cityList.add(oneCity);
        //check if count is 1 after adding one city
        assertEquals(1, cityList.countCities());

        City aCity = new City("Calgary", "Alberta");
        City anotherCity = new City("Edmonton", "Alberta");
        cityList.add(aCity);
        cityList.add(anotherCity);
        //check if count is three, after adding three cities
        assertEquals(3, cityList.countCities());

        cityList.delete(oneCity);
        //if we delete one city, check if new count updates to reflect 2 cities
        assertEquals(2, cityList.countCities());


    }








}
