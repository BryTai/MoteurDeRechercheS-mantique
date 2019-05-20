package graphsVisualisation;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

@SuppressWarnings("unused")
public class GraphsMain {
	/**
	 * The entry point of the program
	 * @param args: Arguments of the main method
	 */
	public static void main(String[] args) {
		try {
			Indexation.createIndex();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ParserOnto parser = new ParserOnto("./ressources//clean_data.json");
		HashMap<String, Concept> lesCpts = parser.lesConcepts();
		HashMap<String, Terme> lestrm = parser.lesTermes(lesCpts);
		HashMap<String, ArrayList<String>> cpt_term = parser.cpt_trm();
		new VisualisationJFrame(cpt_term, lesCpts, lestrm);
		
		//new UploadJFrame();
		
//		try {
//			//Error Initialize
//			ParserOnto parser = new ParserOnto("./ressources//clean_data.json");
//			//System.out.println(parser.toString());
//			//HashMap<String, Concept> lesCpts = parser.lesConcepts();
//			//HashMap<String, Terme> lestrm = parser.lesTermes(lesCpts);
//			HashMap<String, ArrayList<String>> cpt_term = parser.cpt_trm();
//			for(Entry<String, ArrayList<String>> cptTerm : cpt_term.entrySet()) {
//				System.out.print(cptTerm.getKey() +" --> "+cptTerm.getValue().toString() +"\n");
//			}
//			
//			
//			//System.out.println("Les concepts :" + lesCpts.toString());
//			//System.out.println("Les termes :" + lestrm.toString());
//		
//		}catch (Exception e ){
//			e.printStackTrace();
//		}
	}
}
