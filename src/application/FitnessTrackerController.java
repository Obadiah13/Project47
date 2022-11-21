package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FitnessTrackerController {
	Stage applicationStage;
	
    @FXML
    private TextField weightGoalTextfield;
    
    @FXML
    private Label errorMessage;

    @FXML
    void weightGoalPlan(ActionEvent event) {
    	
    	double weightValue = Double.parseDouble(weightGoalTextfield.getText());
    	errorMessage.setText("");
    	
    	if(weightValue < 0) {
    		errorMessage.setText("Invaild value: " + weightValue);
    	} else {
    		Goals userGoal = new Goals(weightValue);
    	}
    }
	
    @FXML
	void excercisePlan(ActionEvent event) {
    	
    	HBox excerciseContainer = new HBox();
    	Label excerciseLabel = new Label("How many days to do wanna workout?");
    	ChoiceBox<Integer> excerciseChoiceBox = new ChoiceBox<Integer>();
    	for(int days = 0; days <= 7; days++) {
    		excerciseChoiceBox.getItems().add(days);
    	}
    	
    	excerciseContainer.getChildren().addAll(excerciseLabel, excerciseChoiceBox);
    	Scene excerciseScene = new Scene(excerciseContainer);
    	applicationStage.setScene(excerciseScene);
    	
	}
    @FXML
    void nutritionPlan(ActionEvent event) {
    	//System.out.println("nutritionPlan was clicked");

    }

    

}


