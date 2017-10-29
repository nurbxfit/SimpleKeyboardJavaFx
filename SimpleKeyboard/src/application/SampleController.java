package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SampleController {

	//@FXML private Button button;
	@FXML private GridPane gridshif;
	@FXML private GridPane gridunshif;
	@FXML private TextArea textarea;
	@FXML private TextArea spellField;
	
	Stage stage = new Stage();
	Stage stageOpen = new Stage();
	
	private boolean isClickSpell = false;
	//private boolean isTextCheck = false;
	File spellFile = null;
	//String [] checkWords;
	private BufferedReader inwords;
	private ArrayList<String> strArray = new ArrayList<String>();
	
	
	
	public void handle(ActionEvent event) {
		String str = new String();
		str = ((Button) event.getSource()).getText().toString();
		
		if(str.equals("space bar"))
		{
			textarea.appendText(" ");
			
		}
		else if(str.equals("clear")) {
			
			textarea.clear();
			
		}
		else if(str.equals("Enter"))
		{
			
			textarea.appendText("\n");
		}
		else if(str.equals("tab"))
		{
			
			textarea.appendText("\t");
		}
		else if(str.equals("backspace"))
		{
			//String text = "";
			//text = textarea.getText().toString();
			//textarea.setText(text.substring(0, text.length() -1 ));
			textarea.deletePreviousChar();
		}
		else {
			
			textarea.appendText(str);
		}
	}
	
	
	
	
	
	// methode for saving into file
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
	
	
	public void onCaps() {
		boolean capsClicked = true;
		if(capsClicked) //weird ? don't know why i did this.
		{

			if(gridunshif.isVisible())
			{
				gridunshif.setVisible(false);
				gridshif.setVisible(capsClicked);
				System.out.println("Shifted");
			}else if (gridshif.isVisible())
			{
				gridunshif.setVisible(capsClicked);
				gridshif.setVisible(false);
				System.out.println("UnShifted");
			}
			
		}
	}
	
	
	
	public void spellCheck() throws IOException {
		//ArrayList<String> strArray = new ArrayList<String>();
		spellField.setText("");
		String[] toCheck = (textarea.getText().toString()).split("\\s+");
		
		if(isClickSpell == false)
		{
			strArray = loadFromfile();
		}
		boolean found = true;
		for(int a = 0 ; a < toCheck.length ; a++) {
			for(String b: strArray)
			{
				if(toCheck[a].matches(b)){
					found = true;
					break;
				}
				found = false;
				
			}
			if(!found)
			{
				spellField.appendText(toCheck[a]+ " ");
			}
		}
		
	}
	
	private ArrayList<String> loadFromfile() throws IOException {
		String word;
		ArrayList<String> arrayList = new ArrayList<String>();
		spellFile = openFile();
		inwords = new BufferedReader(new FileReader(spellFile.getPath()));
		isClickSpell = true;
		while((word = inwords.readLine()) != null)
		{
			//word = inword.readLine();
			arrayList.add(word);
		}
		inwords.close();
		
		
		
		return arrayList;
	}


	private File openFile() throws IOException {
		
		
		FileChooser chooseOpen = new FileChooser();
		chooseOpen.setTitle("Choose Dictionary File");
		 File spell = chooseOpen.showOpenDialog(stageOpen);
		 
		 return spell;
		
	}
	



}
