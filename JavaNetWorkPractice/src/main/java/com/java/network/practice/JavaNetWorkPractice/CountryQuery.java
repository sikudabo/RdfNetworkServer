package com.java.network.practice.JavaNetWorkPractice;

public class CountryQuery{


    public String countryName;
    public String typeQuestion = "";
    public final String prefixes = "PREFIX dbo: <http://dbpedia.org/ontology/> \n" +
            "PREFIX foaf: <http://xmlns.com/foaf/0.1/> \n";

    public CountryQuery(String countryName) {
        this.countryName = countryName;
    }



    public String capital() {
        System.out.println("Country name is: " + countryName);
        String capitalQuery = prefixes + "SELECT ?capital WHERE{ \n" +
                "?country foaf:name " + "\"" + countryName.toLowerCase().trim() + "\"" + "@en .\n" +
                "?country dbo:capital ?capital \n" +
                "}";


        this.typeQuestion = "capital";
        return capitalQuery;
    }

    public String language() {
        String languageQuery = prefixes + "SELECT ?language WHERE{ \n" +
                "?country foaf:name " + "\"" + countryName.toLowerCase().trim() + "\"" + "@en .\n" +
                "?country dbo:language ?language \n" +
                "}";


        this.typeQuestion = "language";
        return languageQuery;
    }

    public String currency() {
        String currencyQuery = prefixes + "SELECT ?currency WHERE {\n" +
                "?country dbo:currency ?currency . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "currency";
        return currencyQuery;
    }

    public String anthem() {
        String anthemQuery = prefixes + "SELECT ?anthem WHERE {\n" +
                "?country dbo:anthem ?anthem . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "anthem";
        return anthemQuery;
    }

    public String demonym() {
        String demonymQuery = prefixes + "SELECT ?demonym WHERE {\n" +
                "?country dbo:demonym ?demonym . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "demonym";
        return demonymQuery;
    }

    public String leaderName() {
        String leaderNameQuery = prefixes + "SELECT ?leaderName WHERE {\n" +
                "?country dbo:leaderName ?leaderName . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "leaderName";
        return leaderNameQuery;
    }

    public String leaderTitle() {
        String leaderTitleQuery = prefixes + "SELECT ?leaderTitle WHERE {\n" +
                "?country dbo:leaderTitle ?leaderTitle . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "leaderTitle";
        return leaderTitleQuery;
    }

    public String longName() {
        String longNameQuery = prefixes + "SELECT ?longName WHERE {\n" +
                "?country dbo:longName ?longName . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "longName";
        return longNameQuery;
    }

    public String foundingDate() {
        String foundingDateQuery = prefixes + "SELECT ?foundingDate WHERE {\n" +
                "?country dbo:foundingDate ?foundingDate . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "foundingDate";
        return foundingDateQuery;
    }

    public String areaTotal() {
        String areaTotalQuery = prefixes + "SELECT ?areaTotal WHERE {\n" +
                "?country dbo:areaTotal ?areaTotal . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "areaTotal";
        return areaTotalQuery;
    }

    public String percentageOfAreaWater() {
        String percentageOfAreaWaterQuery = prefixes + "SELECT ?percentageOfAreaWater WHERE {\n" +
                "?country dbo:percentageOfAreaWater ?percentageOfAreaWater . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "percentageOfAreaWater";
        return percentageOfAreaWaterQuery;
    }

    public String populationDensity() {
        String populationDensityQuery = prefixes + "SELECT ?populationDensity WHERE {\n" +
                "?country dbo:populationDensity ?populationDensity . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "populationDensity";
        return populationDensityQuery;
    }



    public String governmentType() {
        String governmentTypeQuery = prefixes + "SELECT ?governmentType WHERE {\n" +
                "?country dbo:governmentType ?governmentType . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "governmentType";
        return governmentTypeQuery;
    }

    public String largestCity() {
        String largestCityQuery = prefixes + "SELECT ?largestCity WHERE {\n" +
                "?country dbo:largestCity ?largestCity . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "largestCity";
        return largestCityQuery;
    }

    public String motto() {
        String mottoQuery = prefixes + "SELECT ?motto WHERE {\n" +
                "?country dbo:motto ?motto . \n" +
                "?country foaf:name " + "\"" + countryName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "motto";
        return mottoQuery;
    }

}
