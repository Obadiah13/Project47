package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class myPlanController extends FitnessTrackerController implements Initializable {
    
    @FXML
    private Label carbLabel;

    @FXML
    private Label fatLabel;

    @FXML
    private Label proteinLabel;
    
    // Gets final instance of goals (data collected from the main scene)
    Goals currentGoals = Goals.getInstance();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carbLabel.setText(Nutrition.getCarbs(currentGoals.getCalories(), currentGoals.getGoalWeight()) + " grams");
		proteinLabel.setText(Nutrition.getProtein(currentGoals.getCalories(), currentGoals.getGoalWeight()) + " grams");
		fatLabel.setText(Nutrition.getFat(currentGoals.getCalories(), currentGoals.getGoalWeight()) + " grams");
		
	}



}


