package core;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import util.CustomOutputStream;
import util.SmartScroller;

public class Gui {
	private static JFrame frame = new JFrame();
    private static JTextArea console = new JTextArea();
    private static JCheckBoxMenuItem slowModeBox = null;
	private static JCheckBoxMenuItem idleCheckerBox = null;
	private static JCheckBoxMenuItem serverActivityBox = null;
	private static JCheckBoxMenuItem chatDisplayBox = null;
	private static JCheckBoxMenuItem chatCommandsBox = null;
	
	private static String title = "";
	
	public static void createAndShowGUI() {
        //Create and set up the window.
    	frame = new JFrame("sFITs3 Bot (" + Main.getVersion(false) + ")");
    	try {
			frame.setIconImage(Toolkit.getDefaultToolkit().createImage(new URL("http://somefriggnidiot.com/favicon.ico")));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	frame.addWindowListener(new WindowAdapter() {
    		@Override
    		public void windowClosing(WindowEvent we) {
    			Main.confirmExit();
    		}
		});
    	frame.setResizable(true);
    	frame.setPreferredSize(new Dimension(800,400));
    	frame.setMinimumSize(new Dimension(800,400));
        
        Gui gui = new Gui();
        frame.setJMenuBar(gui.createMenuBar());
        frame.setContentPane(gui.createContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        //TODO Tutorial if bot staff groups not set.
	}
	
	public static void updateTitle() {
		//TODO
	}
	
    public static JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();
        
        return menuBar;
    }
    
    public static Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        console = new JTextArea(20, 70);
        console.setEditable(false);
        console.setLineWrap(true);
        console.setWrapStyleWord(true);
		
		PrintStream printStream = new PrintStream(new CustomOutputStream(console));
		System.setOut(printStream);
		//TODO : Allow only if debug on. 
		//System.setErr(printStream);
        JScrollPane scrollPane = new JScrollPane(console);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.addAdjustmentListener(new SmartScroller(scrollPane));

        contentPane.add (scrollPane, BorderLayout.CENTER);

        return contentPane;
    }
	
	public static String getTitle() {
		return title;
	}
	
	public static JFrame getFrame(){
		return frame;
	}
}
