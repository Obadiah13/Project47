package application;

public class Goals extends FitnessTrackerController {
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
	//Dw about all this code below, old stuff
	/*
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int a) {
		this.age = a;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String g) {
		this.gender = g;
	}
	
	public double getWeightGoal() {
		return this.weightGoal;
	}
	
	public void setWeightGoal(double w) {
		this.weightGoal = w;
	}
	
	public double getCurrentWeight() {
		return this.currentWeight;
	}
	
	public void setCurrentWeight(double c) {
		this.currentWeight = c;
	}
	
	public double getBodyFat() {
		return this.bodyFat;
	}
	
	public void setBodyFat(double b) {
		this.bodyFat = b;
	}
	
	public double getHeight() {
		return this.bodyFat;
	}
	
	public void setHeight(double h) {
		this.bodyFat = h;
	}
	*/
	
}
