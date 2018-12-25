package com.java.network.practice.JavaNetWorkPractice;

public class MusicalArtistQuery{


	public String musicalartistName;
	public String typeQuestion = "";
	public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
				"prefix dbr: <http://dbpedia.org/resource/> \n" +
				"prefix dbo: <http://dbpedia.org/ontology/> \n";

	public MusicalArtistQuery(String musicalartistName) {
	this.musicalartistName = musicalartistName;
	}
		
	public String abStract() {
		String abStractQuery = prefixes + "SELECT ?abstract WHERE {\n" + 
			"?musicalartist dbo:abstract ?abstract . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "abstract";
		return abStractQuery;
		}
		
	public String background() {
		String backgroundQuery = prefixes + "SELECT ?background WHERE {\n" + 
			"?musicalartist dbo:background ?background . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "background";
		return backgroundQuery;
		}
		
	public String birthDate() {
		String birthDateQuery = prefixes + "SELECT ?birthDate WHERE {\n" + 
			"?musicalartist dbo:birthDate ?birthDate . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "birthDate";
		return birthDateQuery;
		}
		
	public String birthPlace() {
		String birthPlaceQuery = prefixes + "SELECT ?birthPlace WHERE {\n" + 
			"?musicalartist dbo:birthPlace ?birthPlace . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "birthPlace";
		return birthPlaceQuery;
		}
		
	public String deathDate() {
		String deathDateQuery = prefixes + "SELECT ?deathDate WHERE {\n" + 
			"?musicalartist dbo:deathDate ?deathDate . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "deathDate";
		return deathDateQuery;
		}
		
	public String deathPlace() {
		String deathPlaceQuery = prefixes + "SELECT ?deathPlace WHERE {\n" + 
			"?musicalartist dbo:deathPlace ?deathPlace . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "deathPlace";
		return deathPlaceQuery;
		}
		
	public String instrument() {
		String instrumentQuery = prefixes + "SELECT ?instrument WHERE {\n" + 
			"?musicalartist dbo:instrument ?instrument . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "instrument";
		return instrumentQuery;
		}
		
	public String genre() {
		String genreQuery = prefixes + "SELECT ?genre WHERE {\n" + 
			"?musicalartist dbo:genre ?genre . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "genre";
		return genreQuery;
		}
		
	public String occupation() {
		String occupationQuery = prefixes + "SELECT ?occupation WHERE {\n" + 
			"?musicalartist dbo:occupation ?occupation . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "occupation";
		return occupationQuery;
		}
		
	public String activeYearsStartYear() {
		String activeYearsStartYearQuery = prefixes + "SELECT ?activeYearsStartYear WHERE {\n" + 
			"?musicalartist dbo:activeYearsStartYear ?activeYearsStartYear . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "activeYearsStartYear";
		return activeYearsStartYearQuery;
		}
		
	public String activeYearsEndYear() {
		String activeYearsEndYearQuery = prefixes + "SELECT ?activeYearsEndYear WHERE {\n" + 
			"?musicalartist dbo:activeYearsEndYear ?activeYearsEndYear . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "activeYearsEndYear";
		return activeYearsEndYearQuery;
		}
		
	public String recordLabel() {
		String recordLabelQuery = prefixes + "SELECT ?recordLabel WHERE {\n" + 
			"?musicalartist dbo:recordLabel ?recordLabel . \n" +
			"?musicalartist foaf:name " + "\"" + musicalartistName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "recordLabel";
		return recordLabelQuery;
		}

}
