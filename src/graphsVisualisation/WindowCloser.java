package graphsVisualisation;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * The class WindowCloser permits to close the window correctly (system
 * tray menu included)
 */
public class WindowCloser implements WindowListener {
    private VisualisationJFrame main_frame;

    /**
     * Main Constructor of the class WindowCloser
     * @param f: The Frame the class has to close
     */
    public WindowCloser(VisualisationJFrame f){
        this.main_frame = f;
    }

    /**
     * Not used
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }
    
    /**
     * Main method to quit the interface
     */
    @Override
    public void windowClosing(WindowEvent e) {
        this.quit();
    }

    /**
     * Not used
     */
    @Override
    public void windowClosed(WindowEvent e) {

    }

    /**
     * Not used
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     * Not used
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    /**
     * Not used
     */
    @Override
    public void windowActivated(WindowEvent e) {

    }

    /**
     * Not used
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    /**
     * quit() is a method to "easily" quit the main frame, remove the icon tray and exiting the program
     */
    protected void quit() {
        main_frame.getSystemTray().remove(main_frame.getMainTrayIcon());
        main_frame.getOptionsManager().saveOptions();
        main_frame.dispose();
        System.exit(0);
    }
}
