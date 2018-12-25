package com.java.network.practice.JavaNetWorkPractice;

public class BookQuery{


	public String bookName;
	public String typeQuestion = "";
	public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
				"prefix dbr: <http://dbpedia.org/resource/> \n" +
				"prefix dbo: <http://dbpedia.org/ontology/> \n";

	public BookQuery(String bookName) {
	this.bookName = bookName;
	}
		
	public String abStract() {
		String abStractQuery = prefixes + "SELECT ?abstract WHERE {\n" + 
			"?book dbo:abstract ?abstract . \n" +
			"?book foaf:name " + "\"" + bookName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "abstract";
		return abStractQuery;
		}
		
	public String author() {
		String authorQuery = prefixes + "SELECT ?author WHERE {\n" + 
			"?book dbo:author ?author . \n" +
			"?book foaf:name " + "\"" + bookName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "author";
		return authorQuery;
		}
		
	public String country() {
		String countryQuery = prefixes + "SELECT ?country WHERE {\n" + 
			"?book dbo:country ?country . \n" +
			"?book foaf:name " + "\"" + bookName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "country";
		return countryQuery;
		}
		
	public String language() {
		String languageQuery = prefixes + "SELECT ?language WHERE {\n" + 
			"?book dbo:language ?language . \n" +
			"?book foaf:name " + "\"" + bookName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "language";
		return languageQuery;
		}
		
	public String literaryGenre() {
		String literaryGenreQuery = prefixes + "SELECT ?literaryGenre WHERE {\n" + 
			"?book dbo:literaryGenre ?literaryGenre . \n" +
			"?book foaf:name " + "\"" + bookName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "literaryGenre";
		return literaryGenreQuery;
		}
		
	public String publisher() {
		String publisherQuery = prefixes + "SELECT ?publisher WHERE {\n" + 
			"?book dbo:publisher ?publisher . \n" +
			"?book foaf:name " + "\"" + bookName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "publisher";
		return publisherQuery;
		}
		
	public String mediaType() {
		String mediaTypeQuery = prefixes + "SELECT ?mediaType WHERE {\n" + 
			"?book dbo:mediaType ?mediaType . \n" +
			"?book foaf:name " + "\"" + bookName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "mediaType";
		return mediaTypeQuery;
		}
		
	public String numberOfPages() {
		String numberOfPagesQuery = prefixes + "SELECT ?numberOfPages WHERE {\n" + 
			"?book dbo:numberOfPages ?numberOfPages . \n" +
			"?book foaf:name " + "\"" + bookName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "numberOfPages";
		return numberOfPagesQuery;
		}
		
	public String isbn() {
		String isbnQuery = prefixes + "SELECT ?isbn WHERE {\n" + 
			"?book dbo:isbn ?isbn . \n" +
			"?book foaf:name " + "\"" + bookName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "isbn";
		return isbnQuery;
		}

}
