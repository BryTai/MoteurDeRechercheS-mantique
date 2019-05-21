package graphsVisualisation;

import java.nio.file.Path;
import java.util.ArrayList;


public class Document {
	private String name;
	private Path filepath;
	private ArrayList<Concept> cpt;

	public Document (String name, Path filepath, ArrayList< Concept> cpt) {
		this.name = name;
		this.filepath = filepath;
		this.cpt = cpt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Path getFilepath() {
		return filepath;
	}

	public void setFilepath(Path filepath) {
		this.filepath = filepath;
	}

	public ArrayList<Concept> getCpt() {
		return cpt;
	}

	public void setCpt(ArrayList<Concept> cpt) {
		this.cpt = cpt;
	}
}
