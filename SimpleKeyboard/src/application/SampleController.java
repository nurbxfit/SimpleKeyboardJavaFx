package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {
	
	//this code used when you not using KeyLayout.java
	//this code used by default. uncomment the KeyLayout in Main.java to disable this function.
	// this code used to handle event when user click button from the fxml UI.

	
	//@FXML private Button button;
	//create a FXML object to link the TextArea we declare in FXML using sceneBuilder.
	@FXML private TextField textarea; // screen putih yang nak display text tu

	//Text we want to display in TextArea.
	String text = ""; //string yang kita nk show dkt textarea
	
//function untuk handle bila button kena tekan,
	//this Function handle Event when button pressed.
	public void handle(ActionEvent event) {

		// dia extract text dari button yg kita tekan
		//Extract button text and convert into string
		String str = ((Button) event.getSource()).getText().toString(); 
		
		//yang ni just condition ak buat untuk check kalau user tekan space.
		//simple xsiap lagi ni
		// UI dia semua ak buat dalam SceneBuilder.
		
		//this code is still long way to go.
		//you can specified if user click space bar the textarea will display a space instead of a string "space bar"
		//you can add another control statement if user click tab or backspace.
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
