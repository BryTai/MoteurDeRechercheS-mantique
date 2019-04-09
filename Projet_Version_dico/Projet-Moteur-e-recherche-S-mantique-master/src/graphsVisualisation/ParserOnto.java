package graphsVisualisation;

import com.google.gson.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class ParserOnto {
	
	// Attributs
	
	//Le chemin d'accès au Json
	private String path; 
	
	private JsonParser parser;
	
	private Object obj;
	
	private JsonObject jsonObj;
	
	private Gson myGson;
	
	//Constructeur
	public ParserOnto() {
		this.setPath("");
		this.setMyGson(new Gson());
	}
	
	public ParserOnto(String path) {
		this.setPath(path);
		this.setMyGson(new Gson());
		try {
			initialize();
		}catch(IOException e) {
			System.err.println("Error initialize constructor");
		}
	}
	
	
	//Getters / setters
	public String getPath() { return this.path; }
	
	public void setPath(String path) { this.path = path; }
	
	public Object getObj() { return this.obj; }
	
	public void setObj(Object obj) { this.obj = obj ; }
	
	public JsonObject getJsonObj() { return this.jsonObj; } 
	
	public void setJsonObj (JsonObject jsonObj) { this.jsonObj = jsonObj;}
	
	public Gson getMyGson() {return myGson;}

	public void setMyGson(Gson myGson) {this.myGson = myGson;}
	
	//Initialisation
	public void initialize() throws IOException {
		this.parser = new JsonParser();
		try {
			this.obj = parser.parse(new FileReader(this.getPath()));
			this.jsonObj = (JsonObject) obj;
		}catch(IOException e) {
			System.err.print("Error initialize");
		}
	}
//*************************************************************************************************************************

	//@Override
	
	public String toString() {
		String res = new String();
		res = res + "Path : " + this.getPath() +" \n";
		res = res + "My Gson : "+ this.getMyGson() + "\n";
		return res;
	}
	
	
	//Méthode de parsing
	
	
//*************************************************************************************************************************
	//New Parsing
	public HashMap<String, Concept> lesConcepts(){
		//Le dictionnaire qui contiendra les concepts
		HashMap<String, Concept> dicoConcept = new HashMap<String, Concept>();
		
		//Le dictionnaire qui contiendra les différences
		HashMap<String, Difference> dicoDifference = new HashMap<String, Difference>();
		//L'objet Json contenant la data de tout les concepts du fichier
		JsonObject concept = this.getJsonObj().getAsJsonObject("concepts");
		
		//L'objet Json contenant la data de toutes les différences du fichier
		JsonObject differences = this.getJsonObj().getAsJsonObject("differences");
		
		//On créer un dictionnaire pour chaque différence pour aller plus vite a l'accession
		for(Entry<String, JsonElement> diff : differences.entrySet()) {
			Difference diffEnCours = new Difference();
			diffEnCours = this.getMyGson().fromJson(diff.getValue(), Difference.class);
			diffEnCours.setId(diff.getKey());		
			dicoDifference.put(diff.getKey(), diffEnCours);
		}
		
		//On générer une map contenant les clés et les valeurs des clés de l'objet des concepts 
		for(Entry<String, JsonElement> cpt : concept.entrySet()) {
			
				
			//Le concept qui sera ajouté a la liste
			Concept cptEnCours = new Concept();
			cptEnCours = this.getMyGson().fromJson(cpt.getValue(), Concept.class);
			cptEnCours.setId(cpt.getKey());
				
			//On ajoute les instances des différences correspondantes dans la liste
			for(String ownDiff : cptEnCours.getOwnDifferences()) {
				cptEnCours.getDiff().add(dicoDifference.get(ownDiff));
			}
			for(String inhDiff : cptEnCours.getInheritedDifferences()) {
				cptEnCours.getDiff().add(dicoDifference.get(inhDiff));
			}
			dicoConcept.put(cpt.getKey(), cptEnCours);
		}
		return dicoConcept;
		
	}
		
	
//*************************************************************************************************************************
	public HashMap<String, Terme> lesTermes(HashMap<String, Concept> dicoCPT){
		HashMap<String, Terme> dicoTerme = new HashMap<String, Terme>();
		
		JsonObject langue = this.getJsonObj().getAsJsonObject("languages");
		
		
		for(Entry<String, JsonElement> lg : langue.entrySet()) {
			for(Entry<String, JsonElement> trm : langue.getAsJsonObject(lg.getKey()).entrySet()) {
				Terme termeEnCours = new Terme();
				termeEnCours = this.getMyGson().fromJson(trm.getValue(), Terme.class);
				
				for(String cpt : termeEnCours.getConcepts()) {
					termeEnCours.getAssociation().add(dicoCPT.get(cpt));
				}
				termeEnCours.setLangue(lg.getKey());
				dicoTerme.put(trm.getKey(), termeEnCours);
			}
		}
		
		return dicoTerme;
	}
	
//*************************************************************************************************************************
	
	//Parsing des concepts
	
	
	//Parsing d'un concept en particulier
	//WARNING: récurrence du parsing des concepts 
//	//TODO: a optimiser
//	public Concept getConcept(String cpt) {
//		//L'objet Json contenant la data de toutes les différences du fichier
//		JsonObject differences = this.getJsonObj().getAsJsonObject("differences");
//		Concept conceptEnCours = myGson.fromJson(this.getJsonObj().getAsJsonObject("concepts").get(cpt),Concept.class);
//		
//		//On récupère l'objet Json du conceptCourant
//		JsonObject unConcept = this.getJsonObj().getAsJsonObject("concepts").getAsJsonObject(cpt);
//		
//		//On récupère le tableau isa du concept
//		JsonArray isA = unConcept.getAsJsonArray("isa");
//		
//		//On doit parser tout les concepts présent dans le tableau, pour pouvoir ensuite les comparer dans le modèle java
//		for(JsonElement is : isA) {
//			conceptEnCours.getIsA().add((this.getConcept(is.getAsString())));
//		}
//		
//		//On fait de meme pour les différences
//		JsonArray owndiff = unConcept.getAsJsonArray("ownDifferences");
//		for(JsonElement diff : owndiff) {
//			conceptEnCours.getCaracEssentiels().add(myGson.fromJson(differences.getAsJsonObject(diff.getAsString()), Difference.class));
//		
//		}
//		
//		JsonArray inheritedDiff = unConcept.getAsJsonArray("inheritedDifferences");
//		for(JsonElement diff : inheritedDiff) {
//			conceptEnCours.getCaracEssentiels().add(myGson.fromJson(differences.getAsJsonObject(diff.getAsString()), Difference.class));
//	}
//		return conceptEnCours;
//	}
//	
//	//Parsing de tout les concepts
//	
//	
//	public ArrayList<Concept> getJsonConcept() throws IOException {
//		//La liste de tout les concepts
//		ArrayList<Concept> listeConcept = new ArrayList<Concept>();
//		
//		//L'objet Json contenant la data de tout les concepts du fichier
//		JsonObject concept = this.getJsonObj().getAsJsonObject("concepts");
//		
//		//L'objet Json contenant la data de toutes les différences du fichier
//		@SuppressWarnings("unused")
//		JsonObject differences = this.getJsonObj().getAsJsonObject("differences");
//		
//		
//		//On générer une map contenant les clés et les valeurs des clés de l'objet des concepts 
//		for(Entry<String, JsonElement> cpt : concept.entrySet()) {
//			//Le concept qui sera ajouté a la liste
//			listeConcept.add(this.getConcept(cpt.getKey()));
//		}
//		return listeConcept;
//		
//	}
//	
//	
//	//Methode de parsing des différences
//	
//	//Voir le parsing des concepts
//	//template de parsing myGson.fromJson(differences.getAsJsonObject(diff.getAsString()), Difference.class)
//	// differences = JsonObject des différences du json
//	// diff.getAsString() = clé de la différence
//	
//	//Parsing des termes 
//	
//	
//	//Parsing d'un terme en particulier
//	
//	public Terme getTerme(String trm,String langue) {
//		Terme terme = new Terme();
//		
//		JsonObject aTerme = this.getJsonObj().getAsJsonObject("languages").getAsJsonObject(langue).getAsJsonObject(trm);
//		terme = myGson.fromJson(aTerme, Terme.class);
//		terme.setLangue(langue);
//		JsonArray concepts = aTerme.getAsJsonArray("concepts");
//	
//		for(JsonElement cpt : concepts) {
//			terme.getAssociation().add(this.getConcept(cpt.getAsString()));
//		}
//		return terme;
//	}
//	
//	
//	
//	//Parsing de tout les termes
//	public ArrayList<Terme> getJsonTerme(){
//		ArrayList<Terme> listOfTerm = new ArrayList<Terme>();
//		
//		JsonObject langue = this.getJsonObj().getAsJsonObject("languages");
//		
//		
//		for(Entry<String, JsonElement> lg : langue.entrySet()) {
//			String langueEncours = lg.getKey();
//			for(Entry<String, JsonElement> trm : langue.getAsJsonObject(lg.getKey()).entrySet()) {
//				listOfTerm.add(this.getTerme(trm.getKey(), langueEncours));
//			}
//		}
//			
//		
//		return listOfTerm;
//	}
}
