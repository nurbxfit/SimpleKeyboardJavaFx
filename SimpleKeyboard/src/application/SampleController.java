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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SampleController {

	//@FXML private Button button;
	@FXML private GridPane gridshif;
	@FXML private GridPane gridunshif;
	@FXML private TextArea textarea;
	//@FXML private TextField textfield;
	
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
			String text = "";
			text = textarea.getText().toString();
			textarea.setText(text.substring(0, text.length() -1 ));
			
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
		// code here for capsLocking.
	}
	
	
	// not working need few fix in looping and condition.
	public void spellCheck() throws IOException {
		//ArrayList<String> strArray = new ArrayList<String>();

		String[] toCheck = (textarea.getText().toString()).split("\\s+");
		
		if(isClickSpell == false)
		{
			strArray = loadFromfile();
		}
		
		for(String a : strArray) {
			for(int i = 0 ; i < toCheck.length; i++)
			{
				if(a.equals(toCheck[i])) {
					System.out.println("Match Found in Dictionary: " + toCheck[i] );
				}

				//System.out.println(toCheck[i]);
			}
			
		}
		
		
	}
	
	private ArrayList<String> loadFromfile() throws IOException {
		String word;
		ArrayList<String> arrayList = new ArrayList<String>();
		spellFile = openFile();
		inwords = new BufferedReader(new FileReader(spellFile.getPath()));
		
		while((word = inwords.readLine()) != null)
		{
			//word = inword.readLine();
			arrayList.add(word);
		}
		inwords.close();
		
		
		
		return arrayList;
	}


	private File openFile() throws IOException {
		
		isClickSpell = true;
		FileChooser chooseOpen = new FileChooser();
		chooseOpen.setTitle("Choose Dictionary File");
		 File spell = chooseOpen.showOpenDialog(stageOpen);
		 
		 return spell;
		
	}
	



}

//Note : Basic File IO code:


/* Save File: throw IOException
	{
	String stringToSave = new String();
	File filepath = new File("C:\\Something.txt") // change the string to your filepath.
	FileWriter fileWriter = new FileWriter(file);
	fileWriter.write(stringToSave);
    fileWriter.close();
	
	}


	//elternative to BufferedReader is Scanner
	Read File: throw Exception 
	{
		String WordReaded;
		BufferedReader buffer = new BufferedReader( new FileReader("filepath.txt")); // filepath is the data we want to read.
		WordReaded = buffer.readLine(); // make it a loop is we are reading for multiple line word.
		buffer.close();
	}
