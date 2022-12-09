package application;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * This controller displays the health plan towards the user, the last step in the program. Utilizes the Goals class and Nutrition interface. 
 * to output the appropriate data. This controller is linked with the myPlan.fxml. This extends to Main.java and implements to Initializable. 
 * @author Ammaar Melethil (30141956)
 *
 */
public class myPlanController extends Main implements Initializable {
	
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
    
    /**
     * This button transitions back to the mainScene.fxml to restart the whole program again. 
     * 
     * When attempting to switch back to the main scene using conventional implementation, the application crashed when user tried to enter data again.
     * Came up with the idea for the back button to simply start a new instance of the application and this controller to extend main to utilize "this.stop" so current operation is stopped.
     * 
     * @param event notifies when the back button is clicked 
     * @throws Exception checks when an error has occurred
     */
    @FXML
	  void goBack(ActionEvent event) throws Exception {
      Stage mainWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
      Main main = new Main();
		  main.start(mainWindow);
		  this.stop();
    }

    /**
     * The main method that displays all the required data in the myPlan.fxml. Calls relevant getters on the final instance of Goals object "currentGoals".
     * Data is passed to two separate tabs "Recommended Calorie and macro nutrient intake" and "Time to goal". 
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		// Recommended Calorie and macro nutrient Intakes Tab:
		
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
		
		
		// Disclaimer of following our plan and sources of macro nutrient calculation displayed in tab for users that don't want to read the code.
		nutritionInfoLabel.setText(""" 
				The results above are a guideline for more typical situations. Please consult with a doctor for your macronutrient needs if you are an athlete, training for a 
				specific purpose, or on special diet due to a disease, pregnancy, or other conditions. The protein range is calculated based on the guidelines set by the 
				American Dietetic Association (ADA), The Centers for Disease Control and Prevention (CDC), and the World Health Organization. The carbohydrate range 
				is based on the guidelines and joint recommendations of The Institute of Medicine, The Food and Agriculture Organization and the World Health 
				Organization.
				""");
		
		// Time to Goal Tab (if weightPlan selected by user is not to maintain weight, graph of time line is created and relevant labels have text set, else, user is notified they are already at their target weight:
		
		if (currentGoals.getWeightPlan() != "Maintain Weight") {
			
			// timeToGoal method called on currentGoals to create data points and then added to timeToGoalChart for view.
			timeToGoalChart.getData().addAll(currentGoals.timeToGoal());
			
			
			timeToGoalLabel.setText(currentGoals.getWeeksToGoal() + " weeks to reach " + Math.round(currentGoals.getWeightGoal()) + "lbs");
			
			
			// Disclaimer to inform user of the potential consequences of following plans in extreme to our recommendations.
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
		} else {
			timeToGoalLabel.setText("You are already at your \ntarget weight :)");
		}
		
	}



}


