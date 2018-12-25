package com.java.network.practice.JavaNetWorkPractice;

public class UniversityQuery{


    public String universityName;
    public String typeQuestion = "";
    public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
            "prefix dbr: <http://dbpedia.org/resource/> \n" +
            "prefix dbo: <http://dbpedia.org/ontology/> \n";

    public UniversityQuery(String universityName) {
        this.universityName = universityName;
    }

    public String abStract() {
        String abStractQuery = prefixes + "SELECT ?abstract WHERE {\n" +
                "?university dbo:abstract ?abstract . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "abstract";
        return abStractQuery;
    }

    public String motto() {
        String mottoQuery = prefixes + "SELECT ?motto WHERE {\n" +
                "?university dbo:motto ?motto . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "motto";
        return mottoQuery;
    }

    public String president() {
        String presidentQuery = prefixes + "SELECT ?president WHERE {\n" +
                "?university dbo:president ?president . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "president";
        return presidentQuery;
    }

    public String type() {
        String typeQuery = prefixes + "SELECT ?type WHERE {\n" +
                "?university dbo:type ?type . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "type";
        return typeQuery;
    }

    public String facultySize() {
        String facultySizeQuery = prefixes + "SELECT ?facultySize WHERE {\n" +
                "?university dbo:facultySize ?facultySize . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "facultySize";
        return facultySizeQuery;
    }

    public String numberOfStudents() {
        String numberOfStudentsQuery = prefixes + "SELECT ?numberOfStudents WHERE {\n" +
                "?university dbo:numberOfStudents ?numberOfStudents . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "numberOfStudents";
        return numberOfStudentsQuery;
    }

    public String numberOfUndergraduateStudents() {
        String numberOfUndergraduateStudentsQuery = prefixes + "SELECT ?numberOfUndergraduateStudents WHERE {\n" +
                "?university dbo:numberOfUndergraduateStudents ?numberOfUndergraduateStudents . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "numberOfUndergraduateStudents";
        return numberOfUndergraduateStudentsQuery;
    }

    public String numberOfPostgraduateStudents() {
        String numberOfPostgraduateStudentsQuery = prefixes + "SELECT ?numberOfPostgraduateStudents WHERE {\n" +
                "?university dbo:numberOfPostgraduateStudents ?numberOfPostgraduateStudents . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "numberOfPostgraduateStudents";
        return numberOfPostgraduateStudentsQuery;
    }

    public String transmission() {
        String transmissionQuery = prefixes + "SELECT ?transmission WHERE {\n" +
                "?university dbo:transmission ?transmission . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "transmission";
        return transmissionQuery;
    }

    public String width() {
        String widthQuery = prefixes + "SELECT ?width WHERE {\n" +
                "?university dbo:width ?width . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "width";
        return widthQuery;
    }

    public String height() {
        String heightQuery = prefixes + "SELECT ?height WHERE {\n" +
                "?university dbo:height ?height . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "height";
        return heightQuery;
    }

    public String city() {
        String cityQuery = prefixes + "SELECT ?city WHERE {\n" +
                "?university dbo:city ?city . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "city";
        return cityQuery;
    }

    public String state() {
        String stateQuery = prefixes + "SELECT ?state WHERE {\n" +
                "?university dbo:state ?state . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "state";
        return stateQuery;
    }

    public String country() {
        String countryQuery = prefixes + "SELECT ?country WHERE {\n" +
                "?university dbo:country ?country . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "country";
        return countryQuery;
    }

    public String officialSchoolColour() {
        String officialSchoolColourQuery = prefixes + "SELECT ?officialSchoolColour WHERE {\n" +
                "?university dbo:officialSchoolColour ?officialSchoolColour . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "officialSchoolColour";
        return officialSchoolColourQuery;
    }

    public String mascot() {
        String mascotQuery = prefixes + "SELECT ?mascot WHERE {\n" +
                "?university dbo:mascot ?mascot . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "mascot";
        return mascotQuery;
    }

    public String nick() {
        String nickQuery = prefixes + "SELECT ?nick WHERE {\n" +
                "?university dbo:nick ?nick . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "nick";
        return nickQuery;
    }

    public String homepage() {
        String homepageQuery = prefixes + "SELECT ?homepage WHERE {\n" +
                "?university dbo:homepage ?homepage . \n" +
                "?university foaf:name " + "\"" + universityName + "\"" +  "@en \n" +
                "}";
        this.typeQuestion = "homepage";
        return homepageQuery;
    }

}
