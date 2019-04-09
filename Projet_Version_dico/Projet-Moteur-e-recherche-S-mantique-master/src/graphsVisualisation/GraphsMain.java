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
		
		
		try {
			//Error Initialize
			//ParserOnto parser = new ParserOnto("//home//pierre//eclipse-workspace//Projet-Moteur-e-recherche-S-mantique-master.zip_expanded//Projet-Moteur-e-recherche-S-mantique-master//ressources//clean_data.json");
			//System.out.println(parser.toString());
			//HashMap<String, Concept> lesCpts = parser.lesConcepts();
			//HashMap<String, Terme> lestrm = parser.lesTermes(lesCpts);
			
			//System.out.println("Les concepts :" + lesCpts.toString());
			//System.out.println("Les termes :" + lestrm.toString());
		
		}catch (Exception e ){
			e.printStackTrace();
		}
		
			
		
	}
}
