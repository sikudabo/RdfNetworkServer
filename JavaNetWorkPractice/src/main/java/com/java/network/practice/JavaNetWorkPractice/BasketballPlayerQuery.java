package com.java.network.practice.JavaNetWorkPractice;

public class BasketballPlayerQuery{


    public String basketballplayerName;
    public String typeQuestion = "";
    public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
            "prefix dbr: <http://dbpedia.org/resource/> \n" +
            "prefix dbo: <http://dbpedia.org/ontology/> \n";

    public BasketballPlayerQuery(String basketballplayerName) {
        this.basketballplayerName = basketballplayerName;
    }

    

	public String number() {
        String numberQuery = prefixes + "SELECT ?number WHERE {\n" +
                "?basketballplayer dbo:number ?number . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "number";
        return numberQuery;
    }

    public String birthDate() {
        String birthDateQuery = prefixes + "SELECT ?birthDate WHERE {\n" +
                "?basketballplayer dbo:birthDate ?birthDate . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "birthDate";
        return birthDateQuery;
    }

    public String birthPlace() {
        String birthPlaceQuery = prefixes + "SELECT ?birthPlace WHERE {\n" +
                "?basketballplayer dbo:birthPlace ?birthPlace . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "birthPlace";
        return birthPlaceQuery;
    }

    public String deathPlace() {
        String deathPlaceQuery = prefixes + "SELECT ?deathPlace WHERE {\n" +
                "?basketballplayer dbo:deathPlace ?deathPlace . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "deathPlace";
        return deathPlaceQuery;
    }

    public String deathDate() {
        String deathDateQuery = prefixes + "SELECT ?deathDate WHERE {\n" +
                "?basketballplayer dbo:deathDate ?deathDate . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "deathDate";
        return deathDateQuery;
    }

    public String draftTeam() {
        String draftTeamQuery = prefixes + "SELECT ?draftTeam WHERE {\n" +
                "?basketballplayer dbo:draftTeam ?draftTeam . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "draftTeam";
        return draftTeamQuery;
    }

    public String position() {
        String positionQuery = prefixes + "SELECT ?position WHERE {\n" +
                "?basketballplayer dbo:position ?position . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "position";
        return positionQuery;
    }

    public String height() {
        String heightQuery = prefixes + "SELECT ?height WHERE {\n" +
                "?basketballplayer dbo:height ?height . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "height";
        return heightQuery;
    }

    public String weight() {
        String weightQuery = prefixes + "SELECT ?weight WHERE {\n" +
                "?basketballplayer dbo:weight ?weight . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "weight";
        return weightQuery;
    }

    public String activeYearsStartYear() {
        String activeYearsStartYearQuery = prefixes + "SELECT ?activeYearsStartYear WHERE {\n" +
                "?basketballplayer dbo:activeYearsStartYear ?activeYearsStartYear . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "activeYearsStartYear";
        return activeYearsStartYearQuery;
    }

    public String activeYearsEndYear() {
        String activeYearsEndYearQuery = prefixes + "SELECT ?activeYearsEndYear WHERE {\n" +
                "?basketballplayer dbo:activeYearsEndYear ?activeYearsEndYear . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "activeYearsEndYear";
        return activeYearsEndYearQuery;
    }

    public String college() {
        String collegeQuery = prefixes + "SELECT ?college WHERE {\n" +
                "?basketballplayer dbo:college ?college . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "college";
        return collegeQuery;
    }

    public String team() {
        String teamQuery = prefixes + "SELECT ?team WHERE {\n" +
                "?basketballplayer dbo:team ?team . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "team";
        return teamQuery;
    }

    public String draftYear() {
        String draftYearQuery = prefixes + "SELECT ?draftYear WHERE {\n" +
                "?basketballplayer dbo:draftYear ?draftYear . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "draftYear";
        return draftYearQuery;
    }

    public String award() {
        String awardQuery = prefixes + "SELECT ?award WHERE {\n" +
                "?basketballplayer dbo:award ?award . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "award";
        return awardQuery;
    }

    public String abStract() {
        String abStractQuery = prefixes + "SELECT ?abstract WHERE {\n" +
                "?basketballplayer dbo:abstract ?abstract . \n" +
                "?basketballplayer foaf:name " + "\"" + basketballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "abstract";
        return abStractQuery;
    }




}

