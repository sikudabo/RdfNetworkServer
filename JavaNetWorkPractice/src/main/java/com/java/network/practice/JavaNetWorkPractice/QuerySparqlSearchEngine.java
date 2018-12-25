package com.java.network.practice.JavaNetWorkPractice;
import org.apache.jena.util.FileManager;



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

import java.io.File;
import java.lang.ClassCastException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuerySparqlSearchEngine {
	
	
	
	public static String[] executeQuery(String stringQuery, String queryType, Model model) {
		String answer;
		ArrayList<String> answers = new ArrayList<String>();
		Query query = QueryFactory.create(stringQuery);
    	QueryExecution qexec = QueryExecutionFactory.create(query, model);
    	ResultSet results = qexec.execSelect();
    	List<String> vars = results.getResultVars();
    	System.out.println(results);
    	if(!(results.hasNext())) {
    		answers.add("No results!");
    		String[] b = new String[answers.size()];
    		String[] a = (String[])answers.toArray(b);
    		return a;
    	}
    	else {
    		Literal answerLiteral;
    		Resource answerResource;
    		while(results.hasNext()) {
    			
    		
        		QuerySolution soln = results.nextSolution();
        		try {
        		answerLiteral = soln.getLiteral(queryType);
        		String answerLiteralString = answerLiteral.toString();
        		System.out.println(answerLiteralString);
        		String[] answerSplitter = answerLiteralString.split("/");
        		if(queryType.equals("serviceStartYear") || queryType.equals("serviceEndYear") || queryType.equals("activeYearsStartDate") || queryType.equals("activeYearsEndDate") || queryType.equals("birthDate") || queryType.equals("deathDate")) {
        			String[] specialSplitter = answerLiteralString.split("^^");
        			String toSplit = specialSplitter[0];
        			String[] splitMore = toSplit.split(">");
        			String formattedSpecial = splitMore[splitMore.length - 1];
        			answer = formattedSpecial.replace("\"", "");
        			answer = answer.replace("^^http://www.w3.org/2001/XMLSchema#date", "");
        			answers.add(answer);
        		}
        		else if(queryType.equals("weight") || queryType.equals("height")){
                    if(queryType.equals("weight")){
                        try {
                            String[] specialSplitter = answerLiteralString.split("^^");
                            System.out.println(Arrays.toString(specialSplitter));
                            String toSplit = specialSplitter[0];
                            String[] splitMore = toSplit.split(">");
                            String formattedSpecial = splitMore[splitMore.length - 1];
                            answer = formattedSpecial.replace("\"", "");
                            answer = answer.replace("^^http://www.w3.org/2001/XMLSchema#double", "");
                            double num = Double.parseDouble(answer);
                            double weight = num * .0022;
                            String w = String.valueOf(weight);
                            answers.add(w + " pounds");
                        }catch(Exception e){
                            answers.add("Could not calculate weight");
                        }
                    }
                    else if(queryType.equals("height")){
                        //Multiply meters by 3.28084
                        try{
                            String[] specialSplitter = answerLiteralString.split("^^");
                            System.out.println(Arrays.toString(specialSplitter));
                            String toSplit = specialSplitter[0];
                            String[] splitMore = toSplit.split(">");
                            String formattedSpecial = splitMore[splitMore.length - 1];
                            answer = formattedSpecial.replace("\"", "");
                            answer = answer.replace("^^http://www.w3.org/2001/XMLSchema#double", "");
                            System.out.println(answer);
                            double num = Double.parseDouble(answer);
                            double height = num * 3.28084;
                            String h = String.valueOf(height);
                            int addInch = Integer.valueOf(String.valueOf(h.charAt(2))) + 1;
                            String feet = String.valueOf(h.charAt(0));
                            String inches = String.valueOf(addInch);
                            answers.add(feet + " feet " + inches + " inches.");
                        }catch(Exception e){
                            answers.add("Could not calculate height");
                        }
                    }
        		}
        		else if(answerLiteralString.contains("http://www.w3.org/2001/XMLSchema")) {
        			String formatOneAnswer = answerSplitter[0];
        			answer = formatOneAnswer;
        			answer = answer.replace("^^http:", "");
        			answers.add(answer);
        		}
        		
        		else if(answerLiteralString.contains("^^http://dbpedia.org/datatype/usDollar")) {
        			String formatOneAnswer = answerSplitter[0];
        			answer = formatOneAnswer;
        			answer = answer.replace("^^http://dbpedia.org/datatype/usDollar", "");
        			answer = answer.replace("^^http:", "");
        			answers.add(answer);
        		}
        		else {
        		String formatOneAnswerLiteral = answerSplitter[answerSplitter.length - 1].replace("_", " ");
        		answer = formatOneAnswerLiteral.replace("@en", "");
        		answers.add(answer);
        		}
        		}
        		catch(ClassCastException e) {
        		answerResource = soln.getResource(queryType);
        		String answerLiteralString = answerResource.toString();
        		if(answerLiteralString.contains("http://www.w3.org/2001/XMLSchema")) {
        			String[] answerSplitter = answerLiteralString.split("^");
        			answer = answerSplitter[0];
        			answer = answer.replaceAll("^^http:", "");
        			answers.add(answer);
        		}
        		else {
        		String[] answerSplitter = answerLiteralString.split("/");
        		String formatOneAnswerLiteral = answerSplitter[answerSplitter.length - 1].replace("_", " ");
        		answer = formatOneAnswerLiteral.replace("@en", "");
        		answers.add(answer);
        		}
        		}
    		}
	}
    	String[] e = new String[answers.size()];
    	String[] g = (String[])answers.toArray(e);
    	return g;
	}

}
