package graphsVisualisation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * The interface to make a document indexable
 */
public class DocumentFrame extends JFrame {
	private static final long serialVersionUID = 6155703812504294146L;

	//Constants for the frame
	private final short WIDTH = 400;
	private final short HEIGHT = 600;
	private final String MAIN_TITLE = "Documents";
	private final boolean IS_VISIBLE = true;
	private final boolean IS_RESIZABLE = false;
	private final String MAIN_ICON_PATH = "ressources/logo.png";

	//Constants for the label
	private final String DOCUMENT_LABEL_NAME = "Document";
	private final String DOCUMENT_NAME_PREFIX = "Nom : ";
	private final String DOCUMENT_PATH_PREFIX = "Path : ";
    private final byte TITLE_SIZE = 25;
    private final String TITLE_FONT = "Georgia";
	
	//Constants for the button
	private final String SUBMIT_BUTTON_TEXT = "Télécharger";
	
	//Constants for the dimensions
	private final short DOCUMENT_PANEL_X = WIDTH;
	private final short DOCUMENT_PANEL_Y = 5*HEIGHT/20;

	private final short CONCEPT_PANEL_X = WIDTH;
	private final short CONCEPT_PANEL_Y = HEIGHT-DOCUMENT_PANEL_Y;
	
	private final short DOCUMENT_LABEL_X = WIDTH;
	private final short DOCUMENT_LABEL_Y = 2*DOCUMENT_PANEL_Y/5;
	
	private final short DOCUMENT_NAME_X = (WIDTH-30)/10;
	private final short DOCUMENT_NAME_Y = DOCUMENT_PANEL_Y/4;

	private final short DOCUMENT_PATH_X = WIDTH-30;
	private final short DOCUMENT_PATH_Y = DOCUMENT_PANEL_Y/4;

	private final short CONCEPTS_PANEL_X = WIDTH;
	private final short CONCEPTS_PANEL_Y = HEIGHT-DOCUMENT_PANEL_Y;

	private final short CONCEPTS_VIEW_X = CONCEPTS_PANEL_X-30;
	private final short CONCEPTS_VIEW_Y = 11*CONCEPTS_PANEL_Y/14;
	
	private final short DOCUMENT_INPUT_X = WIDTH-30-DOCUMENT_NAME_X;
	private final short DOCUMENT_INPUT_Y = 3*DOCUMENT_NAME_Y/5;
	
	//Constants for the border
	private final String CONCEPTS_BORDER_TEXT = "Concepts";
	
	//UploadJFrame
	@SuppressWarnings("unused")
	private UploadJFrame upload_frame;
		
	//Icons
	private ImageIcon main_icon;
		
	//JLabels
	private JLabel document_label;
	private JLabel document_name;
	private JLabel document_path;
	
	//JPanel
	private JPanel document_panel;
	private JPanel concepts_panel;

	//JTextFields
	private JTextField document_input_name;

	//JButtons
	private JButton submit_button;
	
	//Borders
	private Border concept_panel_border;
	
	//DefaultListModel
	private DefaultListModel<String> concepts_list_model;
	
	//JLists
	private JList<String> concepts_list;
	
	//JScrollPane
	private JScrollPane concepts_view;
	
	//Layouts
	private FlowLayout main_layout;
	
	//Dimensions
	private Dimension document_panel_dimension;
	private Dimension concept_panel_dimension;
	private Dimension document_label_dimension;
	private Dimension document_name_dimension;
	private Dimension document_path_dimension;
	private Dimension concepts_view_dimension;
	private Dimension document_input_dimension;
	
	//Fonts
	private Font title_font;
	
	//TODO à enlever
	public DocumentFrame() {
		new DocumentFrame(null);
	}
	
