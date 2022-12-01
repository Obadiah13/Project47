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
    
    @FXML
    private Label errorMessage;
    
    void sendToGoal(TextField gender, Label errorGender, TextField age, Label errorAge, ChoiceBox<String> goal, Label error1, 
    		TextField current, Label error2, TextField heightFt, TextField heightIn, Label error3) {
    	
    	errorGender.setText("");
    	errorAge.setText("");
    	error1.setText("");
    	error2.setText("");
    	error3.setText("");
    	
    	String genderString = gender.getText();
    	int ageValue = Integer.parseInt(age.getText());
    	String goalValue = goal.getValue();
    	double currentValue = Double.parseDouble(current.getText());
    	double heightValueFT = Double.parseDouble(heightFt.getText());
    	double heightValueIN = Double.parseDouble(heightIn.getText());
    	
    	Goals userGoal = new Goals(goalValue,currentValue);
    	System.out.println("Saved user's Data");
    	
    	
    	/*
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
	    
	    if(heightValue < 0) {
	    	error3.setText("Invaild value: " + heightValue);
	    } else {
	    	userGoal.setHeight(heightValue);	
	    }
	    
	    if(weightValue > currentValue) {
	    	gainWeight = true;
	    	loseWeight = false;
	    } else if(weightValue < currentValue) {
	    	loseWeight = true;
	    	gainWeight = false;
	    }
	    */
    }

    @FXML
    void weightGoalPlan(ActionEvent event) {
    	errorMessage.setText("");
    	Scene mainScene = applicationStage.getScene();
    	VBox weightVBox = new VBox();
    	weightVBox.setMinWidth(650);
    	
    	/*When Set Goals button is clicked, invokes user to input various answers all important to calculate BMR*/
    	
    	//Asks user of their gender
    	HBox weightContainer5 = new HBox();
    	Label weightLabel5 = new Label("What is your gender? Male, Female, or Other? ");
    	weightLabel5.setPadding(new Insets(5,10,5,10));
    	TextField gender = new TextField();
    	Label errorMessage5 = new Label("");
    	errorMessage5.setPadding(new Insets(5,10,5,10));
    	gender.setMaxWidth(88);
    	
    	//Asks user of their age
    	HBox weightContainer6 = new HBox();
    	Label weightLabel6 = new Label("What is your age? (ages 18-80)");
    	weightLabel6.setPadding(new Insets(5,10,5,10));
    	TextField age = new TextField();
    	Label errorMessage6 = new Label("");
    	errorMessage6.setPadding(new Insets(5,10,5,10));
    	HBox.setMargin(age, new Insets(0,0,0,20));
    	
    	//Asks user of their desire weight goal
    	HBox weightContainer = new HBox();
    	Label weightLabel1 = new Label("What is your weight goal in Ibs? ");
    	weightLabel1.setPadding(new Insets(5,10,5,10));
    	Label errorMessage1 = new Label("");
    	errorMessage1.setPadding(new Insets(5,10,5,10));
    	ChoiceBox<String> goalChoiceBox = new ChoiceBox<String>();
    	HBox.setMargin(goalChoiceBox, new Insets(0,0,0,11));
    	goalChoiceBox.setMaxWidth(149);
    	
    	//User has 3 choices of achieving their desired weight
    	goalChoiceBox.getItems().add("Maintain Weight");
    	goalChoiceBox.getItems().add("Weight loss of 1 Ibs (0.5kg) per week");
    	goalChoiceBox.getItems().add("Weight gain of 1 Ibs (0.5kg) per week");
    	
    	//Asks user of their current weight
    	HBox weightContainer2 = new HBox();
    	Label weightLabel2 = new Label("What is your current weight in Ibs? ");
    	weightLabel2.setPadding(new Insets(5,7,5,10));
    	TextField currentWeight = new TextField();
    	Label errorMessage2 = new Label("");
    	errorMessage2.setPadding(new Insets(5,10,5,10));
    	 	
    	//Asks user of their height
    	HBox weightContainer3 = new HBox();
    	Label weightLabel3 = new Label("What is your height?");
    	weightLabel3.setPadding(new Insets(5,0,5,10));
    	TextField heightFT = new TextField();
    	heightFT.setMaxWidth(30);
    	TextField heightIN = new TextField();
    	heightIN.setMaxWidth(30);
    	Label weightLabel4 = new Label("ft");
    	weightLabel4.setPadding(new Insets(5,2,5,10));
    	Label weightLabel4_1 = new Label("in");
    	weightLabel4_1.setPadding(new Insets(5,2,5,10));
    	Label errorMessage3 = new Label("");
    	errorMessage3.setPadding(new Insets(5,10,5,10));
    	
    	/*Two buttons at the bottom of the VBox container that either saves the user's data or sends them back to the main screen*/
    	HBox buttonContainer = new HBox();
    	Button send = new Button("Send Data");
    	Button done = new Button("Done");
    	send.setOnAction(doneEvent -> sendToGoal(gender,errorMessage5,age,errorMessage6,goalChoiceBox,errorMessage1,
    										currentWeight,errorMessage2,heightFT,heightIN,errorMessage3));	//Sending all necessary TextFields and error Labels
    	done.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	//Each HBox container adding all their components, respectively
    	weightContainer.getChildren().addAll(weightLabel1,goalChoiceBox,errorMessage1); 
    	weightContainer2.getChildren().addAll(weightLabel2,currentWeight,errorMessage2);
    	weightContainer3.getChildren().addAll(weightLabel3,weightLabel4,heightFT,weightLabel4_1,heightIN,errorMessage3);
    	weightContainer5.getChildren().addAll(weightLabel5,gender,errorMessage5);
    	weightContainer6.getChildren().addAll(weightLabel6,age,errorMessage6);
    	buttonContainer.getChildren().addAll(send,done);
    	
    	//Adding each HBox into the VBox in order
    	weightVBox.getChildren().add(weightContainer5);
    	weightVBox.getChildren().add(weightContainer6);
    	weightVBox.getChildren().add(weightContainer);
    	weightVBox.getChildren().add(weightContainer2);
    	weightVBox.getChildren().add(weightContainer3);
    	weightVBox.getChildren().add(buttonContainer);
    	
    	//Display the VBox scene
    	Scene weightScene = new Scene(weightVBox);
    	applicationStage.setScene(weightScene);
    	
    }
    
    /*Methods involving Cardio*/
    
    void savePlanCardio(Exercise exPlan, TextField exerciseText, TextField exerciseText2, TextField exerciseText3) {
    	//Exercise exPlan = new Exercise();
    	String typeExercise = exerciseText.getText();
    	double minutes = Double.parseDouble(exerciseText2.getText());
    	double caloriesBurned = Double.parseDouble(exerciseText3.getText());
    	
    	exPlan.savePlanClass(typeExercise, minutes, caloriesBurned);
    	System.out.println("Plan saved");
    }
    
    void checkPlanCardio(Exercise exPlan, Scene m) { //Keep this, grab data from exercise class, then display out
    	VBox cardioVBox = new VBox();
    	
    	HBox exerciseContainer = new HBox();
    	Label exerciseLabel = new Label(exPlan.getTypeExercise());
    	exerciseLabel.setPadding(new Insets(5,10,5,10));
    	
    	HBox exerciseContainer2 = new HBox();
    	Label exerciseLabel2 = new Label("Minutes: " + String.valueOf(exPlan.getMinutes()));
    	exerciseLabel2.setPadding(new Insets(5,10,5,10));
    	
    	HBox exerciseContainer3 = new HBox();
    	Label exerciseLabel3 = new Label("Calories Burned " + String.valueOf(exPlan.getCaloriesBurned()));
    	exerciseLabel3.setPadding(new Insets(5,10,5,10));
    	
    	HBox exerciseContainer4 = new HBox();
    	Button mainScreenButton = new Button("Back to main screen");
    	mainScreenButton.setOnAction(doneEvent -> applicationStage.setScene(m));
    	
    	exerciseContainer.getChildren().addAll(exerciseLabel);
    	exerciseContainer2.getChildren().addAll(exerciseLabel2);
    	exerciseContainer3.getChildren().addAll(exerciseLabel3);
    	exerciseContainer4.getChildren().addAll(mainScreenButton);
    	cardioVBox.getChildren().add(exerciseContainer);
    	cardioVBox.getChildren().add(exerciseContainer2);
    	cardioVBox.getChildren().add(exerciseContainer3);
    	cardioVBox.getChildren().add(mainScreenButton);
    	
    	Scene cardioScene = new Scene(cardioVBox);
    	applicationStage.setScene(cardioScene);
    }
   
    /*Method's involving Strength*/
    
    
    void savePlanStrength(Exercise exPlan, TextField description, TextField sets, TextField Reps) {
    	String descriptionExercise = description.getText();
    	int numberOfSets = Integer.parseInt(sets.getText());
    	int numberOfReps = Integer.parseInt(Reps.getText());
    	
    	exPlan.savePlanClass(descriptionExercise, numberOfSets, numberOfReps);
    	System.out.println("Plan Strength Saved");
    }
    
    void checkPlanStrength(Exercise exPlan, Scene m) { //Keep this, grab data from exercise class, then display out
    	VBox strengthVBox = new VBox();
    	
    	HBox exerciseContainer = new HBox();
    	Label exerciseLabel = new Label(exPlan.getDescription());
    	exerciseLabel.setPadding(new Insets(5,10,5,10));
    	
    	HBox exerciseContainer2 = new HBox();
    	Label exerciseLabel2 = new Label("Number of Sets: " + String.valueOf(exPlan.getSets()));
    	exerciseLabel2.setPadding(new Insets(5,10,5,10));
    	
    	HBox exerciseContainer3 = new HBox();
    	Label exerciseLabel3 = new Label("Number of Reps " + String.valueOf(exPlan.getReps()));
    	exerciseLabel3.setPadding(new Insets(5,10,5,10));
    	
    	HBox exerciseContainer4 = new HBox();
    	Button mainScreenButton = new Button("Back to main screen");
    	mainScreenButton.setOnAction(doneEvent -> applicationStage.setScene(m));
    	
    	exerciseContainer.getChildren().addAll(exerciseLabel);
    	exerciseContainer2.getChildren().addAll(exerciseLabel2);
    	exerciseContainer3.getChildren().addAll(exerciseLabel3);
    	exerciseContainer4.getChildren().addAll(mainScreenButton);
    	strengthVBox.getChildren().add(exerciseContainer);
    	strengthVBox.getChildren().add(exerciseContainer2);
    	strengthVBox.getChildren().add(exerciseContainer3);
    	strengthVBox.getChildren().add(mainScreenButton);
    	
    	Scene strengthScene = new Scene(strengthVBox);
    	applicationStage.setScene(strengthScene);
    }
    
    
    /*Workout related methods*/
    
    void savePlanWorkout(Exercise exPlan, ArrayList<TextField> exercise, ArrayList<TextField> Ibs, ArrayList<TextField> reps) {
    	exPlan.savePlanClass(exercise, Ibs, reps);
    	System.out.println("Save Plan Workout");
    }
    
    void checkPlanWorkout(Exercise exPlan, Scene mainScene) {
    	VBox workoutVBox = new VBox();
    	ArrayList<TextField> exerciseList = exPlan.getExerciseWorkout();
    	ArrayList<TextField> IbsList = exPlan.getIbs();
    	ArrayList<TextField> repsList = exPlan.getRepsWorkout();
    	
    	for(int i = 0; i < exerciseList.size(); i++) {
    		HBox exerciseContainer = new HBox();
	    	Label exerciseLabel = new Label("Exercise: " + exerciseList.get(i).getText());
	    	exerciseLabel.setPadding(new Insets(3,10,3,10));
	    	
	    	HBox exerciseContainer2 = new HBox();
	    	Label exerciseLabel2 = new Label("Ibs: " + IbsList.get(i).getText());
	    	exerciseLabel2.setPadding(new Insets(0,10,3,10));
	    	Label exerciseLabel3 = new Label("Reps: " + repsList.get(i).getText());
	    	exerciseLabel3.setPadding(new Insets(0,10,3,10));
	    
	    	exerciseContainer.getChildren().addAll(exerciseLabel);
	    	workoutVBox.getChildren().add(exerciseContainer);
	    	exerciseContainer2.getChildren().addAll(exerciseLabel2,exerciseLabel3);
	    	workoutVBox.getChildren().add(exerciseContainer2);
    	}
    	 	
    	HBox exerciseContainer3 = new HBox();
    	Button returnToMainScreen = new Button("Return to Main Screen");
    	returnToMainScreen.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	exerciseContainer3.getChildren().addAll(returnToMainScreen);
    	workoutVBox.getChildren().add(exerciseContainer3);
    	
    	Scene workoutScene = new Scene(workoutVBox);
    	applicationStage.setScene(workoutScene);
    }
    
    void workoutRoutine(Exercise exPlan, Scene mainScene, TextField sets) {
    	int numberOfSets = Integer.parseInt(sets.getText());
    	int rows = 0;
    	VBox workoutRoutineVBox = new VBox();
    	
    	ArrayList<TextField> exerciseTextArray = new ArrayList<TextField>();
    	ArrayList<TextField> IbsTextArray = new ArrayList<TextField>();
    	ArrayList<TextField> repsTextArray = new ArrayList<TextField>();
    	
    	while(rows < numberOfSets) {
    		HBox rowContainer = new HBox();
    		Label exerciseLabel = new Label("Enter Exercise");
    		exerciseLabel.setPadding(new Insets(5,10,5,10));
    		TextField exerciseTextField = new TextField();
    		exerciseTextField.setPadding(new Insets(0,0,1,0));
    		
    		HBox rowContainerIbsSets = new HBox();
    		Label exerciseIbsLabel = new Label("Enter Ibs");
    		exerciseIbsLabel.setPadding(new Insets(5,10,5,10));
    		TextField exerciseIbsTextField = new TextField();
    		exerciseIbsTextField.setPadding(new Insets(0,0,1,0));
    		
    		Label exerciseRepsLabel = new Label("Enter Reps");
    		exerciseRepsLabel.setPadding(new Insets(5,10,5,10));
    		TextField exerciseRepsTextField = new TextField();
    		exerciseRepsTextField.setPadding(new Insets(0,0,1,0));
    		
    		exerciseTextArray.add(exerciseTextField);
    		IbsTextArray.add(exerciseIbsTextField);
    		repsTextArray.add(exerciseRepsTextField);
    		
    		rowContainer.getChildren().addAll(exerciseLabel, exerciseTextField);
    		rowContainerIbsSets.getChildren().addAll(exerciseIbsLabel, exerciseIbsTextField, exerciseRepsLabel, exerciseRepsTextField);
    		rows++;
    		
    		workoutRoutineVBox.getChildren().add(rowContainer);
    		workoutRoutineVBox.getChildren().add(rowContainerIbsSets);
    	}
    	
    	HBox exerciseContainer= new HBox();
		Button savePlan = new Button("Save Plan");
		Button checkPlan = new Button("Check Plan");
		savePlan.setOnAction(doneEvent -> savePlanWorkout(exPlan,exerciseTextArray,IbsTextArray,repsTextArray));
		checkPlan.setOnAction(doneEvent -> checkPlanWorkout(exPlan,mainScene));
		exerciseContainer.getChildren().addAll(savePlan,checkPlan);
		
		workoutRoutineVBox.getChildren().add(exerciseContainer);
		
		Scene workoutScene = new Scene(workoutRoutineVBox);
		applicationStage.setScene(workoutScene);
    	
    }
    
    /*Initial stages of asking the user's workouts*/
    void exercisePlan2(ChoiceBox<String> userChoice, Scene mainScene) {
    	Exercise exPlan = new Exercise();
    	String choice = userChoice.getValue();
    	VBox exerciseVBox = new VBox();
    	//Scene mainScene = applicationStage.getScene();
    	
    	if(choice == "Cardiovascular") {
    		//Ask user exercise to perform
    		HBox exerciseContainer = new HBox();
    		Label exerciseLabel = new Label("Enter Exercise: ");
    		exerciseLabel.setPadding(new Insets(5,10,5,10));
    		TextField exerciseText = new TextField();
    		
    		//Ask user how many minutes they want to do
    		HBox exerciseContainer2 = new HBox();
    		Label exerciseLabel2 = new Label("Minutes Performed: ");
    		exerciseLabel2.setPadding(new Insets(5,10,5,10));
    		TextField exerciseText2 = new TextField();
    		
    		//Ask user an estimate of how many calories they have burned
    		HBox exerciseContainer3 = new HBox();
    		Label exerciseLabel3 = new Label("Estimated Calories burned: ");
    		exerciseLabel3.setPadding(new Insets(5,10,5,10));
    		TextField exerciseText3 = new TextField();
    		
    		//This container is to save their plan in the exercise class
    		HBox exerciseContainer4 = new HBox();
    		Button savePlan = new Button("Save Plan");
    		savePlan.setOnAction(doneEvent -> savePlanCardio(exPlan,exerciseText,exerciseText2,exerciseText3));
    		
    		//This container to show their new plan 
    		Button checkPlan = new Button("Check Plan");
        	checkPlan.setOnAction(doneEvent -> checkPlanCardio(exPlan, mainScene));
        	//checkPlan.setOnAction(doneEvent -> checkProgress(exPlan));
        	
    		exerciseContainer.getChildren().addAll(exerciseLabel, exerciseText);
    		exerciseContainer2.getChildren().addAll(exerciseLabel2, exerciseText2);
    		exerciseContainer3.getChildren().addAll(exerciseLabel3, exerciseText3);
    		exerciseContainer4.getChildren().addAll(savePlan,checkPlan);
    		exerciseVBox.getChildren().add(exerciseContainer);
    		exerciseVBox.getChildren().add(exerciseContainer2);
    		exerciseVBox.getChildren().add(exerciseContainer3);
    		exerciseVBox.getChildren().add(exerciseContainer4);
    		
    		Scene exerciseScene = new Scene(exerciseVBox);
    		applicationStage.setScene(exerciseScene);
    		
    	} else if(choice == "Strength") {
    		//Ask user exercise to perform
    		HBox exerciseContainer5 = new HBox();
    		Label exerciseLabel5 = new Label("Enter desciption of your Exercise: ");
    		exerciseLabel5.setPadding(new Insets(5,10,5,10));
    		TextField exerciseText5 = new TextField();
    		
    		//Ask user exercise to perform
    		HBox exerciseContainer6 = new HBox();
    		Label exerciseLabel6 = new Label("Enter number of Sets: ");
    		exerciseLabel6.setPadding(new Insets(5,10,5,10));
    		TextField exerciseText6 = new TextField();
    		
    		//Ask user exercise to perform
    		HBox exerciseContainer7 = new HBox();
    		Label exerciseLabel7 = new Label("Enter Reps: ");
    		exerciseLabel7.setPadding(new Insets(5,10,5,10));
    		TextField exerciseText7 = new TextField();
    		
    		HBox exerciseContainer8 = new HBox();
    		Button savePlan = new Button("Save Plan");
    		savePlan.setOnAction(doneEvent -> savePlanStrength(exPlan,exerciseText5,exerciseText6,exerciseText7));
    		
    		Button checkPlan = new Button("Check Plan");
    		checkPlan.setOnAction(doneEvent -> checkPlanStrength(exPlan, mainScene));
    		
    		exerciseContainer5.getChildren().addAll(exerciseLabel5,exerciseText5);
    		exerciseContainer6.getChildren().addAll(exerciseLabel6,exerciseText6);
    		exerciseContainer7.getChildren().addAll(exerciseLabel7,exerciseText7);
    		exerciseContainer8.getChildren().addAll(savePlan,checkPlan);
    		exerciseVBox.getChildren().add(exerciseContainer5);
    		exerciseVBox.getChildren().add(exerciseContainer6);
    		exerciseVBox.getChildren().add(exerciseContainer7);
    		exerciseVBox.getChildren().add(exerciseContainer8);
    		
    		Scene exerciseScene2 = new Scene(exerciseVBox);
    		applicationStage.setScene(exerciseScene2);
    		
    	} else if(choice == "Workout") {
    		HBox exerciseContainer9 = new HBox();
    		Label exerciseLabel9 = new Label("Enter Number Of Sets: ");
    		exerciseLabel9.setPadding(new Insets(5,10,5,10));
    		TextField exerciseText9 = new TextField();
    		
    		HBox exerciseContainer10 = new HBox();
    		Button next = new Button("Next");
    		next.setOnAction(doneEvent -> workoutRoutine(exPlan,mainScene,exerciseText9));
    		
    		exerciseContainer9.getChildren().addAll(exerciseLabel9, exerciseText9);
    		exerciseContainer10.getChildren().addAll(next);
    		
    		exerciseVBox.getChildren().add(exerciseContainer9);
    		exerciseVBox.getChildren().add(exerciseContainer10);
    		
    		Scene workout = new Scene(exerciseVBox);
    		applicationStage.setScene(workout);
    	}
    }
    
    @FXML /*First exercise scene to invoke user of which exercise plan to do*/
	void excercisePlan(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	VBox exerciseVBox = new VBox();
    	HBox exerciseContainer = new HBox();
    	Label exerciseLabel = new Label("What type of exercises to you plan on doing?");
    	exerciseLabel.setPadding(new Insets(5,10,5,10));
    	ChoiceBox<String> exerciseChoiceBox = new ChoiceBox<String>();
 
    	exerciseChoiceBox.getItems().add("Cardiovascular");
    	exerciseChoiceBox.getItems().add("Strength");
    	exerciseChoiceBox.getItems().add("Workout");
    	
    	Button nextExcercisePlan = new Button("Next");
    	nextExcercisePlan.setOnAction(doneEvent -> exercisePlan2(exerciseChoiceBox, mainScene));
    	
    	exerciseContainer.getChildren().addAll(exerciseLabel, exerciseChoiceBox, nextExcercisePlan);
    	exerciseVBox.getChildren().add(exerciseContainer);
    	
    	Scene excerciseScene = new Scene(exerciseVBox);
    	applicationStage.setScene(excerciseScene);
	}
    
    @FXML
    void nutritionPlan(ActionEvent event) {
    
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


