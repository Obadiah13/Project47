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

public class FitnessTrackerController{
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
    
    @FXML
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


