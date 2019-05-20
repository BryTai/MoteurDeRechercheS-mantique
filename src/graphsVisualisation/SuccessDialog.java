package graphsVisualisation;

import java.awt.Dialog;

import javax.swing.JOptionPane;

public class SuccessDialog extends Dialog{
	private static final long serialVersionUID = 4114387363815736752L;
	private final String TITLE_DIALOG = "Opération réussie";
	
	public SuccessDialog(UploadJFrame parent, String message) {
		super(parent);
		
		JOptionPane.showMessageDialog(parent, message, TITLE_DIALOG, JOptionPane.INFORMATION_MESSAGE);
	}
}
