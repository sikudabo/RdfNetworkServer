package com.java.network.practice.JavaNetWorkPractice;

public class ProgrammingLanguageQuery{


	public String programminglanguageName;
	public String typeQuestion = "";
	public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
				"prefix dbr: <http://dbpedia.org/resource/> \n" +
				"prefix dbo: <http://dbpedia.org/ontology/> \n";

	public ProgrammingLanguageQuery(String programminglanguageName) {
	this.programminglanguageName = programminglanguageName;
	}
		
	public String abStract() {
		String abStractQuery = prefixes + "SELECT ?abstract WHERE {\n" + 
			"?programminglanguage dbo:abstract ?abstract . \n" +
			"?programminglanguage foaf:name " + "\"" + programminglanguageName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "abstract";
		return abStractQuery;
		}
		
	public String designer() {
		String designerQuery = prefixes + "SELECT ?designer WHERE {\n" + 
			"?programminglanguage dbo:designer ?designer . \n" +
			"?programminglanguage foaf:name " + "\"" + programminglanguageName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "designer";
		return designerQuery;
		}
		
	public String influencedBy() {
		String influencedByQuery = prefixes + "SELECT ?influencedBy WHERE {\n" + 
			"?programminglanguage dbo:influencedBy ?influencedBy . \n" +
			"?programminglanguage foaf:name " + "\"" + programminglanguageName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "influencedBy";
		return influencedByQuery;
		}
		
	public String influenced() {
		String influencedQuery = prefixes + "SELECT ?influenced WHERE {\n" + 
			"?programminglanguage dbo:influenced ?influenced . \n" +
			"?programminglanguage foaf:name " + "\"" + programminglanguageName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "influenced";
		return influencedQuery;
		}
		
	public String latestReleaseVersion() {
		String latestReleaseVersionQuery = prefixes + "SELECT ?latestReleaseVersion WHERE {\n" + 
			"?programminglanguage dbo:latestReleaseVersion ?latestReleaseVersion . \n" +
			"?programminglanguage foaf:name " + "\"" + programminglanguageName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "latestReleaseVersion";
		return latestReleaseVersionQuery;
		}
		
	public String developer() {
		String developerQuery = prefixes + "SELECT ?developer WHERE {\n" + 
			"?programminglanguage dbo:developer ?developer . \n" +
			"?programminglanguage foaf:name " + "\"" + programminglanguageName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "developer";
		return developerQuery;
		}

    public String license(){
        String licenseQuery = prefixes + "SELECT ?license WHERE {\n" +
                              "?programmingLanguage dbo:license ?license . \n" +
                              "?programminglanguage foaf:name " + "\"" + programminglanguageName + "\"" +  "@en \n"  +
                              "}";
                              this.typeQuestion = "license";
                              return licenseQuery;
        }

}
