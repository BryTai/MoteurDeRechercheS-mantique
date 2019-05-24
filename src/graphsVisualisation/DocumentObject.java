package graphsVisualisation;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DocumentObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String filepath;
	private List<Concept> cpt;

	public DocumentObject (String name, String filepath, List< Concept> cpt) {
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
		return Paths.get(filepath);
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public List<Concept> getCpt() {
		return cpt;
	}

	public void setCpt(List<Concept> cpt) {
		this.cpt = cpt;
	}
}
