package com.java.network.practice.JavaNetWorkPractice;

public class StateQuery{


    public String stateName;
    public String typeQuestion = "";
    public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
            "prefix dbr: <http://dbpedia.org/resource/> \n" +
            "prefix dbo: <http://dbpedia.org/ontology/> \n";

    public StateQuery(String stateName) {
        this.stateName = stateName;
    }

    public String abStract() {
        String abstractQuery = prefixes + "SELECT ?abstract WHERE {\n" +
                "?state dbo:abstract ?abstract . \n" +
                "?state foaf:name " + "\"" + stateName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "abstract";
        return abstractQuery;
    }

    public String demonym() {
        String demonymQuery = prefixes + "SELECT ?demonym WHERE {\n" +
                "?state dbo:demonym ?demonym . \n" +
                "?state foaf:name " + "\"" + stateName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "demonym";
        return demonymQuery;
    }

    public String largestCity() {
        String largestCityQuery = prefixes + "SELECT ?largestCity WHERE {\n" +
                "?state dbo:largestCity ?largestCity . \n" +
                "?state foaf:name " + "\"" + stateName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "largestCity";
        return largestCityQuery;
    }

    public String capital() {
        String capitalQuery = prefixes + "SELECT ?capital WHERE {\n" +
                "?state dbo:capital ?capital . \n" +
                "?state foaf:name " + "\"" + stateName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "capital";
        return capitalQuery;
    }

    public String country() {
        String countryQuery = prefixes + "SELECT ?country WHERE {\n" +
                "?state dbo:country ?country . \n" +
                "?state foaf:name " + "\"" + stateName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "country";
        return countryQuery;
    }

    public String areaTotal() {
        String areaTotalQuery = prefixes + "SELECT ?areaTotal WHERE {\n" +
                "?state dbo:areaTotal ?areaTotal . \n" +
                "?state foaf:name " + "\"" + stateName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "areaTotal";
        return areaTotalQuery;
    }

    public String language() {
        String languageQuery = prefixes + "SELECT ?language WHERE {\n" +
                "?state dbo:language ?language . \n" +
                "?state foaf:name " + "\"" + stateName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "language";
        return languageQuery;
    }

}
