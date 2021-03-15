/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.model.Libretto;
import it.polito.tdp.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtEsame"
    private TextField txtEsame; // Value injected by FXMLLoader

    @FXML // fx:id="txtVoto"
    private TextField txtVoto; // Value injected by FXMLLoader

   // @FXML // fx:id="txtData"
    //private TextField txtData; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="dateEsame"
    private DatePicker dateEsame; // Value injected by FXMLLoader
    
    
    
    @FXML
    void handleInserisci(ActionEvent event) {
    	
    	//Leggi e controlla i dati
    	String nomeEsame = txtEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtResult.setText("ERRORE : nome esame vuoto");
    		return;
    	}
    	
    	String votoEsame = txtVoto.getText();
    	int votoInt = 0;
    	try {
    		votoInt = Integer.parseInt(votoEsame);
    	}catch(NumberFormatException ex) {
    		txtResult.setText("ERRORE : il voto deve essere numerico");
    		return;
    	}
    	if(votoInt<18 || votoInt>30) {
    		txtResult.setText("ERRORE : il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	
    	/*String dataEsame = txtData.getText();
    	LocalDate data;
    	try {
    		data = LocalDate.parse(dataEsame);
    	}catch(DateTimeException ex) {
    		txtResult.setText("ERRORE: la data non e' nel formato corretto");
    		return;
    	}*/
    	LocalDate data = dateEsame.getValue();
    	if(data==null) {
    		txtResult.setText("ERRORE: la data e' errata o mancante");
    		return;
    	}
    	
    	
    	//Esegui l'azione
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	
    	//Aggiorno i risultati nella scena
    	txtResult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	//txtData.clear();
    	dateEsame.setValue(null);

    }
    
    
    
    public void setModel (Libretto model) {
    	this.model=model;
    }
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        //assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert dateEsame != null : "fx:id=\"dateEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

