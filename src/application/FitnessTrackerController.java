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
	private String gender = "";	//Keep note of their gender
	private double BMRM = 0.00;	//Keep note of their BMR for a Male
	private double BMRF = 0.00;	//Keep note of their BMR for a Female
	
    @FXML
    private Label errorMessage;
    
    void sendToGoal(TextField gender, Label errorGender, TextField age, Label errorAge, ChoiceBox<String> goal, Label error1, 
    		TextField current, Label error2, TextField heightFt, TextField heightIn, Label error3) {
    	
    	//Error messages when the user inputs something wrong
    	errorGender.setText(""); 
    	errorAge.setText("");
    	error1.setText("");
    	error2.setText("");
    	error3.setText("");
    	
    	//Required Data for the other methods like BMR
    	String genderString = gender.getText();
    	int ageValue = Integer.parseInt(age.getText());
    	String goalValue = goal.getValue();
    	double currentValue = Double.parseDouble(current.getText());
    	double heightValueFT = Double.parseDouble(heightFt.getText());
    	double heightValueIN = Double.parseDouble(heightIn.getText());
    	
    	//Send required data to Goals class and send to BMRCalculation method
    	Goals userGoal = new Goals(goalValue,currentValue);
    	BMRCalculation(userGoal, genderString, ageValue, heightValueFT, heightValueIN); 
    	
    	//Keep note of the user choice on what gender they are
    	if(genderString.equalsIgnoreCase("Male")) {
    		this.gender = genderString;
    		System.out.println(this.gender);
    	} else if(genderString.equalsIgnoreCase("Female")) {
    		this.gender = genderString;
    		System.out.println(this.gender);
    	}
    	System.out.println("Saved user's Data");
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
    	Label weightLabel5 = new Label("What is your gender? Male or Female?");
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
        
    @FXML /*Invokes user of their exercise/activity habits*/
	void excercisePlan(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	VBox exerciseVBox = new VBox();
    	HBox exerciseContainer = new HBox();
    	Label exerciseLabel = new Label("What is your activity routine?");	//Invokes user of their activity routine/consistency
    	exerciseLabel.setPadding(new Insets(5,10,5,10));
    	ChoiceBox<String> exerciseChoiceBox = new ChoiceBox<String>();	//Give them a list of choices that matches their activity routine
    	
    	exerciseChoiceBox.getItems().add("Sedentary: Little or No Exercise");	//Times 1.2
    	exerciseChoiceBox.getItems().add("Light: Exercise 1-3 times/week");		//Times 1.375
    	exerciseChoiceBox.getItems().add("Moderate: Exercise 4-5 times/week");	//Times 1.550
    	exerciseChoiceBox.getItems().add("Very Active: Intense Exercise 6-7 times/week"); //Times 1.725
    	exerciseChoiceBox.getItems().add("Extra Active: Very Intense Exercise daily");    //Times 1.90
    	
    	//A button that saves the user's activity choice and sends the data to saveExercise method
    	Button nextExcercisePlan = new Button("Save Choice");
    	Label choiceIsSaved = new Label();
    	choiceIsSaved.setPadding(new Insets(5,10,5,10));
    	nextExcercisePlan.setOnAction(doneEvent -> saveExercise(exerciseChoiceBox,choiceIsSaved));
    	
    	//A button that has the user return to the main screen
    	HBox returnContainer = new HBox();
    	Button returnToMainScreen = new Button("Return to main Screen");
    	returnToMainScreen.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	//Collects and distribute all assets to the respective HBox 
    	exerciseContainer.getChildren().addAll(exerciseLabel,exerciseChoiceBox);
    	returnContainer.getChildren().addAll(nextExcercisePlan,returnToMainScreen,choiceIsSaved);
    	
    	//Add all HBox into the VBox
    	exerciseVBox.getChildren().add(exerciseContainer);
    	exerciseVBox.getChildren().add(returnContainer);
    	
    	//Display this method Scene
    	Scene excerciseScene = new Scene(exerciseVBox);
    	applicationStage.setScene(excerciseScene);
	}
    
    void saveExercise(ChoiceBox<String> userChoice, Label choiceLabel) {
    	//Saves the user's activity choice and sends that data to required class and method
    	String choice = userChoice.getValue();
    	Exercise exerciseClass = new Exercise(choice);	//Sends the user choice to Exercise class
    	BMRCalculation2(exerciseClass);	//Sends Exercise class to BMRCalculation2 method
    	
    	choiceLabel.setText("Activity Choice Saved"); //Notifies user that their activity choice is saved
    }
    
    protected void BMRCalculation(Goals userGoal, String gender, int age, double heightFeet, double heightInches) {
    	//Initialize and declare necessary variables for the BMR 
    	String thierGoalWeight = userGoal.getGoalWeight();
    	double totalHeightft = heightFeet + (heightInches*0.0833333);
    	double totalHeightcm = totalHeightft/0.0328084;
    	
    	//Calculates the proper BMR based on their gender choice
    	if(gender.equalsIgnoreCase("Male")) {
    		BMRM = 88.362 + (13.397*userGoal.CurrentWeightKg()) + (4.799*totalHeightcm) - (5.677*age);	//BMR Formula for Males
    	} else if(gender.equalsIgnoreCase("Female")) {
    		BMRF = 447.593 + (9.247*userGoal.CurrentWeightKg()) + (3.098*totalHeightcm) - (4.330*age);	//BMR Formula for Females
    	}
    	
    	//Adjusts the proper BMR based on their weight goal
    	if(thierGoalWeight.equalsIgnoreCase("Weight loss of 1 Ibs (0.5kg) per week")) {	//If they want weight loss, then a reduction of 10-20 percent
    		double reductionM = BMRM*userGoal.getRandomNumber();
    		double reductionF = BMRF*userGoal.getRandomNumber();
    		BMRM = BMRM - reductionM;
    		BMRF = BMRF - reductionF;
    	} else if(thierGoalWeight.equalsIgnoreCase("Weight gain of 1 Ibs (0.5kg) per week")) { //If they want weight gain, add 500 calories
    		BMRM = BMRM + 500;
    		BMRF = BMRF + 500;
    	} else if(thierGoalWeight.equalsIgnoreCase("Maintain Weight")) { //If they want to maintain weight, then BMR remains unchanged
    		System.out.println("BMR remains unchanged");
    	}
    }  
    
    protected void BMRCalculation2(Exercise choice) {
    	//Grabs the user activity choice from Exercise class
    	String thierChoice = choice.getUserChoice();
    	
    	//Applies appropriate factor based on their activity choice/level
    	if(thierChoice.equals("Sedentary: Little or No Exercise")) {
    		BMRM = BMRM * 1.2;
    		BMRF = BMRF * 1.2;
    	} else if(thierChoice.equals("Light: Exercise 1-3 times/week")) {
    		BMRM = BMRM * 1.375;
    		BMRF = BMRF * 1.375;
    	} else if(thierChoice.equals("Moderate: Exercise 4-5 times/week")) {
    		BMRM = BMRM * 1.550;
    		BMRF = BMRF * 1.550;
    	} else if(thierChoice.equals("Very Active: Intense Exercise 6-7 times/week")) {
    		BMRM = BMRM * 1.725;
    		BMRF = BMRF * 1.725;
    	} else if(thierChoice.equals("Extra Active: Very Intense Exercise daily")) {
    		BMRM = BMRM * 1.90;
    		BMRF = BMRF * 1.90;
    	}
    }
    
    
    @FXML
    void nutritionPlan(ActionEvent event) {	//Nothing yet. Assuming carbohydrates/protein/fats are required here
    
    }
    
    //Last step in the process
    @FXML
    void checkProgress(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	VBox checkProgress = new VBox();
    	
	    HBox checkProgessBMR = new HBox();
	    Label BMRLabel = new Label("");
	    BMRLabel.setPadding(new Insets(5,10,5,10));
	    
	    //Displays ideal BMR/Calorie count required from their data, rounds to nearest whole number
	    if(this.gender.equalsIgnoreCase("Male")) {
	    	BMRLabel.setText("Your BMR or daliy calorie count intake is: " + Math.round(BMRM) + " Calories/Day");
	    } else if(this.gender.equalsIgnoreCase("Female")) {
	    	BMRLabel.setText("Your BMR or daily calorie count intake is: " + Math.round(BMRF) + "Calories/Day");
	    }
	    
	    //Collects and distribute all assets to the respective HBox, then adds HBox to VBox
	    checkProgessBMR.getChildren().addAll(BMRLabel);
	    checkProgress.getChildren().add(checkProgessBMR);
    	
	    //After user obtains their plan, done button returns to the main screen
    	Button done = new Button("Done");
    	done.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	checkProgress.getChildren().add(done);
    	
    	//Show scene
    	Scene checkProgressScene = new Scene(checkProgress);
    	applicationStage.setScene(checkProgressScene);
    }

    
  
    
    
    
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

    /*Methods involving Cardio*/


/*Initial stages of asking the user's workouts*/
/*
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
*/
}


