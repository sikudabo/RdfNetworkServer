package com.java.network.practice.JavaNetWorkPractice;

public class VideoGameQuery{


	public String videogameName;
	public String typeQuestion = "";
	public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
				"prefix dbr: <http://dbpedia.org/resource/> \n" +
				"prefix dbo: <http://dbpedia.org/ontology/> \n";

	public VideoGameQuery(String videogameName) {
	this.videogameName = videogameName;
	}
		
	public String developer() {
		String developerQuery = prefixes + "SELECT ?developer WHERE {\n" + 
			"?videogame dbo:developer ?developer . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "developer";
		return developerQuery;
		}
		
	public String genre() {
		String genreQuery = prefixes + "SELECT ?genre WHERE {\n" + 
			"?videogame dbo:genre ?genre . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "genre";
		return genreQuery;
		}
		
	public String computingPlatform() {
		String computingPlatformQuery = prefixes + "SELECT ?computingPlatform WHERE {\n" + 
			"?videogame dbo:computingPlatform ?computingPlatform . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "computingPlatform";
		return computingPlatformQuery;
		}
		
	public String designer() {
		String designerQuery = prefixes + "SELECT ?designer WHERE {\n" + 
			"?videogame dbo:designer ?designer . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "designer";
		return designerQuery;
		}
		
	public String series() {
		String seriesQuery = prefixes + "SELECT ?series WHERE {\n" + 
			"?videogame dbo:series ?series . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "series";
		return seriesQuery;
		}
		
	public String publisher() {
		String publisherQuery = prefixes + "SELECT ?publisher WHERE {\n" + 
			"?videogame dbo:publisher ?publisher . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "publisher";
		return publisherQuery;
		}
		
	public String director() {
		String directorQuery = prefixes + "SELECT ?director WHERE {\n" + 
			"?videogame dbo:director ?director . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "director";
		return directorQuery;
		}
		
	public String composer() {
		String composerQuery = prefixes + "SELECT ?composer WHERE {\n" + 
			"?videogame dbo:composer ?composer . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "composer";
		return composerQuery;
		}
		
	public String gameArtist() {
		String gameArtistQuery = prefixes + "SELECT ?gameArtist WHERE {\n" + 
			"?videogame dbo:gameArtist ?gameArtist . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "gameArtist";
		return gameArtistQuery;
		}
		
	public String writer() {
		String writerQuery = prefixes + "SELECT ?writer WHERE {\n" + 
			"?videogame dbo:writer ?writer . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "writer";
		return writerQuery;
		}
		
	public String distributor() {
		String distributorQuery = prefixes + "SELECT ?distributor WHERE {\n" + 
			"?videogame dbo:distributor ?distributor . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "distributor";
		return distributorQuery;
		}
		
	public String lastestReleaseVersion() {
		String lastestReleaseVersionQuery = prefixes + "SELECT ?lastestReleaseVersion WHERE {\n" + 
			"?videogame dbo:lastestReleaseVersion ?lastestReleaseVersion . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "lastestReleaseVersion";
		return lastestReleaseVersionQuery;
		}
		
	public String releaseDate() {
		String releaseDateQuery = prefixes + "SELECT ?releaseDate WHERE {\n" + 
			"?videogame dbo:releaseDate ?releaseDate . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "releaseDate";
		return releaseDateQuery;
		}
		
	public String gameEngine() {
		String gameEngineQuery = prefixes + "SELECT ?gameEngine WHERE {\n" + 
			"?videogame dbo:gameEngine ?gameEngine . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "gameEngine";
		return gameEngineQuery;
		}
		
	public String requirement() {
		String requirementQuery = prefixes + "SELECT ?requirement WHERE {\n" + 
			"?videogame dbo:requirement ?requirement . \n" +
			"?videogame foaf:name " + "\"" + videogameName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "requirement";
		return requirementQuery;
		}

}
