package graphsVisualisation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

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
//		int i = 0;
//		boolean trouve = false;
		search_bar_content = main_frame.getSearchBarText();

//		ParserOnto parser = new ParserOnto("./ressources/clean_data.json");
//		HashMap<String,ArrayList<String>> cpt_term = parser.cpt_trm();
//		HashMap<String, Concept> cpt = parser.lesConcepts(); 
//		HashMap<String, Terme> term = parser.lesTermes(cpt);
//		ArrayList<String> lesTermes = cpt_term.get(cpt.get(i));
//		
//		
//		System.out.println("TEST1");
//		System.out.println(term.get(lesTermes.get(i)).getName());
		
		
//		while (trouve){
//			System.out.println("TEST2");
//			cpt_term.get(cpt.get(i));
//			if (search_bar_content == term.get(lesTermes.get(i)).getName()){
//				
//				//ACCES AUX DOCS
//				System.out.println("TEST3");
//				trouve = true;
//
//			}else {
				try {
					Indexation.searchIndex(search_bar_content);
				} catch (IOException | ParseException | org.apache.lucene.queryParser.ParseException e) {
					e.printStackTrace();
				}
				System.out.println(search_bar_content);
			}


			//}

//		search_bar_content = main_frame.getSearchBarText();

	}
//}
