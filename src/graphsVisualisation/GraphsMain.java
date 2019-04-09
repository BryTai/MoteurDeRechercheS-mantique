package graphsVisualisation;

import com.google.*;
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
	public static void main(String[] args) {
		new VisualisationJFrame();
		
		
		/*try {
			ParserOnto parser = new ParserOnto("ressources/clean_data.JSON");
			ArrayList<Concept> ListOfConcept = new ArrayList<Concept>();
			ListOfConcept = parser.getJsonConcept();
			ArrayList<Terme> ListOfTerme = new ArrayList<Terme>();
			ListOfTerme = parser.getJsonTerme();
			for(int i =0 ; i < ListOfTerme.size(); i++) {
				System.out.println("---------------------"+i+"---------------------");
				System.out.println(ListOfTerme.get(i).toString());
				
			}				
		}catch (Exception e ){
			e.printStackTrace();
		}*/
		
			
		
	}
}
