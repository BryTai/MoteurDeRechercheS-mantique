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
		HashMap<String, Concept> cpt = parser.lesConcepts();
		HashMap<String, Terme> term = parser.lesTermes(cpt);
		HashMap<String, ArrayList<String>> cpt_term = parser.cpt_trm();
		//new VisualisationJFrame(cpt, term, cpt_term);
		new DocumentListFrame();
		//new DocumentFrame();
	}
}
