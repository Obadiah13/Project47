package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FitnessTrackerController {
	Stage applicationStage;
    
    @FXML
    private Label errorMessage;

    @FXML
    void weightGoalPlan(ActionEvent event) {
    	errorMessage.setText("");
    	Scene mainScene = applicationStage.getScene();
    	Goals userGoal = new Goals(0.00);
    	VBox weightVBox = new VBox();
    	
    	HBox weightContainer = new HBox();
    	Label weightLabel1 = new Label("What is your weight goal? ");
    	weightLabel1.setPadding(new Insets(5,10,5,10));
    	TextField goalWeight = new TextField();
    	
    	/*
    	double weightValue = Double.parseDouble(goalWeight.getText());
    	if(weightValue < 0 || goalWeight.getText() == "") {
    		errorMessage.setText("Invaild value: " + weightValue);
    	} else {
    		userGoal.setWeightGoal(weightValue);
    	}
    	*/
    	
    	
    	
    	HBox weightContainer2 = new HBox();
    	Label weightLabel2 = new Label("What is your current weight? ");
    	weightLabel2.setPadding(new Insets(5,10,5,10));
    	TextField currentWeight = new TextField();
    	
    	/*
    	double currentWeightValue = Double.parseDouble(currentWeight.getText());
    	if(currentWeightValue < 0 || currentWeight.getText() == "") {
    		errorMessage.setText("Invaild value: " + currentWeightValue);
    	} else {
    		userGoal.setCurrentWeight(currentWeightValue);
    	}
    	*/
    	
    	
    	weightContainer.getChildren().addAll(weightLabel1, goalWeight);
    	weightContainer2.getChildren().addAll(weightLabel2, currentWeight);
    	weightVBox.getChildren().add(weightContainer);
    	weightVBox.getChildren().add(weightContainer2);
    	
    	Scene weightScene = new Scene(weightVBox);
    	applicationStage.setScene(weightScene);
    	
    }
    @FXML
	void excercisePlan(ActionEvent event) {
    	
    	HBox excerciseContainer = new HBox();
    	Label excerciseLabel = new Label("How many days to do wanna workout?");
    	excerciseLabel.setPadding(new Insets(5,10,5,10));
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
    
    @FXML
    void checkProgress(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	VBox checkProgress = new VBox();
    	
    	for(int rows = 0; rows < 2; rows++) {
	    	HBox checkProgessExcercise = new HBox();
	    	Label excercise = new Label("Exercise: ");
	    	HBox checkProgessNutrition = new HBox();
	    	Label nutrition = new Label("Nutrition: ");
	    	
	    	checkProgessExcercise.getChildren().addAll(excercise);	
	    	checkProgessNutrition.getChildren().addAll(nutrition);
	    	
	    	checkProgress.getChildren().add(checkProgessExcercise);
	    	checkProgress.getChildren().add(checkProgessNutrition);
    	}
    	
    	Button done = new Button("Done");
    	done.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	checkProgress.getChildren().add(done);
    	
    	Scene checkProgressScene = new Scene(checkProgress);
    	applicationStage.setScene(checkProgressScene);
    	
    }

    

}


