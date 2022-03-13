package com.anma.java.core.factory;

public class BuilderExe {
    public static void main(String[] args) {

//        CityWeb.Builder builder = new CityWeb.Builder();
    }
}

class CityWeb {

    private long id;
    private String name;
    private String code;
    private String continent;
    private long population;

    class Builder {
        Builder builder = new Builder();
        CityWeb cityWeb = new CityWeb();

        CityWeb build() {
            return cityWeb;
        }

        Builder id(long id) {
            cityWeb.setId(id);
            return builder;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

}
