package ar.com.q3s.market.client.util;

/*
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import com.sun.javafx.application.PlatformImpl;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker.State;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
 */ 
/** 
 * SwingFXWebView 
 */  
public class SwingFXWebView /*extends JPanel*/ implements Sbrowser {  
    
//	final static int WINDOW_WIDTH = 800;
//	final static int WINDOW_HEIGHT = 600;
//	
//	private static final long serialVersionUID = -6352420796829224135L;
//	private Stage stage;  
//    private WebView browser;  
//    private JFXPanel jfxPanel;  
//    private WebEngine webEngine;  
//    private JFrame frame;
//    
//    public SwingFXWebView(){
//        SwingUtilities.invokeLater(new Runnable() {  
//            @Override
//            public void run() {
//                init();
//            }  
//        });
//    }
//    
//    public void init(){
//    	frame = new JFrame();  
//        frame.getContentPane().setLayout(new BorderLayout());
//        initComponents();
//        frame.getContentPane().add(this,BorderLayout.CENTER);  
//        frame.setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
//        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
//        frame.setResizable(false);
//        frame.setLocationRelativeTo(null);
////        frame.setVisible(true); 
//    }
//    
//    public void initComponents(){  
//        jfxPanel = new JFXPanel();  
//        createScene();  
//        setLayout(new BorderLayout());  
//        add(jfxPanel, BorderLayout.CENTER);  
//    }
//    
    public void open(final String url){
//        SwingUtilities.invokeLater(new Runnable() {  
//            @Override
//            public void run() {  
//            	Platform.runLater(new Runnable() {
//            		@Override
//            		public void run() {
//            			frame.setAlwaysOnTop( true );
//            			frame.setVisible(true);
//            			frame.setAlwaysOnTop( false );
//            			webEngine.load(url);
//            		}
//            	});
//            }  
//        });
    }
//    
//    /** 
//     * createScene 
//     * 
//     * Note: Key is that Scene needs to be created and run on "FX user thread" 
//     *       NOT on the AWT-EventQueue Thread 
//     * 
//     */  
//    private void createScene() {  
//        PlatformImpl.startup(new Runnable() {  
//            @Override
//            public void run() {  
//                 
//                stage = new Stage();  
//                 
//                stage.setTitle("Hello Java FX");  
//                stage.setResizable(true);  
//   
//                Group root = new Group();  
//                Scene scene = new Scene(root,80,20);  
//                stage.setScene(scene);  
//                 
//                // Set up the embedded browser:
//                browser = new WebView();
//                browser.setMinSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//        		browser.setMaxSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//        		browser.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//                webEngine = browser.getEngine();
//                webEngine.setUserStyleSheetLocation(getClass().getResource("/style-scroll-browser-javafx.css").toExternalForm());
//                webEngine.setJavaScriptEnabled(true);
//                webEngine.getLoadWorker().stateProperty().addListener(
//                        new ChangeListener<State>() {
//                            @SuppressWarnings("rawtypes")
//							public void changed(ObservableValue ov, State oldState, State newState) {
//                                if(newState == State.SUCCEEDED) {
//                                    frame.setTitle(webEngine.getTitle());
//                                }else if(newState == State.RUNNING) {
//                                    frame.setTitle("Cargando...");
//                                }
//                            }
//                        });
//                webEngine.setOnAlert(new EventHandler<WebEvent<String>>(){
//                    @Override
//                    public void handle(WebEvent<String> arg0) {            
//                       JOptionPane.showMessageDialog(null,  arg0.getData(),"Mensaje", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                });
//                webEngine.setConfirmHandler(new Callback<String, Boolean>() {
//                	   public Boolean call(String msg) {
//                	     int result = JOptionPane.showConfirmDialog(null,msg, "Mensaje",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
//                	     boolean b = (result != 0);
//                	     return !b;
//                }});
//                
//                ObservableList<Node> children = root.getChildren();
//                children.add(browser);
//                 
//                jfxPanel.setScene(scene);  
//            }  
//        });  
//    }
//    
//    //--------------------------------------------------
//    
//    public static void main(String ...args) throws InterruptedException{
//    	System.out.println("iniciando browser");
//    	SwingFXWebView sfwv = new SwingFXWebView();
//    	Thread.sleep(2000);
//        sfwv.open("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_oninvalid");
//        Thread.sleep(2000);
//        sfwv.open("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_oninvalid");
//        Thread.sleep(2000);
//        sfwv.open("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_oninvalid");
//        
//    }  
}
