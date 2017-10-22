package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SampleController {

	@FXML private Button button;
	@FXML private TextArea textarea;
	Stage stage = new Stage();
	String text = "";
	
	
	public void handle(ActionEvent event) {
		String str = new String();
		str = ((Button) event.getSource()).getText().toString();
		
		if(str.equals("space bar"))
		{
			str = " ";
			showText(str);
			
		}
		else if(str.equals("clear")) {
			text = "";
			//textarea.setText("");
			textarea.clear();
			
		}
		else if(str.equals("Enter"))
		{
			str = "\n";
			showText(str);
		}
		else if(str.equals("tab"))
		{
			str = "\t";
			showText(str);
		}
		else if(str.equals("backspace"))
		{
			text = text.substring(0, text.length() - 1);
			textarea.setText(text);
			System.out.println("Testing backspace");
		}
		else {
			showText(str);
		}
	}
	
	public void showText(String str)
	{
		text = text + str;
		textarea.setText(text);
		System.out.println("Button Pressed is " + str);
	}
	
	
	
	
	//unfinish methode for saving into file
	public void saveFile() throws IOException {
		//crate file chooser popup
		FileChooser chooseFile = new FileChooser();
		File file = chooseFile.showSaveDialog(stage);
		String toSave = new String();
		toSave = textarea.getText().toString();
		System.out.println(toSave);
		if(file != null)
		{
			System.out.println(toSave + " Saved");
			save(toSave,file);
		}
		
		//
		
	}




	private void save(String string, File file) {
		// TODO Auto-generated method stub
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(string);
			fileWriter.close();
		}catch(IOException e){
			System.out.println("Error Occured, Cannot Save FIle");
		}
	}

	public void test() {
		String test = new String();
		test = textarea.getText().toString();
		System.out.println(test);
		
	}
	
	
	
	
	



}
