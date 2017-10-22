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

# next update :
  - add a spell checking feutures based on local list of word.

# check out SImpleKeyboard3.jar
 - here are the jar file you can run ...
