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
		try {
			Indexation.createIndex();

		} catch (IOException e) { 
			e.printStackTrace();
		}

		new VisualisationJFrame();
					
		
	}
}
