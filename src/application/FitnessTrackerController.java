package application;

import java.util.ArrayList;

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
	private boolean loseWeight;
	private boolean gainWeight;
	//private Goals userGoal = new Goals();
    
    @FXML
    private Label errorMessage;
    
    void sendToGoal(TextField gender, Label errorGender, TextField age, Label errorAge,TextField goal, Label error1, 
    		TextField current, Label error2, TextField bodyFat, Label error3, TextField height, Label error4) {
    	
    	errorGender.setText("");
    	errorAge.setText("");
    	error1.setText("");
    	error2.setText("");
    	error3.setText("");
    	error4.setText("");
    	
    	Goals userGoal = new Goals();
    	String genderString = gender.getText();
    	int ageValue = Integer.parseInt(age.getText());
    	double weightValue = Double.parseDouble(goal.getText());
    	double currentValue = Double.parseDouble(current.getText());
    	double bodyFatValue = Double.parseDouble(bodyFat.getText());
    	double heightValue = Double.parseDouble(height.getText());
    	
    	
	    if(!(genderString instanceof String) || (!(genderString.equalsIgnoreCase("Male")) && 
	    		!(genderString.equalsIgnoreCase("Female")) && !(genderString.equalsIgnoreCase("Other")))) {
	    	errorGender.setText("Must be letters or input Male, Female, or Other");
	    } else {
	    	userGoal.setGender(genderString);
	    }
	    
	    if(ageValue < 0) {
	    	errorAge.setText("Invaild value: " + ageValue);
	    } else {
	    	userGoal.setAge(ageValue);	
	    }
	    
    	if(weightValue < 0) {
	    	error1.setText("Invaild value: " + weightValue);
	    } else {
	    	userGoal.setWeightGoal(weightValue);	
	    }
    	
	    if(currentValue < 0) {
	    	error2.setText("Invaild value: " + currentValue);
	    } else {
	    	userGoal.setCurrentWeight(weightValue);	
	    }
	    
	    if(bodyFatValue < 0) {
	    	error3.setText("Invaild value: " + bodyFatValue);
	    } else {
	    	userGoal.setBodyFat(bodyFatValue);	
	    }
	    
	    if(heightValue < 0) {
	    	error4.setText("Invaild value: " + heightValue);
	    } else {
	    	userGoal.setHeight(bodyFatValue);	
	    }
	    
	    if(weightValue > currentValue) {
	    	gainWeight = true;
	    	loseWeight = false;
	    } else if(weightValue < currentValue) {
	    	loseWeight = true;
	    	gainWeight = false;
	    }
    }

    @FXML
    void weightGoalPlan(ActionEvent event) {
    	errorMessage.setText("");
    	Scene mainScene = applicationStage.getScene();
    	VBox weightVBox = new VBox();
    	weightVBox.setMinWidth(700);
    	
    	HBox weightContainer5 = new HBox();
    	Label weightLabel5 = new Label("What is your gender? Male, Female, or Other? ");
    	weightLabel5.setPadding(new Insets(5,10,5,10));
    	TextField gender = new TextField();
    	Label errorMessage5 = new Label("");
    	errorMessage5.setPadding(new Insets(5,10,5,10));
    	
    	HBox weightContainer6 = new HBox();
    	Label weightLabel6 = new Label("What is your age? ");
    	weightLabel6.setPadding(new Insets(5,10,5,10));
    	TextField age = new TextField();
    	Label errorMessage6 = new Label("");
    	errorMessage6.setPadding(new Insets(5,10,5,10));
    	
    	HBox weightContainer = new HBox();
    	Label weightLabel1 = new Label("What is your weight goal in Ibs? ");
    	weightLabel1.setPadding(new Insets(5,10,5,10));
    	TextField goalWeight = new TextField();
    	Label errorMessage1 = new Label("");
    	errorMessage1.setPadding(new Insets(5,10,5,10));
    	
    	HBox weightContainer2 = new HBox();
    	Label weightLabel2 = new Label("What is your current weight in Ibs? ");
    	weightLabel2.setPadding(new Insets(5,10,5,10));
    	TextField currentWeight = new TextField();
    	Label errorMessage2 = new Label("");
    	errorMessage2.setPadding(new Insets(5,10,5,10));
    	
    	HBox weightContainer3 = new HBox();
    	Label weightLabel3 = new Label("What is your body fat percentage? ");
    	weightLabel3.setPadding(new Insets(5,10,5,10));
    	Label weightLabel3_1 = new Label("%");
    	weightLabel3_1.setPadding(new Insets(5,3,5,1));
    	TextField bodyFatPer = new TextField();
    	Label errorMessage3 = new Label("");
    	errorMessage3.setPadding(new Insets(5,3,5,3));
    	
    	HBox weightContainer4 = new HBox();
    	Label weightLabel4 = new Label("What is your height in ft?");
    	weightLabel4.setPadding(new Insets(5,10,5,10));
    	TextField heightT = new TextField();
    	Label errorMessage4 = new Label("");
    	errorMessage4.setPadding(new Insets(5,10,5,10));
    	
    	HBox buttonContainer = new HBox();
    	Button send = new Button("Send Data");
    	Button done = new Button("Done");
    	send.setOnAction(doneEvent -> sendToGoal(gender,errorMessage5,age,errorMessage6,goalWeight,errorMessage1,
    										currentWeight,errorMessage2, bodyFatPer,errorMessage3,heightT,errorMessage4));
    	done.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	weightContainer.getChildren().addAll(weightLabel1,goalWeight,errorMessage1);
    	weightContainer2.getChildren().addAll(weightLabel2,currentWeight,errorMessage2);
    	weightContainer3.getChildren().addAll(weightLabel3,bodyFatPer,weightLabel3_1,errorMessage3);
    	weightContainer4.getChildren().addAll(weightLabel4,heightT,errorMessage4);
    	weightContainer5.getChildren().addAll(weightLabel5,gender,errorMessage5);
    	weightContainer6.getChildren().addAll(weightLabel6,age,errorMessage6);
    	buttonContainer.getChildren().addAll(send,done);
    	
    	weightVBox.getChildren().add(weightContainer5);
    	weightVBox.getChildren().add(weightContainer6);
    	weightVBox.getChildren().add(weightContainer);
    	weightVBox.getChildren().add(weightContainer2);
    	weightVBox.getChildren().add(weightContainer3);
    	weightVBox.getChildren().add(weightContainer4);
    	weightVBox.getChildren().add(buttonContainer);
    	
    	Scene weightScene = new Scene(weightVBox);
    	applicationStage.setScene(weightScene);
    	
    }
    
    void excercisePlan2(ChoiceBox<Integer> d, Scene mainScene) {
    	VBox exerciseVBox = new VBox();
    	HBox exerciseContainer = new HBox();
    	Label exerciseLabel = new Label("How many excercises do you plan on doing on which day?");
    	exerciseContainer.getChildren().addAll(exerciseLabel);
    	exerciseVBox.getChildren().add(exerciseContainer);
    	
    	int daysCount = 0;
    	ArrayList<TextField> exercisesList = new ArrayList<TextField>();
    	
    	while(daysCount < d.getValue()) {
    		HBox rowContainer = new HBox();
    		Label exercisesL1 = new Label("Day:");
    		Label exercisesL2 = new Label("Exercise:");
    		TextField exercisesUserDay = new TextField();
    		TextField exercisesRoutine = new TextField();
    		exercisesList.add(exercisesRoutine);
    		
    		rowContainer.getChildren().addAll(exercisesL1, exercisesUserDay, exercisesL2, exercisesRoutine);
    		daysCount++;
    		
    		exerciseVBox.getChildren().add(rowContainer);
    	}
    	
    	Button done = new Button("done");
    	done.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	exerciseVBox.getChildren().add(done);
    	
    	Scene exerciseVBoxScene = new Scene(exerciseVBox);
    	applicationStage.setScene(exerciseVBoxScene);
    }
    
    @FXML
	void excercisePlan(ActionEvent event) {
    	
    	Scene mainScene = applicationStage.getScene();
    	VBox exerciseVBox = new VBox();
    	HBox exerciseContainer = new HBox();
    	Label exerciseLabel = new Label("How many days to you want workout?");
    	exerciseLabel.setPadding(new Insets(5,10,5,10));
    	ChoiceBox<Integer> exerciseChoiceBox = new ChoiceBox<Integer>();
    	//ArrayList<String> excercises = new ArrayList<String>();
    	//int daysCount = 0;
 
    	for(int days = 0; days <= 7; days++) {
    		exerciseChoiceBox.getItems().add(days);
    		//daysCount++;
    	}
    	
    	//Exercise a = new Exercise(daysCount);
    	
    	Button nextExcercisePlan = new Button("Next");
    	nextExcercisePlan.setOnAction(doneEvent -> excercisePlan2(exerciseChoiceBox, mainScene));
    	
    	exerciseContainer.getChildren().addAll(exerciseLabel, exerciseChoiceBox, nextExcercisePlan);
    	exerciseVBox.getChildren().add(exerciseContainer);
    	
    	Scene excerciseScene = new Scene(exerciseVBox);
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


