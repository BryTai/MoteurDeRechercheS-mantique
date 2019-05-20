package graphsVisualisation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Manages the interactions between the search bar, the search button
 * and the results of the research that are printed on the interface.
 */
public class SearchManager implements ActionListener {
	//The main JFrame
	private VisualisationJFrame main_frame;
	
	//The content of the research of the user
	private String search_bar_content;
	
	/**
	 * Main constructor
	 * @param f: a JFrame instance (the main interface)
	 */
	public SearchManager(VisualisationJFrame f) {
		this.main_frame = f;
	}

	/**
	 * Manages the interactions between the use of the search button and the 
	 * "printing" of the results of the search on the main interface.
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
//		int i = 0;
//		boolean trouve = false;
		search_bar_content = main_frame.getSearchBarText();

		try {
			Indexation.searchIndex(search_bar_content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(search_bar_content);
	}
}

