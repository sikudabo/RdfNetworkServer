package com.java.network.practice.JavaNetWorkPractice;

public class AmericanFootballPlayerQuery{


    public String americanfootballplayerName;
    public String typeQuestion = "";
    public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
            "prefix dbr: <http://dbpedia.org/resource/> \n" +
            "prefix dbo: <http://dbpedia.org/ontology/> \n";

    public AmericanFootballPlayerQuery(String americanfootballplayerName) {
        this.americanfootballplayerName = americanfootballplayerName;
    }

    public String abStract() {
        String abStractQuery = prefixes + "SELECT ?abstract WHERE {\n" +
                "?americanfootballplayer dbo:abstract ?abstract . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "abstract";
        return abStractQuery;
    }

    public String birthDate() {
        String birthDateQuery = prefixes + "SELECT ?birthDate WHERE {\n" +
                "?americanfootballplayer dbo:birthDate ?birthDate . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "birthDate";
        return birthDateQuery;
    }

    public String birthPlace() {
        String birthPlaceQuery = prefixes + "SELECT ?birthPlace WHERE {\n" +
                "?americanfootballplayer dbo:birthPlace ?birthPlace . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "birthPlace";
        return birthPlaceQuery;
    }

    public String deathDate() {
        String deathDateQuery = prefixes + "SELECT ?deathDate WHERE {\n" +
                "?americanfootballplayer dbo:deathDate ?deathDate . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "deathDate";
        return deathDateQuery;
    }

    public String deathPlace() {
        String deathPlaceQuery = prefixes + "SELECT ?deathPlace WHERE {\n" +
                "?americanfootballplayer dbo:deathPlace ?deathPlace . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "deathPlace";
        return deathPlaceQuery;
    }

    public String activeYearsStartYear() {
        String activeYearsStartYearQuery = prefixes + "SELECT ?activeYearsStartYear WHERE {\n" +
                "?americanfootballplayer dbo:activeYearsStartYear ?activeYearsStartYear . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "activeYearsStartYear";
        return activeYearsStartYearQuery;
    }

    public String activeYearsEndYear() {
        String activeYearsEndYearQuery = prefixes + "SELECT ?activeYearsEndYear WHERE {\n" +
                "?americanfootballplayer dbo:activeYearsEndYear ?activeYearsEndYear . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "activeYearsEndYear";
        return activeYearsEndYearQuery;
    }

    public String draftYear() {
        String draftYearQuery = prefixes + "SELECT ?draftYear WHERE {\n" +
                "?americanfootballplayer dbo:draftYear ?draftYear . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "draftYear";
        return draftYearQuery;
    }

    public String draftRound() {
        String draftRoundQuery = prefixes + "SELECT ?draftRound WHERE {\n" +
                "?americanfootballplayer dbo:draftRound ?draftRound . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "draftRound";
        return draftRoundQuery;
    }

    public String draftPick() {
        String draftPickQuery = prefixes + "SELECT ?draftPick WHERE {\n" +
                "?americanfootballplayer dbo:draftPick ?draftPick . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "draftPick";
        return draftPickQuery;
    }

    public String draftTeam() {
        String draftTeamQuery = prefixes + "SELECT ?draftTeam WHERE {\n" +
                "?americanfootballplayer dbo:draftTeam ?draftTeam . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "draftTeam";
        return draftTeamQuery;
    }

    public String formerTeam() {
        String formerTeamQuery = prefixes + "SELECT ?formerTeam WHERE {\n" +
                "?americanfootballplayer dbo:formerTeam ?formerTeam . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "formerTeam";
        return formerTeamQuery;
    }

    public String position() {
        String positionQuery = prefixes + "SELECT ?position WHERE {\n" +
                "?americanfootballplayer dbo:position ?position . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "position";
        return positionQuery;
    }

    public String number() {
        String numberQuery = prefixes + "SELECT ?number WHERE {\n" +
                "?americanfootballplayer dbo:number ?number . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "number";
        return numberQuery;
    }

    public String team() {
        String teamQuery = prefixes + "SELECT ?team WHERE {\n" +
                "?americanfootballplayer dbo:team ?team . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "team";
        return teamQuery;
    }

    public String height() {
        String heightQuery = prefixes + "SELECT ?height WHERE {\n" +
                "?americanfootballplayer dbo:height ?height . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "height";
        return heightQuery;
    }

    public String weight() {
        String weightQuery = prefixes + "SELECT ?weight WHERE {\n" +
                "?americanfootballplayer dbo:weight ?weight . \n" +
                "?americanfootballplayer foaf:name " + "\"" + americanfootballplayerName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "weight";
        return weightQuery;
    }

}