package core;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HomeScreen extends Application {
	
	private Button solBtn;
	private TextField answerBox;
	private TextField rightOperandTxtBox;
	private TextField leftOperandTxtBox;
	private ComboBox<String> operatorDropdown;
	
	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
	}

	private void initUI(Stage primaryStage) {
		Pane canvas = new Pane();
		canvas.setStyle("-fx-background-color: black");
		
		addControls(canvas);
		
		Scene scene = new Scene(canvas, 320, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Calculator");
		primaryStage.show();
		
	}

	private void addControls(Pane canvas) {
		
		int row1 = 20;
		int row2 = 60;

		Label label = new Label("Simple Calculator using JavaFX");
		label.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
		label.relocate(20,row1);
		
		leftOperandTxtBox = new TextField();
		leftOperandTxtBox.setMaxWidth(40); 
		leftOperandTxtBox.relocate(20,row2);
		
		operatorDropdown = new ComboBox<>();
		operatorDropdown.getItems().addAll("+","-","x","/", "%");
		operatorDropdown.setValue("+");
		operatorDropdown.relocate(80,row2);
		
		rightOperandTxtBox = new TextField();
		rightOperandTxtBox.setMaxWidth(40);
		rightOperandTxtBox.relocate(150,row2);
		
		answerBox = new TextField();
		answerBox.setMaxWidth(50);
		answerBox.relocate(250,row2);
		
		solBtn = new Button("="); 
		solBtn.setMaxWidth(10);
		solBtn.relocate(212,row2);
		
		setSolHandler();
		

		
		
		canvas.getChildren().addAll(label,leftOperandTxtBox,rightOperandTxtBox, operatorDropdown, 
				solBtn, answerBox);
		
	}

	private void setSolHandler() {
		solBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Double leftOperand = Double.valueOf(leftOperandTxtBox.getText());
				Double rightOperand = Double.valueOf(rightOperandTxtBox.getText());
				
				String operator = operatorDropdown.getValue();
				
				ArithmeticSolver solver = new ArithmeticSolver();
				String answer = String.valueOf(solver.solve(operator, leftOperand, rightOperand));
				
				
				answerBox.setText(answer);
			}
			
		});
		
	}
	
}
