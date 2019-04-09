package graphsVisualisation;

public class Difference {
	//Attributs
	private String name;
	private String internationalName;
	
	//Constructeur 
	
	public Difference() {
		this.setName(new String());
		this.setInternationalName(new String());
	}
	
	public Difference(String name,String internationalName) {
		this.setInternationalName(internationalName);
		this.setName(name);
	}
	
	
	//Getters & Setters
	public String getName() {
		return this.name;
	}
	
	public String getInternationalName() {
		return this.internationalName;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	public void setInternationalName(String newName) {
		this.internationalName = newName;
	}
	
	
	//@Ovveride
	
	public String toString() {
		String res = new String();
		
		res = "name :"+this.name +"\ninternational name : " + this.internationalName;
		return res;
	}
}
