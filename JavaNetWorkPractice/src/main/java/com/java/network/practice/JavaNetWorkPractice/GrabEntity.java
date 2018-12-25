package com.java.network.practice.JavaNetWorkPractice;

import java.io.*;
import java.util.*;
import java.lang.*;
import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.dict.DictionaryEntry;
import com.aliasi.dict.ExactDictionaryChunker;
import com.aliasi.dict.MapDictionary;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;

public class GrabEntity {
	
	private static Map<String, String> entityTypeMap;
	private static Map<String, String> fullNameEntityTypeMap;
	private static String entityName = "";
	private static MapDictionary<String> dictionary = null;
	private static final boolean returnAllMatches = true;
	private static final boolean caseSensitive = true;
	
	public static void loadMap() throws IOException, ClassNotFoundException{
		File file = new File("C://Users//Zookeeper//Downloads//dictSampleTest.ser");
    	FileInputStream fInput = new FileInputStream(file);
    	ObjectInputStream oInput = new ObjectInputStream(fInput);
    	dictionary = (MapDictionary<String>) oInput.readObject();
    }
	
	public static String getType(String userQuestion) throws ClassNotFoundException, IOException {
		try {
		loadMap();
		if(userQuestion.contains("which award") || userQuestion.contains("what award")) {
			userQuestion = userQuestion.replace("win", "");
		}
		
		else if(userQuestion.contains("what kind of government") || userQuestion.contains("what type of government")) {
			userQuestion = userQuestion.replace("have", "");
		}
		
		else if(userQuestion.contains("which country") || userQuestion.contains("what country")) {
			userQuestion = userQuestion.replace("in", "");
		}
		userQuestion = userQuestion.toLowerCase();
		userQuestion = userQuestion.replace("what is the capital of", "");
		userQuestion = userQuestion.replace("?", "");
		userQuestion = userQuestion.replace("what is the currency of", "");
		userQuestion = userQuestion.replace("which currency does", "");
		userQuestion = userQuestion.replace("when was", "");
		userQuestion = userQuestion.replace("which party was", "");
		userQuestion = userQuestion.replace(".", "");
		userQuestion = userQuestion.replace("where was", "");
		userQuestion = userQuestion.replace("military command", "");
		userQuestion = userQuestion.replace("what is the population of", "");
		userQuestion = userQuestion.replace("born", "");
		userQuestion = userQuestion.replace("die", "");
		userQuestion = userQuestion.replace("when did", "");
		userQuestion = userQuestion.replace("what are people from", "");
		userQuestion = userQuestion.replace("called", "");
		userQuestion = userQuestion.replace("who is the president of", "");
		userQuestion = userQuestion.replace("who is the leader of", "");
		userQuestion = userQuestion.replace("who is the prime miniester of", "");
		userQuestion = userQuestion.replace("'s", "");
		userQuestion = userQuestion.replace("who is", "");
		userQuestion = userQuestion.replace("wife", "");
		userQuestion = userQuestion.replace("husband", "");
		userQuestion = userQuestion.replace("married to", "");
		userQuestion = userQuestion.replace("where is", "");
		userQuestion = userQuestion.replace("what kind of leader does", "");
		userQuestion = userQuestion.replace(" have", "");
		userQuestion = userQuestion.replace("what is the long name of", "");
		userQuestion = userQuestion.replace("what is the longname of", "");
		userQuestion = userQuestion.replace("founded", "");
		userQuestion = userQuestion.replace("what is the area of", "");
		userQuestion = userQuestion.replace("what percentage water is", "");
		userQuestion = userQuestion.replace("is water", "");
		userQuestion = userQuestion.replace("what percentage of", "");
		userQuestion = userQuestion.replace("what is the largest city in", "");
		userQuestion = userQuestion.replace("what is the biggest city in", "");
		userQuestion = userQuestion.replace("type of government", "");
		userQuestion = userQuestion.replace("kind of government", "");
		userQuestion = userQuestion.replace("who wrote", "");
		userQuestion = userQuestion.replace("who directed", "");
		userQuestion = userQuestion.replace("who was the director for", "");
		userQuestion = userQuestion.replace("who distributed", "");
		userQuestion = userQuestion.replace("who played in", "");
		userQuestion = userQuestion.replace("who wrote", "");
		userQuestion = userQuestion.replace("who was the distributor", "");
		userQuestion = userQuestion.replace("who wrote the music for", "");
		userQuestion = userQuestion.replace("who composed the music for", "");
		userQuestion = userQuestion.replace("who was the writer for", "");
		userQuestion = userQuestion.replace("how long was", "");
		userQuestion = userQuestion.replace("how long was", "");
		userQuestion = userQuestion.replace("who did the editing for", "");
		userQuestion = userQuestion.replace("who edited", "");
		userQuestion = userQuestion.replace("who was the editor for", "");
		userQuestion = userQuestion.replace("what was the budget for", "");
		userQuestion = userQuestion.replace("how much money", "");
		userQuestion = userQuestion.replace("what was the revenue for", "");
		userQuestion = userQuestion.replace("what was the gross profit for", "");
		userQuestion = userQuestion.replace("what was the profit for", "");
		userQuestion = userQuestion.replace("which team did", "");
		userQuestion = userQuestion.replace("play for", "");
		userQuestion = userQuestion.replace("play on", "");
		userQuestion = userQuestion.replace("which team does", "");
		userQuestion = userQuestion.replace("what team", "");
		userQuestion = userQuestion.replace("which team drafted", "");
		userQuestion = userQuestion.replace("what team drafted", "");
		userQuestion = userQuestion.replace("what number does", "");
		userQuestion = userQuestion.replace("who drafted", "");
		userQuestion = userQuestion.replace("what number", "");
		userQuestion = userQuestion.replace("retire", "");
		userQuestion = userQuestion.replace("start playing", "");
		userQuestion = userQuestion.replace("career begin", "");
		userQuestion = userQuestion.replace("stop playing", "");
		userQuestion = userQuestion.replace("weight", "");
		userQuestion = userQuestion.replace("how much does", "");
		userQuestion = userQuestion.replace("how tall is", "");
		userQuestion = userQuestion.replace("weigh", "");
		userQuestion = userQuestion.replace("which position", "");
		userQuestion = userQuestion.replace("what position", "");
		userQuestion = userQuestion.replace("which award", "");
		userQuestion = userQuestion.replace("what award", "");
		userQuestion = userQuestion.replace("what awards", "");
		userQuestion = userQuestion.replace("which awards", "");
		userQuestion = userQuestion.replace("wear", "");
		userQuestion = userQuestion.replace("which college did", "");
		userQuestion = userQuestion.replace("go to school", "");
		userQuestion = userQuestion.replace("go to college", "");
		userQuestion = userQuestion.replace("go to", "");
		userQuestion = userQuestion.replace("play", "");
		userQuestion = userQuestion.replace("what year was", "");
		userQuestion = userQuestion.replace("drafted", "");
		userQuestion = userQuestion.replace("what is the nickname for", "");
		userQuestion = userQuestion.replace("what is the nickname of", "");
		userQuestion = userQuestion.replace("what is the population for", "");
		userQuestion = userQuestion.replace("what is the metro population of", "");
		userQuestion = userQuestion.replace("who is the mayor of", "");
		userQuestion = userQuestion.replace("what is the twin city for", "");
		userQuestion = userQuestion.replace("what is the twin city of", "");
		userQuestion = userQuestion.replace("what are the twin cities for", "");
		userQuestion = userQuestion.replace("what are the twin cities of", "");
		userQuestion = userQuestion.replace("what type of leader", "");
		userQuestion = userQuestion.replace("who is the leader of", "");
		userQuestion = userQuestion.replace("which kind of leader", "");
		userQuestion = userQuestion.replace("what kind of leader", "");
		userQuestion = userQuestion.replace("which type of leader", "");
		userQuestion = userQuestion.replace("what is the urban population of", "");
		userQuestion = userQuestion.replace("what is the urban population of", "");
		userQuestion = userQuestion.replace("what type of city is", "");
		userQuestion = userQuestion.replace("what type of town", "");
		userQuestion = userQuestion.replace("what is the area code for", "");
		userQuestion = userQuestion.replace("what is the areacode for", "");
		userQuestion = userQuestion.replace("what is the area code of", "");
		userQuestion = userQuestion.replace("what is the areacode of", "");
		userQuestion = userQuestion.replace("what is the postal code for", "");
		userQuestion = userQuestion.replace("what is the postalcode for", "");
		userQuestion = userQuestion.replace("what is the postal code of", "");
		userQuestion = userQuestion.replace("what is the postalcode of", "");
		userQuestion = userQuestion.replace("what kind of government does", "");
		userQuestion = userQuestion.replace("which kind of government does", "");
		userQuestion = userQuestion.replace("what is the metro population for", "");
		userQuestion = userQuestion.replace("what is the metro population of", "");
		userQuestion = userQuestion.replace("what is the total population for", "");
		userQuestion = userQuestion.replace("what is the metro population of", "");
		userQuestion = userQuestion.replace("what is the timezone for", "");
		userQuestion = userQuestion.replace("which timezone is ", "");
		userQuestion = userQuestion.replace("what is the timezone of", "");
		userQuestion = userQuestion.replace("what is the timezone in", "");
		userQuestion = userQuestion.replace("a part of", "");
		userQuestion = userQuestion.replace("which state", "");
		userQuestion = userQuestion.replace("which country", "");
		userQuestion = userQuestion.replace("which region", "");
		userQuestion = userQuestion.replace("which county", "");
		userQuestion = userQuestion.replace("what is the homepage of", "");
		userQuestion = userQuestion.replace("what is the home page of", "");
		userQuestion = userQuestion.replace("what is the homepage for", "");
		userQuestion = userQuestion.replace("what is the home page for", "");
		userQuestion = userQuestion.replace("what is the motto of", "");
		userQuestion = userQuestion.replace("what is the motto of", "");
		userQuestion = userQuestion.trim();
			ExactDictionaryChunker dictionaryChunker = new ExactDictionaryChunker(dictionary, IndoEuropeanTokenizerFactory.INSTANCE, returnAllMatches, caseSensitive);
			Chunking chunking = dictionaryChunker.chunk(userQuestion);
	    	ArrayList<String> types = new ArrayList<String>();
	    	types.add("President");
	    	types.add("Country");
	    	types.add("Film");
	    	types.add("BasketballPlayer");
	    	types.add("City");
	    	String queryType = "";
	    	for(Chunk chunk : chunking.chunkSet()) {
                String type = chunk.type();
                if (types.contains(type)) {
                    int start = chunk.start();
                    int end = chunk.end();
                    entityName = userQuestion.substring(start, end);
                    String[] nameSplitter = entityName.split(" ");
                    queryType = type;
                    System.out.println(entityName + " type: " + type);
                    if(nameSplitter.length >= 2 && (type.equals("President") || type.equals("BasketballPlayer")|| type.equals("AmericanFootballPlayer"))){
                        break;
                    }


                }
            }
	    	System.out.println("This is a " + queryType + " type query");
	    	return queryType;
			}
			catch(Exception e) {
				return "Error";
			}
		}
	
	public static String getEntityName() {
		return entityName.trim();
	}

}
