package application;

public class Goals {
//Setting goals that the user has, etc, goes into this class
	private String goalWeight;
	private double currentWeight;
	
	public Goals(String goalValue, double currentValue) {
		goalWeight = goalValue;
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

	public String getGoalWeight() {
		return goalWeight;
	}
	
	public double getCurrentWeight() {
		return currentWeight;
	}
	
}
