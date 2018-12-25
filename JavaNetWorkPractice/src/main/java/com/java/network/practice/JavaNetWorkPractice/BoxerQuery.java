package com.java.network.practice.JavaNetWorkPractice;

public class BoxerQuery{


	public String boxerName;
	public String typeQuestion = "";
	public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
				"prefix dbr: <http://dbpedia.org/resource/> \n" +
				"prefix dbo: <http://dbpedia.org/ontology/> \n";

	public BoxerQuery(String boxerName) {
	this.boxerName = boxerName;
	}
		
	public String abStract() {
		String abStractQuery = prefixes + "SELECT ?abstract WHERE {\n" + 
			"?boxer dbo:abstract ?abstract . \n" +
			"?boxer foaf:name " + "\"" + boxerName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "abstract";
		return abStractQuery;
		}
		
	public String birthPlace() {
		String birthPlaceQuery = prefixes + "SELECT ?birthPlace WHERE {\n" + 
			"?boxer dbo:birthPlace ?birthPlace . \n" +
			"?boxer foaf:name " + "\"" + boxerName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "birthPlace";
		return birthPlaceQuery;
		}
		
	public String birthDate() {
		String birthDateQuery = prefixes + "SELECT ?birthDate WHERE {\n" + 
			"?boxer dbo:birthDate ?birthDate . \n" +
			"?boxer foaf:name " + "\"" + boxerName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "birthDate";
		return birthDateQuery;
		}
		
	public String deathDate() {
		String deathDateQuery = prefixes + "SELECT ?deathDate WHERE {\n" + 
			"?boxer dbo:deathDate ?deathDate . \n" +
			"?boxer foaf:name " + "\"" + boxerName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "deathDate";
		return deathDateQuery;
		}
		
	public String deathPlace() {
		String deathPlaceQuery = prefixes + "SELECT ?deathPlace WHERE {\n" + 
			"?boxer dbo:deathPlace ?deathPlace . \n" +
			"?boxer foaf:name " + "\"" + boxerName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "deathPlace";
		return deathPlaceQuery;
		}
		
	public String nick() {
		String nickQuery = prefixes + "SELECT ?nick WHERE {\n" + 
			"?boxer dbo:nick ?nick . \n" +
			"?boxer foaf:name " + "\"" + boxerName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "nick";
		return nickQuery;
		}
		
	public String nationality() {
		String nationalityQuery = prefixes + "SELECT ?nationality WHERE {\n" + 
			"?boxer dbo:nationality ?nationality . \n" +
			"?boxer foaf:name " + "\"" + boxerName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "nationality";
		return nationalityQuery;
		}
		
	public String height() {
		String heightQuery = prefixes + "SELECT ?height WHERE {\n" + 
			"?boxer dbo:height ?height . \n" +
			"?boxer foaf:name " + "\"" + boxerName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "height";
		return heightQuery;
		}
		
	public String weight() {
		String weightQuery = prefixes + "SELECT ?weight WHERE {\n" + 
			"?boxer dbo:weight ?weight . \n" +
			"?boxer foaf:name " + "\"" + boxerName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "weight";
		return weightQuery;
		}

}