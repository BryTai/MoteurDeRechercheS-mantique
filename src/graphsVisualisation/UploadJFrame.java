package graphsVisualisation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * The class UploadJFrame is an extension of the class JFrame that
 * permits to show an interface to the user to help him choose 
 * the documents that he has to upload
 */
public class UploadJFrame extends JFrame {
	private static final long serialVersionUID = -7498139402373436629L;
	
	//Constants for the jframe
	private final String FRAME_NAME = "Upload de documents";
	private final boolean IS_VISIBLE = true;
	private final boolean IS_RESIZABLE = false;
	private final short WIDTH = 900;
	private final short HEIGHT = 650;	
	
	//Constants for title panel
	private final String TITLE_LABEL_NAME = "Upload de documents";
    private final byte TITLE_SIZE = 25;
	
    //Constants for the upload button
    private final String UPLOAD_BUTTON_TEXT = "Upload !";
    
    //Constants for the colors
    private final Color DOCUMENTS_PANEL_BORDER_COLOR = Color.GRAY;
    
    //Constants for the icons
    private final String MAIN_ICON_PATH = "ressources/logo.png";
    
	//Constants for the font
    private final String TITLE_FONT = "Georgia";
    
    //Constants for the dimension
    private final short TITLE_PANEL_X = WIDTH-2;
    private final short TITLE_PANEL_Y = HEIGHT/10;
    
    private final short DOCUMENTS_PANEL_X = TITLE_PANEL_X;
    private final short DOCUMENTS_PANEL_Y = 7*HEIGHT/10;
    
    private final short OPTIONS_PANEL_X = WIDTH-2;
    private final short OPTIONS_PANEL_Y = HEIGHT/10;
    
    private final short TITLE_LABEL_X = TITLE_PANEL_X*3/4;
    private final short TITLE_LABEL_Y = TITLE_PANEL_Y-2;
    
    private final short DOCUMENTS_VIEW_X = DOCUMENTS_PANEL_X;
    private final short DOCUMENTS_VIEW_Y = DOCUMENTS_PANEL_Y-11;
    
    //JButtons
    private JButton upload_button;
    
	//JPanels
	private JPanel title_panel;
	private JPanel documents_panel;
	private JPanel options_panel;
	
	//JScrollPanes
	private JScrollPane documents_view;
	
	//DefaultListModel
	@SuppressWarnings("rawtypes")
	private DefaultListModel documents_view_model;
	
	//JLists
	@SuppressWarnings({ "rawtypes" })
	private JList documents_list;
	
	//JLabels
	private JLabel title_label;
	
	//Fonts
	private Font title_font;
	
	//Borders
	private Border documents_panel_border;
	
	//Dimension
	private Dimension title_label_dimension;
	private Dimension documents_view_dimension;
	private Dimension title_panel_dimension;
	private Dimension documents_panel_dimension;
	private Dimension options_panel_dimension;
	
	//Icons
	private ImageIcon main_icon;
	
	//Layout
	private FlowLayout main_layout;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UploadJFrame() {
		//Initialization
		this.title_panel = new JPanel();
		this.documents_panel = new JPanel(); 
		this.options_panel = new JPanel();
		
		this.documents_view_model = new DefaultListModel();
		this.addDocuments();
		this.documents_list = new JList(documents_view_model);
		this.documents_view = new JScrollPane(documents_list);
		
		this.upload_button = new JButton(UPLOAD_BUTTON_TEXT);
		
		this.title_label = new JLabel(TITLE_LABEL_NAME);
		
		this.title_font = new Font(TITLE_FONT, Font.PLAIN, TITLE_SIZE);
		
		this.title_label_dimension = new Dimension(TITLE_LABEL_X, TITLE_LABEL_Y);
		this.title_panel_dimension = new Dimension(TITLE_PANEL_X, TITLE_PANEL_Y);
		this.documents_panel_dimension = new Dimension(DOCUMENTS_PANEL_X, DOCUMENTS_PANEL_Y);
		this.options_panel_dimension = new Dimension(OPTIONS_PANEL_X, OPTIONS_PANEL_Y);
		this.documents_view_dimension = new Dimension(DOCUMENTS_VIEW_X, DOCUMENTS_VIEW_Y);
		
		this.main_icon = new ImageIcon(MAIN_ICON_PATH);
		
		this.main_layout = new FlowLayout();
		
		//Initialize borders
		this.documents_panel_border = BorderFactory.createLineBorder(DOCUMENTS_PANEL_BORDER_COLOR);
		
		//Settings of the title label
		title_label.setFont(title_font);
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setPreferredSize(title_label_dimension);
		
		//Settings of the documents scrollpane
		documents_view.setPreferredSize(documents_view_dimension);
		
		//Settings of the title panel
		title_panel.setPreferredSize(title_panel_dimension);
		
		//Settings of the documents panel
		documents_panel.setPreferredSize(documents_panel_dimension);
		documents_panel.setBorder(documents_panel_border);
		
		//Settings of the options panel
		options_panel.setPreferredSize(options_panel_dimension);
		
		//Adding elements to the title panel
		title_panel.add(title_label);
		
		//Adding elements to the documents panel
		documents_panel.add(documents_view);
		
		//Adding elements to the options panel
		options_panel.add(upload_button);
		
		//Adding elements to the interface
		this.add(title_panel);
		this.add(documents_panel);
		this.add(options_panel);
		
		//Settings of the interface
		this.setLayout(main_layout);
		this.addListeners();
		this.setResizable(IS_RESIZABLE);
		this.setSize(WIDTH, HEIGHT);
		this.setIconImage(main_icon.getImage());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle(FRAME_NAME);
		this.setVisible(IS_VISIBLE);
	}
	
	/**
	 * addDocuments() permits to add documents to the list that the
	 * user has chosen previously
	 */
	@SuppressWarnings("unchecked")
	private void addDocuments() {
		for(byte i=1; i<=30; i++) {
			documents_view_model.addElement("Test" + Integer.toString(i));
		}
	}
	
	/**
     * addListeners() permits to add all the listeners for the interface
     */
	private void addListeners() {
		//Adding a listener for the upload button
		upload_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO A changer (bouton upload)
				System.out.println("Uploading document(s)...");
			}			
		});
		
		//Adding a listener for the last selection element of the list
		documents_list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					//TODO A changer (Element sélectionné dans la liste)
					System.out.println(documents_list.getSelectedValue().toString());
				}
			}		
		});
	}
}
