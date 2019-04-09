package graphsVisualisation;

import java.util.ArrayList;
//Classe représentant les concepts des ontoterminologies
public class Concept {
	
	//Attributs
	private String name;
	private String urlImage;
	private ArrayList<Difference> caracEssentielles;
	private ArrayList<Concept> isA;

	//Constructeurs	
	public Concept() {
		this.setName("");
		this.caracEssentielles = new ArrayList<Difference>();
		this.isA = new ArrayList<Concept>();
	}

	//Getters / Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Difference> getCaracEssentiels() {
		return caracEssentielles;
	}

	public void setCaracEssentiels(ArrayList<Difference> caracEssentiels) {
		this.caracEssentielles = caracEssentiels;
	}


	


	public ArrayList<Concept> getIsA() {
		return isA;
	}


	public void setIsA(ArrayList<Concept> isA) {
		this.isA = isA;
	}

	public String getUrlImage() {
		return urlImage;
	}



	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	//@Override
	
	public String toString() {
		String res = new String();
		res =  res +"Name: " + this.getName() +"\n";
		res = res +"Url: " + this.getUrlImage() +"\n";
		res = res +"CaractÃ©ristiques essentielles: " ;
		for(Difference diff : this.getCaracEssentiels()) {
			res = res + ", " + diff.getName();
		}
		res = res + "\nIs A : " ;
		for(Concept cpt : this.getIsA()) {
			res = res + cpt.getName() +", ";
		}

		return res;
	}
}
