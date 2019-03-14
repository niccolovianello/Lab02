package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.AlienDictionary;
import it.polito.tdp.alien.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
    
    private List<String> parole = new LinkedList<String>();
    
    private AlienDictionary dictionary = new AlienDictionary();
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String ts[] = txtWord.getText().split(" ");
    	boolean p1 = ts[0].matches("[a-zA-Z]*");
    	
    	if(ts.length<1 || ts.length>2) {
    		txtResult.appendText("Il formato del testo inserito non è valido.\n");
    	}
    	
    	else {
    		if(ts.length==1) {
    			if(parole.contains(ts[0].toLowerCase().trim())) {
    				txtResult.appendText("La traduzione della parola '"+ts[0].trim().toLowerCase()+"' è '"+dictionary.translateWord(ts[0].toLowerCase().trim())+"'.\n");
    			}
    			else if(!p1) {
    				txtResult.appendText("Il formato del testo inserito non è valido.\n");
    			}
    			else {
    				txtResult.appendText("La parola cercata non è presente nel dizionario.\n");
    			}
    		}
    		else {
    			boolean p2 = ts[1].matches("[a-zA-Z]*");
    			if(!p1 || !p2) {
    				txtResult.appendText("Il formato del testo inserito non è valido.\n");
    			}
    			else {
	    			Word w = new Word(ts[0]);
	    			w.setTranslation(ts[1].trim().toLowerCase());
	    			parole.add(ts[0].toLowerCase().trim());
	    			dictionary.addWord(ts[0].toLowerCase().trim(), ts[1].toLowerCase().trim());
	    			txtResult.appendText("Complimenti! La nuova traduzione è stata inserita con successo.\n");
    			}
    		}
    	}
    	
    	txtWord.clear();
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }
    
}
