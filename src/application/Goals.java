package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 * Stores and saves the numerous data from the mainSceneController through setters and getters. Final instance lets myPlanController 
 * uses the getters. Contains conversion and random number methods. Lastly creates a graph of the user's weight loss or weight gain 
 * journey. 
 * 
 * Idea of saving data to a final instance of Goals was inspired by the YouTube channel Random Code: https://www.youtube.com/watch?v=MsgiJdf5njc&t=28s.
 * 
 * @author Christian Salinas 30154399
 *
 */
public class Goals {
//Setting goals that the user has, etc, goes into this class
	private String weightPlan;
	private String activityPlan;
	private double goalWeight;
	private double currentWeight;
	private int weeksToGoal;
	private double calories = 0.0;
	private static final Goals instance = new Goals();
	
	public Goals(String goalValue, double currentValue) {
		weightPlan = goalValue;
		currentWeight = currentValue;
	}
	
	public Goals() {
		
	}
	
	
	/**
	 * Getters and Setters of each instance variables
	 * @return
	 */
	public static Goals getInstance() {
		return instance;
	}
	
	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	public double getCalories() {
		return calories;
	}
	
	public String getWeightPlan() {
		return weightPlan;
	}
	
	public double getCurrentWeight() {
		return currentWeight;
	}
	
	public void setWeightPlan(String goalWeight) {
		this.weightPlan = goalWeight;
	}
	
	public void setCurrentWeight(double currentWeight) {
		this.currentWeight = currentWeight;
	}
	
	public void setWeightGoal(double goalWeight) {
		this.goalWeight = goalWeight;
	}
	
	public double getWeightGoal() {
		return goalWeight;
	}
	
	public int getWeeksToGoal() {
		return weeksToGoal;
	}
	
	public void setActivityPlan(String activityPlan) {
		this.activityPlan = activityPlan;
	}
	
	public String getActivityPlan() {
		return activityPlan;
	}
	
	/**
	 * Grabs the user's currentWeight and converts to kg
	 * @return currentWeight in kg
	 */
	public double CurrentWeightKg() {
		double currentWeightKg = currentWeight*0.453592;
		return currentWeightKg;
	}
	
	/**
	 * Creates a random number between 10%-20% (0.01-0.02)
	 * @return a random number between 10%-20% (0.01-0.02)
	 */
	public double getRandomNumber() {
		double randomNumber = (Math.random() * (0.02 - 0.01)) + 0.01;
		return randomNumber;
	}
	
	/**
	 * Creates and plots data points of the user's weight loss or weight gain journey to display on a graph. Utilizes instance variables currentWeight, 
	 * goalWeight, weeksToGoal and local variables weightByWeek, series.
	 * 
	 * Learned the fundamentals of creating a LineChart from YouTube channel Cool IT Help: https://www.youtube.com/watch?v=0_TeHv2Q1PI. 
	 * 
	 * @author Ammaar Melethil 30141956 
	 * @return a XYChart.Seires (series) that can be called on an instance of a Goals object (as long as the required instance variables have been set).
	 */
	public XYChart.Series timeToGoal() {
		weeksToGoal = Math.abs((int) (currentWeight - goalWeight));
		int weightByWeek = (int) currentWeight;
		
		
		// ObservableList which loop adds formatted chart data to. 
		ObservableList<XYChart.Data<String, Integer>> data = FXCollections.<XYChart.Data<String, Integer>>observableArrayList();
		
		if (weightPlan == "Weight loss of 1 Ibs (0.5kg) per week") {
			for (int week = 0; week <= weeksToGoal; week++) {
				data.add(new XYChart.Data<>(String.format("Week %d", week), weightByWeek));
				weightByWeek--;
			}
		} else if (weightPlan == "Weight gain of 1 Ibs (0.5kg) per week") {
			for (int week = 0; week <= weeksToGoal; week++) {
				data.add(new XYChart.Data<>(String.format("Week %d", week), weightByWeek));
				weightByWeek++;
			}
		}
		
		// Data from observable list passed into instance of XY.Chart.Series series.
		XYChart.Series series = new XYChart.Series(data);
		series.setName("Goal weight per week");
		return series;
	}
	
}
