package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class Goals extends FitnessTrackerController {
//Setting goals that the user has, etc, goes into this class
	private String weightPlan;
	private String activityPlan;
	private double goalWeight;
	private double currentWeight;
	private int weeksToGoal;
	private double calories = 0.0;
	private static final Goals instance = new Goals();
	
	// Getters and Setters
	public static Goals getInstance() {
		return instance;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	@Override
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

	public Goals(String goalValue, double currentValue) {
		weightPlan = goalValue;
		currentWeight = currentValue;
	}
	
	public Goals() {
		
	}
	
	
	public double CurrentWeightKg() {
		double currentWeightKg = currentWeight*0.453592;
		return currentWeightKg;
	}
	
	public double getRandomNumber() {
		double randomNumber = (Math.random() * (0.02 - 0.01)) + 0.01;
		return randomNumber;
	}
	

	
	public XYChart.Series timeToGoal() {
		weeksToGoal = Math.abs((int) (currentWeight - goalWeight));
		int weightByWeek = (int) currentWeight;

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
		XYChart.Series series = new XYChart.Series(data);
		series.setName("Goal weight per week");
		return series;
	}
	
}
