package com.java.network.practice.JavaNetWorkPractice;

public class DiseaseQuery {


    public String diseaseName;
    public String typeQuestion = "";
    public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
            "prefix dbr: <http://dbpedia.org/resource/> \n" +
            "prefix dbo: <http://dbpedia.org/ontology/> \n";

    public DiseaseQuery(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String abStract() {
        String abStractQuery = prefixes + "SELECT ?abstract WHERE {\n" +
                "?disease dbo:abstract ?abstract . \n" +
                "?disease foaf:name " + "\"" + diseaseName + "\"" + "@en \n" +
                "}";
        this.typeQuestion = "abstract";
        return abStractQuery;
    }
}
