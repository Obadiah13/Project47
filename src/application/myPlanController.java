package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class myPlanController extends FitnessTrackerController implements Initializable {
	Stage applicationStage;
	
    @FXML
    private Label carbLabel;

    @FXML
    private Label fatLabel;

    @FXML
    private Label proteinLabel;
    
    @FXML 
    private Label foodEnergyLabel;
    
    @FXML
    private Label nutritionInfoLabel; 
    
    @FXML 
    private Label currentWeightLabel;
    
    @FXML 
    private Label goalWeightLabel;
    
    @FXML 
    private Label weightPlanLabel;
    
    @FXML 
    private Label exercisePlanLabel;
    
    @FXML
    private CategoryAxis weekAxis;
    
    @FXML
    private NumberAxis weightAxis;
    
    @FXML 
    private LineChart<?, ?> timeToGoalChart;
    
    @FXML
    private Label timeToGoalLabel;
    
    @FXML 
    private Label weightLossGoalLabel;
    
    // Gets final instance of goals (data collected from the main scene)
    Goals currentGoals = Goals.getInstance();
    
    @FXML 
    // **This Method does not work, figure out how to make a back button.
	void goBack(ActionEvent event) throws IOException, FileNotFoundException {
	    	// Go back to main scene
    	Parent root = FXMLLoader.load((getClass().getResource("FitnessTracker.fxml")));
    	applicationStage.setScene(new Scene(root)); 
    	
	    }
    


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		// Recommended Calorie and Macronutrient Intakes Tab:
		
		// User Goal Labels
		currentWeightLabel.setText(Math.round(currentGoals.getCurrentWeight()) + "lbs");
		goalWeightLabel.setText(Math.round(currentGoals.getWeightGoal()) + "lbs");
		weightPlanLabel.setText(currentGoals.getWeightPlan());
		exercisePlanLabel.setText(currentGoals.getActivityPlan());
		
		// Macro Labels
		foodEnergyLabel.setText(Math.round(currentGoals.getCalories()) + " calories");
		carbLabel.setText(Nutrition.getCarbs(currentGoals.getCalories(), currentGoals.getWeightPlan()) + " grams");
		proteinLabel.setText(Nutrition.getProtein(currentGoals.getCalories(), currentGoals.getWeightPlan()) + " grams");
		fatLabel.setText(Nutrition.getFat(currentGoals.getCalories(), currentGoals.getWeightPlan()) + " grams");
		
		nutritionInfoLabel.setText(""" 
				The results above are a guideline for more typical situations. Please consult with a doctor for 
				your macronutrient needs if you are an athlete, training for a specific purpose, or on special 
				diet due to a disease, pregnancy, or other conditions. The protein range is calculated based on 
				the guidelines set by the American Dietetic Association (ADA), The Centers for Disease Control 
				and Prevention (CDC), and the World Health Organization. The carbohydrate range is based on 
				the guidelines and joint recommendations of The Institute of Medicine, The Food and Agriculture 
				Organization and the World Health Organization. 
				""");
		
		// Time to Goal Tab:
		timeToGoalChart.getData().addAll(currentGoals.timeToGoal());
		timeToGoalLabel.setText(currentGoals.getWeeksToGoal() + " weeks to reach " + Math.round(currentGoals.getWeightGoal()) + "lbs");
		weightLossGoalLabel.setText("""
				By following our recommended calorie and 
				macronutrient intake and exercise plan, 
				you will be able to reach your intended 
				weight! 

				Please note that for most people, 
				gaining/losing more than 2 pounds per 
				week can lead to an increased risk of 
				issues including but not limited to 
				metabolic syndrome, diabetes, 
				heart disease, dehydration, electrolyte 
				imbalance, body dysmorphia, and suicidal 
				tendencies. 
				""");
		
		
		
		
		
		
	}



}


