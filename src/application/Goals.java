package application;

import javafx.scene.chart.XYChart;

public class Goals extends FitnessTrackerController {
//Setting goals that the user has, etc, goes into this class
	private String goalWeightLoss;
	private double goalWeight;
	private double currentWeight;
	private int weightDifference;
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
	
	public String getGoalWeightLoss() {
		return goalWeightLoss;
	}
	
	public double getCurrentWeight() {
		return currentWeight;
	}
	
	public void setGoalWeightLoss(String goalWeight) {
		this.goalWeightLoss = goalWeight;
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
	
	public int getWeightDifference() {
		return weightDifference;
	}
	
	

	public Goals(String goalValue, double currentValue) {
		goalWeightLoss = goalValue;
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
		XYChart.Series series = new XYChart.Series();
	
		series.setName("Goal weight per week");

		int weightDifference = Math.abs((int) (currentWeight - goalWeight));
		this.weightDifference = weightDifference;
		int weightByWeek = (int) currentWeight;
		
		// using wrong math for this method
		if (goalWeightLoss == "Weight loss of 1 Ibs (0.5kg) per week") {
			for (int week = 0; week <= weightDifference; week++) {
				series.getData().add(new XYChart.Data(String.format("Week %o", week), weightByWeek));
				weightByWeek--;
			}
		} else if (goalWeightLoss == "Weight gain of 1 Ibs (0.5kg) per week") {
			for (int week = 0; week <= weightDifference; week++) {
				series.getData().add(new XYChart.Data(String.format("Week %o", week), weightByWeek));
				weightByWeek++;
			}
		}
		
		return series;
	}
}
