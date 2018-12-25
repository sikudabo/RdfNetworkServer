package com.java.network.practice.JavaNetWorkPractice;

public class PrepPresidentQuery {

    public String presName;
    public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
            "prefix dbr: <http://dbpedia.org/resource/> \n" +
            "prefix dbo: <http://dbpedia.org/ontology/> \n";
    String typeQuestion = "";
    public PrepPresidentQuery(String presName) {
        this.presName = presName;
    }


    public String birthDate() {
        String birthDateQuery = prefixes +
                "SELECT ?birthDate WHERE { \n" +
                "?pres dbo:birthDate ?birthDate .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "birthDate";
        return birthDateQuery;


    }

    public String deathDate() {
        String deathDateQuery = prefixes +
                "SELECT ?deathDate WHERE { \n" +
                "?pres dbo:deathDate ?deathDate .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "deathDate";
        return deathDateQuery;

    }

    public String birthPlace() {
        String birthPlaceQuery = prefixes +
                "SELECT ?birthPlace WHERE { \n" +
                "?pres dbo:birthPlace ?birthPlace .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "birthPlace";
        return birthPlaceQuery;
    }
    public String deathPlace() {
        String deathPlaceQuery = prefixes +
                "SELECT ?deathPlace WHERE { \n" +
                "?pres dbo:deathPlace ?deathPlace .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "deathPlace";
        return deathPlaceQuery;
    }

    public String restingPlace() {
        String restingPlaceQuery = prefixes +
                "SELECT ?restingPlace WHERE { \n" +
                "?pres dbo:restingPlace ?restingPlace .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "restingPlace";
        return restingPlaceQuery;

    }

    public String party() {
        String partyQuery = prefixes +
                "SELECT ?party WHERE { \n" +
                "?pres dbo:party ?party .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "party";
        return partyQuery;
    }

    public String spouse() {
        String spouseQuery = prefixes +
                "SELECT ?spouse WHERE { \n" +
                "?pres dbo:spouse ?spouse .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "spouse";
        return spouseQuery;
    }

    public String religion() {
        String religionQuery = prefixes +
                "SELECT ?religion WHERE { \n" +
                "?pres dbo:religion ?religion .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "religion";
        return religionQuery;
    }

    public String country() {
        String countryQuery = prefixes +
                "SELECT ?country WHERE { \n" +
                "?pres dbo:country ?country .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "country";
        return countryQuery;
    }

    public String militaryBranch() {
        String militaryBranchQuery = prefixes +
                "SELECT ?militaryBranch WHERE { \n" +
                "?pres dbo:militaryBranch ?militaryBranch .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "militaryBranch";
        return militaryBranchQuery;
    }

    public String serviceStartYear() {
        String serviceStartYearQuery = prefixes +
                "SELECT ?serviceStartYear WHERE { \n" +
                "?pres dbo:serviceStartYear ?serviceStartYear .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "serviceStartYear";
        return serviceStartYearQuery;
    }

    public String serviceEndYear() {
        String serviceEndYearQuery = prefixes +
                "SELECT ?serviceEndYear WHERE { \n" +
                "?pres dbo:serviceEndYear ?serviceEndYear .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "serviceEndYear";
        return serviceEndYearQuery;
    }

    public String militaryRank() {
        String militaryRankQuery = prefixes +
                "SELECT ?militaryRank WHERE { \n" +
                "?pres dbo:militaryRank ?militaryRank .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "militaryRank";
        return militaryRankQuery;
    }

    public String militaryCommand() {
        String militaryCommandQuery = prefixes +
                "SELECT ?militaryCommand WHERE { \n" +
                "?pres dbo:militaryCommand ?militaryCommand .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "militaryCommand";
        return militaryCommandQuery;
    }

    public String battle() {
        String battleQuery = prefixes +
                "SELECT ?battle WHERE { \n" +
                "?pres dbo:battle ?battle .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "battle";
        return battleQuery;
    }

    public String successor() {
        String successorQuery = prefixes +
                "SELECT ?successor WHERE { \n" +
                "?pres dbo:successor ?successor .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "successor";
        return successorQuery;
    }

    public String office() {
        String officeQuery = prefixes +
                "SELECT ?office WHERE { \n" +
                "?pres dbo:office ?office .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "office";
        return officeQuery;
    }

    public String activeYearsStartDate() {
        String activeYearsStartDateQuery = prefixes +
                "SELECT ?activeYearsStartDate WHERE { \n" +
                "?pres dbo:activeYearsStartDate ?activeYearsStartDate .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "activeYearsStartDate";
        return activeYearsStartDateQuery;
    }

    public String activeYearsEndDate() {
        String activeYearsEndDateQuery = prefixes +
                "SELECT ?activeYearsEndDate WHERE { \n" +
                "?pres dbo:activeYearsEndDate ?activeYearsEndDate .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "activeYearsEndDate";
        return activeYearsEndDateQuery;
    }

    public String vicePresident() {
        String vicePresidentQuery = prefixes +
                "SELECT ?vicePresident WHERE { \n" +
                "?pres dbo:vicePresident ?vicePresident .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "vicePresident";
        return vicePresidentQuery;
    }

    public String termPeriod() {
        String termPeriodQuery = prefixes +
                "SELECT ?termPeriod WHERE { \n" +
                "?pres dbo:termPeriod ?termPeriod .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "termPeriod";
        return termPeriodQuery;
    }

    public String child() {
        String childQuery = prefixes +
                "SELECT ?child WHERE { \n" +
                "?pres dbo:child ?child .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "child";
        return childQuery;
    }

    public String almaMater() {
        String almaMaterQuery = prefixes +
                "SELECT ?almaMater WHERE { \n" +
                "?pres dbo:almaMater ?almaMater .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "almaMater";
        return almaMaterQuery;
    }

    public String presidentUnder() {
        String presidentQuery = prefixes +
                "SELECT ?president WHERE { \n" +
                "?pres dbo:president ?president .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "president";
        return presidentQuery;
    }

    public String profession() {
        String professionQuery = prefixes +
                "SELECT ?profession WHERE { \n" +
                "?pres dbo:profession ?profession .\n" +
                "?pres foaf:name " + "\"" + presName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "profession";
        return professionQuery;
    }

}