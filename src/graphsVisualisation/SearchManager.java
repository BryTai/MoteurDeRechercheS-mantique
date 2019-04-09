package graphsVisualisation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class SearchManager is a class that manages the interactions between the search bar, the search button
 * and the results of the research that are printed on the interface.
 */
public class SearchManager implements ActionListener {
	//The main JFrame
	private VisualisationJFrame main_frame;
	
	//The content of the research of the user
	private String search_bar_content;
	
	/**
	 * SearchManager(VisualisationJFrame f) is the main constructor of the class SearchManager.
	 * @param f: a GraphVisualisationJFrame instance (the main interface)
	 */
	public SearchManager(VisualisationJFrame f) {
		this.main_frame = f;
	}

	/**
	 * actionPerformed(ActionEvent evt) is a method implemented from the interface ActionListener that permits to
	 * manage the interactions between the use of the search button and the "printing" of the results of the search
	 * on the main interface.
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		search_bar_content = main_frame.getSearchBarText();
		System.out.println(search_bar_content);
	}
}
