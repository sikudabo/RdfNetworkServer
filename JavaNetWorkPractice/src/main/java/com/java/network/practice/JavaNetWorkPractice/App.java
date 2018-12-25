package com.java.network.practice.JavaNetWorkPractice;
import java.util.*;

import org.apache.commons.io.IOUtils;

import java.lang.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.io.*;
import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.dict.DictionaryEntry;
import com.aliasi.dict.ExactDictionaryChunker;
import com.aliasi.dict.MapDictionary;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;




/**
 * @author Simeon Ikudabo
 * This is the Simi App server class. The Application will start a server socket that waits
 * for client connections. Once the client is connected an InputStream will read data from the
 * client. That data will be the entity, type of question and type of entity. That data will be
 * sent to the processQuery method that will send the necessary information to the 
 * QuerySparqlSearchEngine class. A result will be returned and set back to the main method
 * which will be sent back to the client socket and read by the client Application. Another important
 * note is that I load the Jena Turtle model when this classes main() method is called. That 
 * prevents the Model from needing to be loaded each time a query is made, which reduces memory
 * usage and enables the Application to perform slighlty faster than it was previously. 
 */
public class App 
{

    public static void main( String[] args ) throws IOException
    {
    	String filePath = "C://Users//Zookeeper//Downloads//sample_5.ttl";//Get the file path in String format
    	Model model = FileManager.get().loadModel(filePath, "TTL");//Create a new model by loading the model. Specify Turtle format. 
    	System.out.println("Server starting...");//Prompt the user to let them know the server is starting. 
    	try {
    		ServerSocket serverSocket = new ServerSocket(1001);//Create a server socket "listening" on port 1001. 
    		while(true) {//Create infinite while loop to listen for connections from clients. 
    			Socket clientSocket = serverSocket.accept();//The client socket will be an accepted client connection. 
    			System.out.println("Connection made to: " + clientSocket);//Show that a connection has been made. 
    			BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//Create a Buffered Reader to read input from the client. 
    			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);//Create a PrintWriter that will print an OutputStream to the client. 
    			String messageString = "";
    			String line;
    			System.out.println("Entering while loop");
    			while((line = br.readLine()) != null) {
    				messageString = line;//The message will be set equal to the line being read. 
    				System.out.println(line);
    				String[] splitter = messageString.split(">");// The > charachter is the delimiter. Split the message on that symbol. 
        			String entityName = splitter[0].trim(); //The entities name will be the first index.
        			String queryType = splitter[1].trim(); //The type of query will be the second index. 
        			String entityType = splitter[2].trim(); //The "type" of entity will be in the last index. 
        			System.out.println(entityName); //Print the name, type of entity, and query type. 
        			System.out.println(entityType);
        			System.out.println(queryType);
        			String[] answers = processQuery(entityName, queryType, entityType, model); //Call the static processQuery method() and return an answer as a result. 
        			System.out.println(Arrays.toString(answers)); //Print the answer. 
        			String answersString = Arrays.toString(answers); //Get the array in String format. 
        			answersString = answersString.replace("[", ""); //Remove brackets
        			answersString = answersString.replace("]", "");
        			out.println(answersString); //Send a fully formatted String back to the client.
    				break; //Break out of the while loop.  
    			}
    			System.out.println("Out of while loop");
    			
    			}
    		
    	}catch(Exception e) {
    		e.printStackTrace(System.out);
    	}
    	
    	
    	
    	 
    	
    	
    }
    
    public static String[] processQuery(String entityName, String queryType, String entityType, Model model) {
    	/*
    	 * I need to alter this method from the original method. It should only need the queryType, 
    	 * entityName, and the type of question. It doesn't need to breakdown and parse an entire 
    	 * sentence. That can be done (and done faster) from the user Application reducing load on the 
    	 * server program. The result of the code execution will be a String[] Array of answers. 
    	 */
    	String[] answer = {"I don't know how to answer that"};//set default answer.
    	try {
    	//Handle a president query.
    	if(entityType.equalsIgnoreCase("President")) {
    		PrepPresidentQuery thisPres = new PrepPresidentQuery(entityName);
    		if(queryType.equalsIgnoreCase("deathDate")) {
    			String finalQuery = thisPres.birthDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("deathPlace")) {
    			String finalQuery = thisPres.deathPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthPlace")) {
    			String finalQuery = thisPres.birthPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthDate")) {
    			String finalQuery = thisPres.birthDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("battle")) {
    			String finalQuery = thisPres.battle();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("restingPlace")) {
    			String finalQuery = thisPres.restingPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("profession")) {
    			String finalQuery = thisPres.profession();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("president")) {
    			String finalQuery = thisPres.presidentUnder();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("almaMater")) {
    			String finalQuery = thisPres.almaMater();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("country")) {
    			String finalQuery = thisPres.country();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("party")) {
    			String finalQuery = thisPres.party();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("spouse")) {
    			String finalQuery = thisPres.spouse();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("religion")) {
    			String finalQuery = thisPres.religion();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("militaryBranch")) {
    			String finalQuery = thisPres.militaryBranch();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("serviceStartYear")) {
    			String finalQuery = thisPres.serviceStartYear();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("serviceEndYear")) {
    			String finalQuery = thisPres.serviceEndYear();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("militaryRank")) {
    			String finalQuery = thisPres.militaryRank();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("militaryCommand")) {
    			String finalQuery = thisPres.militaryCommand();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("successor")) {
    			String finalQuery = thisPres.successor();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("office")) {
    			String finalQuery = thisPres.office();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("activeYearsStartDate")) {
    			String finalQuery = thisPres.activeYearsStartDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("activeYearsEndDate")) {
    			String finalQuery = thisPres.activeYearsEndDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("vicePresident")) {
    			String finalQuery = thisPres.vicePresident();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("termPeriod")) {
    			String finalQuery = thisPres.termPeriod();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("child")) {
    			String finalQuery = thisPres.child();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("country")) {
    			String finalQuery = thisPres.country();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	//------------------------------------------------------------------------------------------------------
    	//Handle city queries 
    	else if(entityType.equalsIgnoreCase("City")) {
    		CityQuery thisCity = new CityQuery(entityName);
    		if(queryType.equalsIgnoreCase("nick")) {
    			String finalQuery = thisCity.nick();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("twinCity")) {
    			String finalQuery = thisCity.twinCity();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("area")) {
    			String finalQuery = thisCity.area();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("areaTotal")) {
    			String finalQuery = thisCity.areaTotal();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("areaLand")) {
    			String finalQuery = thisCity.areaLand();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("areaWater")) {
    			String finalQuery = thisCity.areaWater();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("leaderTitle")) {
    			String finalQuery = thisCity.leaderTitle();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("leaderName")) {
    			String finalQuery = thisCity.leaderName();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("governmentType")) {
    			String finalQuery = thisCity.governmentType();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("populationTotal")) {
    			String finalQuery = thisCity.populationTotal();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("populationMetro")) {
    			String finalQuery = thisCity.populationMetro();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("populationUrban")) {
    			String finalQuery = thisCity.populationUrban();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("populationDensity")) {
    			String finalQuery = thisCity.populationDensity();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("isPartOf")) {
    			String finalQuery = thisCity.isPartOf();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("type")) {
    			String finalQuery = thisCity.type();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("timeZone")) {
    			String finalQuery = thisCity.timeZone();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("motto")) {
    			String finalQuery = thisCity.motto();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("postalCode")) {
    			String finalQuery = thisCity.postalCode();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("areaCode")) {
    			String finalQuery = thisCity.areaCode();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		
    	}
    	//-----------------------------------------------------------------------------------------------------
    	//Handle Disease query
    	else if(entityType.equalsIgnoreCase("Disease")) {
    		DiseaseQuery thisDisease = new DiseaseQuery(entityName);
    		if(queryType.equalsIgnoreCase("abStract")) {
    			String finalQuery = thisDisease.abStract();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	//----------------------------------------------------------------------------------------------------
    	//Handle a state query. 
    	else if(entityType.equalsIgnoreCase("State")) {
    		StateQuery thisState = new StateQuery(entityName);
    		if(queryType.equalsIgnoreCase("abStract")) {
    			String finalQuery = thisState.abStract();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("demonym")) {
    			String finalQuery = thisState.demonym();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("largestCity")) {
    			String finalQuery = thisState.largestCity();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("language")) {
    			String finalQuery = thisState.language();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("capital")) {
    			String finalQuery = thisState.capital();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("country")) {
    			String finalQuery = thisState.country();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("areaTotal")) {
    			String finalQuery = thisState.areaTotal();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	//-----------------------------------------------------------------------------------------------------
    	//Handle a Country query
    	else if(entityType.equalsIgnoreCase("Country")) {
    		CountryQuery thisCountry = new CountryQuery(entityName);
    		if(queryType.equalsIgnoreCase("capital")) {
    			String finalQuery = thisCountry.capital();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("currency")) {
    			String finalQuery = thisCountry.currency();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("language")) {
    			String finalQuery = thisCountry.language();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("anthem")) {
    			String finalQuery = thisCountry.anthem();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("demonym")) {
    			String finalQuery = thisCountry.demonym();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("leaderName")) {
    			String finalQuery = thisCountry.leaderName();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("leaderTitle")) {
    			String finalQuery = thisCountry.leaderTitle();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("longName")) {
    			String finalQuery = thisCountry.longName();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("foundingDate")) {
    			String finalQuery = thisCountry.foundingDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("areaTotal")) {
    			String finalQuery = thisCountry.areaTotal();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("populationDensity")) {
    			String finalQuery = thisCountry.populationDensity();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("percentageOfAreaWater")) {
    			String finalQuery = thisCountry.percentageOfAreaWater();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("governmentType")) {
    			String finalQuery = thisCountry.governmentType();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("largestCity")) {
    			String finalQuery = thisCountry.largestCity();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("motto")) {
    			String finalQuery = thisCountry.motto();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		
    	}
    	//----------------------------------------------------------------------------------------------------
    	//Handle a BasketballPlayer query
    	else if(entityType.equalsIgnoreCase("BasketballPlayer")) {
    		BasketballPlayerQuery thisBasketballPlayer = new BasketballPlayerQuery(entityName);
    		if(queryType.equalsIgnoreCase("number")) {
    			String finalQuery = thisBasketballPlayer.number();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthDate")) {
    			String finalQuery = thisBasketballPlayer.birthDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthPlace")) {
    			String finalQuery = thisBasketballPlayer.birthPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("deathPlace")) {
    			String finalQuery = thisBasketballPlayer.deathPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("deathDate")) {
    			String finalQuery = thisBasketballPlayer.deathDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("height")) {
    			String finalQuery = thisBasketballPlayer.height();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("weight")) {
    			String finalQuery = thisBasketballPlayer.weight();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("draftTeam")) {
    			String finalQuery = thisBasketballPlayer.draftTeam();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("position")) {
    			String finalQuery = thisBasketballPlayer.position();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("activeYearsStartYear")) {
    			String finalQuery = thisBasketballPlayer.activeYearsStartYear();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("activeYearsEndYear")) {
    			String finalQuery = thisBasketballPlayer.activeYearsEndYear();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("college")) {
    			String finalQuery = thisBasketballPlayer.college();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("team")) {
    			String finalQuery = thisBasketballPlayer.team();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("draftYear")) {
    			String finalQuery = thisBasketballPlayer.draftYear();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("award")) {
    			String finalQuery = thisBasketballPlayer.award();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("abstract")) {
    			String finalQuery = thisBasketballPlayer.abStract();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	//-----------------------------------------------------------------------------------------------------
    	//Handle AmericanFootballPlayer query
    	else if(entityType.equalsIgnoreCase("AmericanFootballPlayer")) {
    		AmericanFootballPlayerQuery thisAmericanFootballPlayer = new AmericanFootballPlayerQuery(entityName);
    		if(queryType.equalsIgnoreCase("abstract")) {
    			String finalQuery = thisAmericanFootballPlayer.abStract();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthDate")) {
    			String finalQuery = thisAmericanFootballPlayer.birthDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthPlace")) {
    			String finalQuery = thisAmericanFootballPlayer.birthPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthPlace")) {
    			String finalQuery = thisAmericanFootballPlayer.birthPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("deathDate")) {
    			String finalQuery = thisAmericanFootballPlayer.deathDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("deathPlace")) {
    			String finalQuery = thisAmericanFootballPlayer.deathPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("activeYearsStartYear")) {
    			String finalQuery = thisAmericanFootballPlayer.activeYearsStartYear();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("activeYearsEndYear")) {
    			String finalQuery = thisAmericanFootballPlayer.activeYearsEndYear();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("draftYear")) {
    			String finalQuery = thisAmericanFootballPlayer.draftYear();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("draftRound")) {
    			String finalQuery = thisAmericanFootballPlayer.draftRound();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("draftPick")) {
    			String finalQuery = thisAmericanFootballPlayer.draftPick();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("draftTeam")) {
    			String finalQuery = thisAmericanFootballPlayer.draftTeam();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("formerTeam")) {
    			String finalQuery = thisAmericanFootballPlayer.formerTeam();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("position")) {
    			String finalQuery = thisAmericanFootballPlayer.position();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("number")) {
    			String finalQuery = thisAmericanFootballPlayer.number();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("team")) {
    			String finalQuery = thisAmericanFootballPlayer.team();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("height")) {
    			String finalQuery = thisAmericanFootballPlayer.height();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("weight")) {
    			String finalQuery = thisAmericanFootballPlayer.weight();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	//-----------------------------------------------------------------------------------------------------
    	//Handle a University query
    	else if(entityType.equalsIgnoreCase("University")) {
    		System.out.println("This is a University foo");
    		UniversityQuery thisUniversity = new UniversityQuery(entityName);
    		if(queryType.equalsIgnoreCase("abstract")) {
    			String finalQuery = thisUniversity.abStract();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("motto")) {
    			String finalQuery = thisUniversity.motto();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("president")) {
    			String finalQuery = thisUniversity.president();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("facultySize")) {
    			String finalQuery = thisUniversity.facultySize();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("numberOfStudents")) {
    			String finalQuery = thisUniversity.numberOfStudents();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("numberOfPostgraduateStudents")) {
    			String finalQuery = thisUniversity.numberOfPostgraduateStudents();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("numberOfUndergraduateStudents")) {
    			String finalQuery = thisUniversity.numberOfUndergraduateStudents();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("type")) {
    			String finalQuery = thisUniversity.type();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("city")) {
    			String finalQuery = thisUniversity.city();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("state")) {
    			String finalQuery = thisUniversity.state();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("country")) {
    			String finalQuery = thisUniversity.country();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("officialSchoolColour")) {
    			String finalQuery = thisUniversity.officialSchoolColour();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("nick")) {
    			String finalQuery = thisUniversity.nick();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("mascot")) {
    			String finalQuery = thisUniversity.mascot();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("homepage")) {
    			String finalQuery = thisUniversity.homepage();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		
    	}
    	//---------------------------------------------------------------------------------------
    	//Handle a VideoGame query
    	else if(entityType.equalsIgnoreCase("VideoGame")) {
    		VideoGameQuery thisVideoGame = new VideoGameQuery(entityName);
    		if(queryType.equalsIgnoreCase("developer")) {
    			String finalQuery = thisVideoGame.developer();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("genre")) {
    			String finalQuery = thisVideoGame.genre();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("computingPlatform")) {
    			String finalQuery = thisVideoGame.computingPlatform();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("publisher")) {
    			String finalQuery = thisVideoGame.publisher();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("director")) {
    			String finalQuery = thisVideoGame.director();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("composer")) {
    			String finalQuery = thisVideoGame.composer();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("distributor")) {
    			String finalQuery = thisVideoGame.distributor();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("designer")) {
    			String finalQuery = thisVideoGame.designer();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("series")) {
    			String finalQuery = thisVideoGame.series();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("gameArtist")) {
    			String finalQuery = thisVideoGame.gameArtist();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("writer")) {
    			String finalQuery = thisVideoGame.writer();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("lastestReleaseVersion")) {
    			String finalQuery = thisVideoGame.lastestReleaseVersion();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("releaseDate")) {
    			String finalQuery = thisVideoGame.releaseDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("gameEngine")) {
    			String finalQuery = thisVideoGame.gameEngine();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("requirement")) {
    			String finalQuery = thisVideoGame.requirement();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	//---------------------------------------------------------------------------------------
    	//Handle Boxer queries 
    	else if(entityType.equalsIgnoreCase("Boxer")) {
    		BoxerQuery thisBoxer = new BoxerQuery(entityName);
    		System.out.println("This is a Boxer");
    		if(queryType.equalsIgnoreCase("abstract")) {
    			String finalQuery = thisBoxer.abStract();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthPlace")) {
    			String finalQuery = thisBoxer.birthPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthDate")) {
    			String finalQuery = thisBoxer.birthDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("deathDate")) {
    			String finalQuery = thisBoxer.deathDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("deathPlae")) {
    			String finalQuery = thisBoxer.deathPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("height")) {
    			String finalQuery = thisBoxer.height();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("weight")) {
    			String finalQuery = thisBoxer.weight();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("nationality")) {
    			String finalQuery = thisBoxer.nationality();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("nick")) {
    			String finalQuery = thisBoxer.nick();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	//-------------------------------------------------------------------------------------
    	//Handle a ProgrammingLanguage query
    	else if(entityType.equalsIgnoreCase("ProgrammingLanguage")) {
    		ProgrammingLanguageQuery thisProgrammingLanguage = new ProgrammingLanguageQuery(entityName);
    		System.out.println("This is a Boxer");
    		if(queryType.equalsIgnoreCase("abstract")) {
    			String finalQuery = thisProgrammingLanguage.abStract();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("developer")) {
    			String finalQuery = thisProgrammingLanguage.developer();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("influencedBy")) {
    			String finalQuery = thisProgrammingLanguage.influencedBy();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("influenced")) {
    			String finalQuery = thisProgrammingLanguage.influenced();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("designer")) {
    			String finalQuery = thisProgrammingLanguage.designer();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("latestReleaseVersion")) {
    			String finalQuery = thisProgrammingLanguage.latestReleaseVersion();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("license")) {
    			String finalQuery = thisProgrammingLanguage.license();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	//---------------------------------------------------------------------------------
    	//Handle a Book query 
    	else if(entityType.equalsIgnoreCase("Book")) {
    		BookQuery thisBook = new BookQuery(entityName);
    		System.out.println("This is a Book query");
    		if(queryType.equalsIgnoreCase("abstract")) {
    			String finalQuery = thisBook.abStract();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("author")) {
    			String finalQuery = thisBook.author();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("isbn")) {
    			String finalQuery = thisBook.isbn();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("language")) {
    			String finalQuery = thisBook.language();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("country")) {
    			String finalQuery = thisBook.country();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("literaryGenre")) {
    			String finalQuery = thisBook.literaryGenre();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("publisher")) {
    			String finalQuery = thisBook.publisher();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("mediaType")) {
    			String finalQuery = thisBook.mediaType();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("numberOfPages")) {
    			String finalQuery = thisBook.numberOfPages();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	//---------------------------------------------------------------------------------------
    	//Handle a MilitaryConflict query 
    	else if(entityType.equalsIgnoreCase("MilitaryConflict")) {
    		MilitaryConflictQuery thisMilitaryConflict = new MilitaryConflictQuery(entityName);
    		if(queryType.equalsIgnoreCase("abstract")) {
    			String finalQuery = thisMilitaryConflict.abStract();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("place")) {
    			String finalQuery = thisMilitaryConflict.place();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("date")) {
    			String finalQuery = thisMilitaryConflict.date();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("commander")) {
    			String finalQuery = thisMilitaryConflict.commander();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("territory")) {
    			String finalQuery = thisMilitaryConflict.territory();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("result")) {
    			String finalQuery = thisMilitaryConflict.result();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("combatant")) {
    			String finalQuery = thisMilitaryConflict.combatant();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("strength")) {
    			String finalQuery = thisMilitaryConflict.strength();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("causalties")) {
    			String finalQuery = thisMilitaryConflict.causalties();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	//------------------------------------------------------------------------------------
    	//Handle a musical artist query 
    	else if(entityType.equalsIgnoreCase("MusicalArtist")) {
    		MusicalArtistQuery thisMusicalArtist = new MusicalArtistQuery(entityName);
    		if(queryType.equalsIgnoreCase("abstract")) {
    			String finalQuery = thisMusicalArtist.abStract();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("background")) {
    			String finalQuery = thisMusicalArtist.background();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthDate")) {
    			String finalQuery = thisMusicalArtist.birthDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("birthPlace")) {
    			String finalQuery = thisMusicalArtist.birthPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("deathDate")) {
    			String finalQuery = thisMusicalArtist.deathDate();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("deathPlace")) {
    			String finalQuery = thisMusicalArtist.deathPlace();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("instrument")) {
    			String finalQuery = thisMusicalArtist.instrument();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("genre")) {
    			String finalQuery = thisMusicalArtist.genre();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("occupation")) {
    			String finalQuery = thisMusicalArtist.occupation();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("activeYearsStartYear")) {
    			String finalQuery = thisMusicalArtist.activeYearsStartYear();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("activeYearsEndYear")) {
    			String finalQuery = thisMusicalArtist.activeYearsEndYear();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    		else if(queryType.equalsIgnoreCase("recordLabel")) {
    			String finalQuery = thisMusicalArtist.recordLabel();
    			answer = QuerySparqlSearchEngine.executeQuery(finalQuery, queryType, model);
    		}
    	}
    	
    	}catch(Exception e) {
    		answer[0] = "There was an error processing that question";
    	}
    	
    	return answer;
    	
}
    
}
