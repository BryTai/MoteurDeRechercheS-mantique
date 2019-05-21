package graphsVisualisation;

import java.nio.file.Path;
import java.util.List;


public class Document {
	private String name;
	private Path filepath;
	private List<Concept> cpt;

	public Document (String name, Path filepath, List< Concept> cpt) {
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

	public List<Concept> getCpt() {
		return cpt;
	}

	public void setCpt(List<Concept> cpt) {
		this.cpt = cpt;
	}
}
