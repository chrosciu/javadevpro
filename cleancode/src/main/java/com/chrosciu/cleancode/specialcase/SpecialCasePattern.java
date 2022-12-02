package com.chrosciu.cleancode.specialcase;

import java.util.ArrayList;
import java.util.List;

class City {
    public static final City NULL = new City("", 0);

    private final String name;
    private final int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}



class CityQuery {
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Krakow", 1000000));
        cities.add(City.NULL);
        cities.add(new City("Katowice", 300000));
        return cities;
    }
}

public class SpecialCasePattern {
    public static void main(String[] args) {
        CityQuery cityQuery = new CityQuery();
        int totalPopulation = 0;
        List<City> cities = cityQuery.getCities();
        for (City c: cities) {
            totalPopulation += c.getPopulation();
        }
        System.out.println(totalPopulation);
    }
}
