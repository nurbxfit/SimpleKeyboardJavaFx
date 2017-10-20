package application;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class KeyLayout {

	private Pane root;
	private TextArea textarea;
	private GridPane grid;
	private String text = "";

	public KeyLayout(){
		this.root = new Pane();
		root.setPadding(new Insets(10));
		root.prefHeight(440.0);
		root.prefWidth(516.0);
		//root.getStyleClass().add("virtual-keyboard");
		root.getChildren().addAll(setTextArea(),setKeyGrid(),controlPane());



	}

	private Node controlPane() {
		VBox vbox = new VBox();
		vbox.getChildren().add(createButton("Save"));
		return vbox;
	}

	private Node setTextArea() {
		//TextArea
		textarea = new TextArea();
		textarea.setLayoutX(15.0);
		textarea.setLayoutY(14.0);
		textarea.prefHeight(139.0);
		textarea.prefWidth(485.0);

		return textarea;
	}

	private Node setKeyGrid() {
		//GridPane
		grid = new GridPane();
		grid.setGridLinesVisible(true);
		grid.setLayoutX(20.0);
		grid.setLayoutY(220.0);
		grid.prefHeight(207.0);
		grid.prefWidth(484.0);
		grid.setAlignment(Pos.CENTER);
		grid.getChildren().addAll(keyboardLayout());

		return grid;
	}


	private Node keyboardLayout() {

		// squareframe holding the key
		VBox vbox = new VBox();

		//vbox config
		vbox.prefHeight(189.0);
		vbox.prefWidth(504.0);




		// create button
		//final String[][]
		final String[][] unshifted = new String[][] {
	        { "`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0","+", "-", "=" },
	        { "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]", "\\"},
	        { "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'","backspace" },
	        { "z", "x", "c", "v", "b", "n", "m", ",", ".", "/" } };

	        for (int row = 0 ; row < unshifted.length ; row ++)
			{
	    		HBox hbox = new HBox();
	    		Insets val1 = new Insets(5.0);
	    		Insets val2 = new Insets(10.0);
				vbox.setMargin(hbox,val1);

	    		//hbox config
	    		hbox.setAlignment(Pos.TOP_CENTER);
	    		hbox.prefHeight(42.0);
	    		//hbox.prefWidth(404.0);
	    		hbox.setSpacing(5.0);
	    		vbox.getChildren().add(hbox);
	    		vbox.setPadding(val2);
				for (int column = 0 ; column < unshifted[row].length ; column ++)
				{
					hbox.getChildren().addAll(createButton(unshifted[row][column]));
				}

			}

	        //create space bar
	        //<HBox alignment="CENTER" prefHeight="100.0" prefWidth="200.0">
	        HBox hbox2 = new HBox();
	        Button space = (Button) createButton("Space");

	        //config
	        space.setText("Space");
	        space.setAlignment(Pos.CENTER);
	        space.setContentDisplay(ContentDisplay.CENTER);
	        space.prefWidth(325.0);
	        space.prefHeight(26.0);
	        hbox2.getChildren().add(space);
	        hbox2.setAlignment(Pos.CENTER);
	        hbox2.prefHeight(100.0);
	        hbox2.prefWidth(200.0);

	        vbox.getChildren().add(hbox2);




		return vbox;
	}



	private Node createButton(String string) {
		Button button = new Button();
		button.setText(string);

		button.setOnAction(new EventHandler<ActionEvent>() {


			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub


				if(textarea.getText().toString() == "")
				{
					textarea.setText("");
				}
				String str = ((Button) e.getSource()).getText().toString();
				if(str == "Space")
				{
					str = " ";
					text = text + str;
					textarea.setText(text);
				}
				else if( str == "backspace")
				{

				}
				else {
					text = text + str;
					textarea.setText(text);
					System.out.println("Button Pressed is " + str);
				}






			}
		});
		return button;
	}


	public Node view() {
		return root;
	}


}








