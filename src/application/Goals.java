package application;

public class Goals extends FitnessTrackerController {
//Setting goals that the user has, etc, goes into this class
	double weightGoal;
	double currentWeight;
	
	public Goals(double w) { //User should input in pounds Ibs
		if(w > 110) {
			this.weightGoal = w;
		} 
	}
	
	public double getWeightGoal() {
		return this.weightGoal;
	}
	
	public void setWeightGoal(double w) {
		if(w > 110) {
			this.weightGoal = w;
		} 
	}
	
	public double getCurrentWeight() {
		return this.currentWeight;
	}
	
	public void setCurrentWeight(double c) {
		if(c > 110) {
			this.currentWeight = c;
		} 
	}
}
