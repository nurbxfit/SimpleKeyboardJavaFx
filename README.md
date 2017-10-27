# SimpleKeyboardJavaFx
Process of learning JavaFx for my Assigment




# author: Nurfitri


(nurbx) Note: KeyLayout.java is a alternative ways of setting up the UI, I am too lazy and not that smart to finish it. so instead i used scenebuilder.

# Apps UI hirechy Sketch:

BoarderPane = root;
- Pane:
	- TextField
	- Seperator // optional
	- GridPane :
		- VBOX (0,0):
			- HBOX (5x for key in keyboard):
				1. Button = 14
				2. Button = 14
				3. Button = 
				4. Button = 
				5. Button = 1 //space

Values :

Pane (516,386);

TextField (485,139), position(15,14)

GridPane ( 504,207) // position (6,172); scale (x,y,z) = (1,1,1) ; grid line visible, Aligment = top_left; node Orientation = inheritt ; Role = parent

VBOX : (504,189) // (height,width); column span = 1 ; wrap by GridPane

# What changes ?
I added new method to save what we write in the textarea to a .txt file in our computer.
then i added other keyboard code for tab and backspace.
 
- Instead of using .setText() like an Idiot. I learn how to use .appendText().
- update the code remove few unecesary code.
- update the SaveToText function and Add new Function Read from dictionary to check Spelling.
- But the SPellChecking part still not working. Need Few Tweaking.
- Next update : soon.

# next update :
  - correct the Spell Checking Error.
  - add CapsLock (its there but i remove the function for some reason)

# check out SImpleKeyboard4.jar
 - here are the jar file you can run ...
 - its the finish version.
 - note that the word.txt is the Dictionary file.


# Note : Basic File IO code:

 Save File: throw IOException
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
