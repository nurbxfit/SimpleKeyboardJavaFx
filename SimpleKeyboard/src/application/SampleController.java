package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {

	//@FXML private Button button;
	@FXML private TextField textarea; // screen putih yang nak display text tu

	String text = ""; //string yang kita nk show dkt textarea
	
//function untuk handle bila button kena tekan,
	public void handle(ActionEvent event) {

		// dia extract text dari button yg kita tekan
		String str = ((Button) event.getSource()).getText().toString(); 
		
		//yang ni just condition ak buat untuk check kalau user tekan space.
		//simple xsiap lagi ni
		// UI dia semua ak buat dalam SceneBuilder.
		if (str == "space bar")
		{
			str = " ";
			text = text + str;
			textarea.setText(text);
		}
		else {
			text = text + str;
			textarea.setText(text);
			System.out.println("Button Pressed is " + str);
		}
	}

	
	
	
	
	



}
