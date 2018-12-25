package com.java.network.practice.JavaNetWorkPractice;

public class MilitaryConflictQuery{


	public String militaryconflictName;
	public String typeQuestion = "";
	public final String prefixes = "prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
				"prefix dbr: <http://dbpedia.org/resource/> \n" +
				"prefix dbo: <http://dbpedia.org/ontology/> \n";

	public MilitaryConflictQuery(String militaryconflictName) {
	this.militaryconflictName = militaryconflictName;
	}
		
	public String abStract() {
		String abStractQuery = prefixes + "SELECT ?abstract WHERE {\n" + 
			"?militaryconflict dbo:abstract ?abstract . \n" +
			"?militaryconflict foaf:name " + "\"" + militaryconflictName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "abstract";
		return abStractQuery;
		}
		
	public String place() {
		String placeQuery = prefixes + "SELECT ?place WHERE {\n" + 
			"?militaryconflict dbo:place ?place . \n" +
			"?militaryconflict foaf:name " + "\"" + militaryconflictName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "place";
		return placeQuery;
		}
		
	public String territory() {
		String territoryQuery = prefixes + "SELECT ?territory WHERE {\n" + 
			"?militaryconflict dbo:territory ?territory . \n" +
			"?militaryconflict foaf:name " + "\"" + militaryconflictName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "territory";
		return territoryQuery;
		}
		
	public String result() {
		String resultQuery = prefixes + "SELECT ?result WHERE {\n" + 
			"?militaryconflict dbo:result ?result . \n" +
			"?militaryconflict foaf:name " + "\"" + militaryconflictName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "result";
		return resultQuery;
		}
		
	public String combatant() {
		String combatantQuery = prefixes + "SELECT ?combatant WHERE {\n" + 
			"?militaryconflict dbo:combatant ?combatant . \n" +
			"?militaryconflict foaf:name " + "\"" + militaryconflictName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "combatant";
		return combatantQuery;
		}
		
	public String commander() {
		String commanderQuery = prefixes + "SELECT ?commander WHERE {\n" + 
			"?militaryconflict dbo:commander ?commander . \n" +
			"?militaryconflict foaf:name " + "\"" + militaryconflictName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "commander";
		return commanderQuery;
		}
		
	public String strength() {
		String strengthQuery = prefixes + "SELECT ?strength WHERE {\n" + 
			"?militaryconflict dbo:strength ?strength . \n" +
			"?militaryconflict foaf:name " + "\"" + militaryconflictName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "strength";
		return strengthQuery;
		}
		
	public String causalties() {
		String causaltiesQuery = prefixes + "SELECT ?causalties WHERE {\n" + 
			"?militaryconflict dbo:causalties ?causalties . \n" +
			"?militaryconflict foaf:name " + "\"" + militaryconflictName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "causalties";
		return causaltiesQuery;
		}
		
	public String date() {
		String dateQuery = prefixes + "SELECT ?date WHERE {\n" + 
			"?militaryconflict dbo:date ?date . \n" +
			"?militaryconflict foaf:name " + "\"" + militaryconflictName + "\"" +  "@en \n" + 
			"}";
		this.typeQuestion = "date";
		return dateQuery;
		}

}
