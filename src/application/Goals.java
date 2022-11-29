package application;

public class Goals extends FitnessTrackerController {
//Setting goals that the user has, etc, goes into this class
	double weightGoal;
	double currentWeight;
	double bodyFat;
	String gender;
	int age;

	
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
	
	
}
