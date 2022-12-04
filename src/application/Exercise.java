package application;

public class Exercise extends Goals {	//Stuff like workouts, steps taken, mental health, etc. goes into this class
	private String userChoice;
	private double currentWeight;
	private double heightFeet;
	private double heightInches;
	
	
	public Exercise(String theirChoice) {
		userChoice = theirChoice;
	}
	
	public Exercise(double currentValue, double heightFT, double heightIN) {
		currentWeight = currentValue;
		heightFeet = heightFT;
		heightInches = heightIN;
	}
	
	public Exercise() {
		
	}
	
	public String getUserChoice() {
		return userChoice;
	}
	
	public void setUserChoice(String theirChoice) {
		userChoice = theirChoice;
	}
	
	//Following something similar to other fitness trackers. Estimates your steps per mile from your height.
	//Assumes you've taken 2000 to 2400 steps per mile when their choices are between moderate -> Extra Active. 
	//Only need height and their current weight to calculate. Outputs the number of calories burned per 5000 thousand steps. 
	
	public double calculateNumberOfSteps(){ 
		double caloriesBurned = 0.00;
	
		if((heightFeet == 5 && heightInches <= 5) || (heightFeet < 5)) {
			if(currentWeight > 100 && currentWeight < 180) {
				caloriesBurned = 204;
			} else if(currentWeight >= 180) {
				caloriesBurned = 313;
			}
		} else if((heightFeet == 5 && heightInches >= 6) || (heightFeet == 5 && heightInches <= 11)) {
			if(currentWeight > 100 && currentWeight < 180) {
				caloriesBurned = 223;
			} else if(currentWeight >= 180) {
				caloriesBurned = 373;
			}
		} else if(heightFeet >= 6) {
			if(currentWeight > 100 && currentWeight < 180) {
				caloriesBurned = 245;
			} else if(currentWeight >= 180) {
				caloriesBurned = 410;
			}
		}
		
		return caloriesBurned;
	}
	
}
