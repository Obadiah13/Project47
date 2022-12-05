package application;


import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainSceneController  {
	Stage applicationStage;
	private String gender = "";	//Keep note of their gender
	private double BMRM = 0.00;	//Keep note of their BMR for a Male
	private double BMRF = 0.00;	//Keep note of their BMR for a Female
    private String weightLossGoal = ""; // Keep note of their weight loss goal
    private String activityPlan = ""; // Keep note of their activity plan
    private double weightGoal = 0.0; // Keep note of their target weight
    private double weightNow = 0.0; // Keep note of their current weight
    
    // Final instance of goals to save data and communicate between scenes
    Goals currentGoals = Goals.getInstance();

	public double getCalories() {
		double calories = 0; 
		if(this.gender.equalsIgnoreCase("Male")) {
	    	calories = BMRM;
	    } else if(this.gender.equalsIgnoreCase("Female")) {
	    	calories = BMRF;
	    }
		return calories;
	}
	
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
    	
    	//Asks user of their desired weight loss plan
    	HBox weightContainer = new HBox();
    	Label weightLabel1 = new Label("What is your weight loss plan?");
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
    	
    	//Asks user of their intended weight 
    	HBox intendedWeightContainer = new HBox();
    	Label intendedweightLabel = new Label("What is your goal weight in Ibs? ");
    	intendedweightLabel.setPadding(new Insets(5,7,5,10));
    	TextField intendedWeight = new TextField();
    	Label errorMessage4 = new Label("");
    	errorMessage4.setPadding(new Insets(5,10,5,10));
    	
    	 	
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
    	send.setOnAction(doneEvent -> {sendToGoal(gender,errorMessage5,age,errorMessage6,goalChoiceBox,errorMessage1,
    										currentWeight,errorMessage2,heightFT,heightIN,errorMessage3);
    	weightLossGoal = goalChoiceBox.getValue();
    	weightGoal = Double.parseDouble(intendedWeight.getText());
    	weightNow = Double.parseDouble(currentWeight.getText());
    	
    	});//Sending all necessary TextFields and error Labels
    	done.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	//Each HBox container adding all their components, respectively
    	weightContainer.getChildren().addAll(weightLabel1,goalChoiceBox,errorMessage1); 
    	weightContainer2.getChildren().addAll(weightLabel2,currentWeight,errorMessage2);
    	intendedWeightContainer.getChildren().addAll(intendedweightLabel,intendedWeight,errorMessage4);
    	weightContainer3.getChildren().addAll(weightLabel3,weightLabel4,heightFT,weightLabel4_1,heightIN,errorMessage3);
    	weightContainer5.getChildren().addAll(weightLabel5,gender,errorMessage5);
    	weightContainer6.getChildren().addAll(weightLabel6,age,errorMessage6);
    	buttonContainer.getChildren().addAll(send,done);
    	
    	//Adding each HBox into the VBox in order
    	weightVBox.getChildren().add(weightContainer5);
    	weightVBox.getChildren().add(weightContainer6);
    	weightVBox.getChildren().add(weightContainer);
    	weightVBox.getChildren().add(weightContainer2);
    	weightVBox.getChildren().add(intendedWeightContainer);
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
    	nextExcercisePlan.setOnAction(doneEvent -> {saveExercise(exerciseChoiceBox,choiceIsSaved);
    	activityPlan = exerciseChoiceBox.getValue();	
    	
    	});
    	
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
    	String thierGoalWeight = userGoal.getWeightPlan();
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
    private Label planErrorLabel;
    
    @FXML
    void checkProgress(ActionEvent event) throws IOException, FileNotFoundException {
    	
    	if (gender != "" && weightLossGoal != "" && activityPlan != "" && weightGoal != 0.0 && weightNow != 0.0) {  
	    	//  Saves data from this scene to the final instance of currentGoals to communicate with the myPlan Scene
	    	currentGoals.setCalories(this.getCalories());
	    	currentGoals.setCurrentWeight(weightNow);
	    	currentGoals.setWeightPlan(weightLossGoal);
	    	currentGoals.setWeightGoal(weightGoal);
	    	currentGoals.setActivityPlan(activityPlan);
	    	
	    	// Show myPlan Scene
	    	Parent root = FXMLLoader.load((getClass().getResource("myPlan.fxml")));
	    	applicationStage.setScene(new Scene(root));
    	} else if (activityPlan == "") {
    		planErrorLabel.setText("Please select your activity plan");
    	} else {
    		planErrorLabel.setText("Please finish selecting your goals");
    	}
     
    }
    

}