	/**
	 * Main constructor
	 * @param upload_frame: the upload/download interface
	 */
	public DocumentFrame(UploadJFrame upload_frame) {
		//Initialization
		this.upload_frame = upload_frame;
		
		this.document_panel = new JPanel();
		this.concepts_panel = new JPanel();
		
		this.document_label = new JLabel(DOCUMENT_LABEL_NAME);
		this.document_name = new JLabel(DOCUMENT_NAME_PREFIX);
		this.document_path = new JLabel(DOCUMENT_PATH_PREFIX);
		
		this.document_input_name = new JTextField();
		
		this.submit_button = new JButton(SUBMIT_BUTTON_TEXT);
		
		this.concept_panel_border = BorderFactory.createTitledBorder(CONCEPTS_BORDER_TEXT);

		this.concepts_list_model = new DefaultListModel<String>();
		this.getConcepts();
		this.concepts_list = new JList<String>(concepts_list_model);
		this.concepts_view = new JScrollPane(concepts_list);
		
		this.document_panel_dimension = new Dimension(DOCUMENT_PANEL_X, DOCUMENT_PANEL_Y);
		this.concept_panel_dimension = new Dimension(CONCEPT_PANEL_X, CONCEPT_PANEL_Y);
		this.document_label_dimension = new Dimension(DOCUMENT_LABEL_X, DOCUMENT_LABEL_Y);
		this.document_name_dimension = new Dimension(DOCUMENT_NAME_X, DOCUMENT_NAME_Y);
		this.document_path_dimension = new Dimension(DOCUMENT_PATH_X, DOCUMENT_PATH_Y);
		this.concepts_view_dimension = new Dimension(CONCEPTS_VIEW_X, CONCEPTS_VIEW_Y);
		this.document_input_dimension = new Dimension(DOCUMENT_INPUT_X, DOCUMENT_INPUT_Y);
		
		this.title_font = new Font(TITLE_FONT, Font.PLAIN, TITLE_SIZE);
		
		this.main_layout = new FlowLayout();
		
		//Settings of the elements of the document panel
		document_panel.setPreferredSize(document_panel_dimension);
		concepts_panel.setPreferredSize(concept_panel_dimension);
		
		document_label.setPreferredSize(document_label_dimension);
		document_label.setFont(title_font);
		document_label.setHorizontalAlignment(SwingConstants.CENTER);
		
		document_name.setPreferredSize(document_name_dimension);
		
		document_input_name.setPreferredSize(document_input_dimension);
		
		document_path.setPreferredSize(document_path_dimension);
		document_path.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Settings of the elements of the concepts panel		
		concepts_view.setPreferredSize(concepts_view_dimension);
		concepts_view.setBorder(concept_panel_border);
		
		concepts_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				
		//Adding elements to the document panel
		document_panel.add(document_label);
		document_panel.add(document_name);
		document_panel.add(document_input_name);
		document_panel.add(document_path);
		
		//Adding elements to the concept panel
		concepts_panel.add(concepts_view);
		concepts_panel.add(submit_button);
				
		//Adding elements to the frame
		this.add(document_panel);
		this.add(concepts_panel);
		
		this.addListeners();
		this.setLayout(main_layout);
		this.main_icon = new ImageIcon(MAIN_ICON_PATH);
		this.setIconImage(main_icon.getImage()); // To set an icon at the top left of the interface
		this.setTitle(MAIN_TITLE);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(IS_VISIBLE);
		this.setResizable(IS_RESIZABLE);
	}

	/**
	 * To add all the listeners on the interface
	 */
	private void addListeners() {
		//Adding a listener to enable the multi-selection without using "ctrl"
		concepts_list.setSelectionModel(new DefaultListSelectionModel() {
			private static final long serialVersionUID = 2840147565923752860L;
			boolean gestureStarted = false;
			
			//To manage the interaction when an element is selected
		    @Override
		    public void setSelectionInterval(int index0, int index1) {
		        if(!gestureStarted){
		            if (isSelectedIndex(index0)) {
		                super.removeSelectionInterval(index0, index1);
		            } else {
		                super.addSelectionInterval(index0, index1);
		            }
		        }
		        gestureStarted = true;
		    }

		    //When the "value" of an element is changed
		    @Override
		    public void setValueIsAdjusting(boolean isAdjusting) {
		        if (isAdjusting == false) {
		            gestureStarted = false;
		        }
		    }

		});	
	}

	/**
	 * To get the concepts and to add them in the check box
	 */
	private void getConcepts() {
		concepts_list_model.addElement("bô jeu");
		concepts_list_model.addElement("bô jeu 2");
	}
}
