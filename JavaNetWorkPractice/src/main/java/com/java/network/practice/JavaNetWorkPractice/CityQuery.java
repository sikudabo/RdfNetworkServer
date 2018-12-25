package com.java.network.practice.JavaNetWorkPractice;

public class CityQuery{


    public String cityName;
    public String typeQuestion = "";
    public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
            "prefix dbr: <http://dbpedia.org/resource/> \n" +
            "prefix dbo: <http://dbpedia.org/ontology/> \n";

    public CityQuery(String cityName) {
        this.cityName = cityName;
    }

    public String nick() {
        String nickQuery = prefixes + "SELECT ?nick WHERE {\n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en .\n" +
                "?city foaf:nick ?nick \n" +
                "}";
        System.out.println("The city name is: " + cityName);
		 /*"SELECT ?birthDate WHERE { \n" +
         "?pres dbo:birthDate ?birthDate .\n" +
         "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
         "}";*/
        this.typeQuestion = "nick";
        return nickQuery;
    }

    public String twinCity() {
        String twinCityQuery = prefixes + "SELECT ?twinCity WHERE {\n" +
                "?city dbo:twinCity ?twinCity . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "twinCity";
        return twinCityQuery;
    }

    public String area() {
        String areaQuery = prefixes + "SELECT ?area WHERE {\n" +
                "?city dbo:area ?area . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "area";
        return areaQuery;
    }

    public String areaTotal() {
        String areaTotalQuery = prefixes + "SELECT ?areaTotal WHERE {\n" +
                "?city dbo:areaTotal ?areaTotal . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "areaTotal";
        return areaTotalQuery;
    }

    public String areaLand() {
        String areaLandQuery = prefixes + "SELECT ?areaLand WHERE {\n" +
                "?city dbo:areaLand ?areaLand . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "areaLand";
        return areaLandQuery;
    }

    public String areaWater() {
        String areaWaterQuery = prefixes + "SELECT ?areaWater WHERE {\n" +
                "?city dbo:areaWater ?areaWater . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "areaWater";
        return areaWaterQuery;
    }

    public String leaderTitle() {
        String leaderTitleQuery = prefixes + "SELECT ?leaderTitle WHERE {\n" +
                "?city dbo:leaderTitle ?leaderTitle . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "leaderTitle";
        return leaderTitleQuery;
    }

    public String leaderName() {
        String leaderNameQuery = prefixes + "SELECT ?leaderName WHERE {\n" +
                "?city dbo:leaderName ?leaderName . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "leaderName";
        return leaderNameQuery;
    }

    public String governmentType() {
        String governmentTypeQuery = prefixes + "SELECT ?governmentType WHERE {\n" +
                "?city dbo:governmentType ?governmentType . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "governmentType";
        return governmentTypeQuery;
    }

    public String populationTotal() {
        String populationTotalQuery = prefixes + "SELECT ?populationTotal WHERE {\n" +
                "?city dbo:populationTotal ?populationTotal . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "populationTotal";
        return populationTotalQuery;
    }

    public String populationDensity() {
        String populationDensityQuery = prefixes + "SELECT ?populationDensity WHERE {\n" +
                "?city dbo:populationDensity ?populationDensity . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "populationDensity";
        return populationDensityQuery;
    }

    public String populationMetro() {
        String populationMetroQuery = prefixes + "SELECT ?populationMetro WHERE {\n" +
                "?city dbo:populationMetro ?populationMetro . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "populationMetro";
        return populationMetroQuery;
    }

    public String populationUrban() {
        String populationUrbanQuery = prefixes + "SELECT ?populationUrban WHERE {\n" +
                "?city dbo:populationUrban ?populationUrban . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "populationUrban";
        return populationUrbanQuery;
    }

    public String isPartOf() {
        String isPartOfQuery = prefixes + "SELECT ?isPartOf WHERE {\n" +
                "?city dbo:isPartOf ?isPartOf . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "isPartOf";
        return isPartOfQuery;
    }

    public String type() {
        String typeQuery = prefixes + "SELECT ?type WHERE {\n" +
                "?city dbo:type ?type . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "type";
        return typeQuery;
    }

    public String timeZone() {
        String timeZoneQuery = prefixes + "SELECT ?timeZone WHERE {\n" +
                "?city dbo:timeZone ?timeZone . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "timeZone";
        return timeZoneQuery;
    }

    public String motto() {
        String mottoQuery = prefixes + "SELECT ?motto WHERE {\n" +
                "?city dbo:motto ?motto . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "motto";
        return mottoQuery;
    }

    public String postalCode() {
        String postalCodeQuery = prefixes + "SELECT ?postalCode WHERE {\n" +
                "?city dbo:postalCode ?postalCode . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "postalCode";
        return postalCodeQuery;
    }

    public String areaCode() {
        String areaCodeQuery = prefixes + "SELECT ?areaCode WHERE {\n" +
                "?city dbo:areaCode ?areaCode . \n" +
                "?city foaf:name " + "\"" + cityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "areaCode";
        return areaCodeQuery;
    }

}
