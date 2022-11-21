package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FitnessTrackerController {

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
    void nutritionPlan(ActionEvent event) {
    	//System.out.println("nutritionPlan was clicked");

    }

    @FXML
    void excercisePlan(ActionEvent event) {
    	//System.out.println("excercisePlan was clicked");
    }

}


