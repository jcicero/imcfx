package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {
	
	@FXML
	private TextField txtPeso;
	
	@FXML
	private TextField txtAltura;
	
	@FXML
	private Label labelResultado;
	
	@FXML
	private Label labelAvalia;
	
	@FXML
	private Button btCalcular; 
	
	@FXML
	public void onBtCalcularAction() {
		try {
			Locale.setDefault(Locale.US);
			double peso = Double.parseDouble(txtPeso.getText());
			double altura = Double.parseDouble(txtAltura.getText());
			double calculo = peso / (altura * altura);
			labelResultado.setText(String.format("%.2f", calculo));
			
			if (calculo < 18.5) {
				labelAvalia.setText("MAGREZA");
			} 
			if (calculo >= 18.5 && calculo <24.9) {
				labelAvalia.setText("NORMAL");
			} 
			if (calculo >= 25.0 && calculo <29.9) {
				labelAvalia.setText("SOBREPESO");
			} 
			if (calculo >= 30.0 && calculo <39.9) {
				labelAvalia.setText("OBESIDADE");
			} 
			if (calculo > 40) {
				labelAvalia.setText("OBESIDADE GRAVE");
			} 
		}
		catch(NumberFormatException e){
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
		}
}
