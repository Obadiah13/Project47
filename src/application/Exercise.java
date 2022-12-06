package application;

/**
 * Stores the user activity level and calculates an estimate of calories burned. Called as an object by mainSceneController
 * @author Christian Salinas 30154399
 *
 */
public class Exercise {	
	//Declare and initialize variables
	private String userChoice;
	private double currentWeight;
	private double heightFeet;
	private double heightInches;
	
	/**
	 * A constructor
	 * @param A string that stores the user's choice of their activity level from exercisePlan method
	 */
	public Exercise(String theirChoice) {
		userChoice = theirChoice;
	}
	
	/**
	 * A constructor
	 * @param currentValue A double that stores the user's current weight
	 * @param heightFT A double that stores the user's height from the feet TextField
	 * @param heightIN A double that stores the user's height from the inches TextField
	 */
	public Exercise(double currentValue, double heightFT, double heightIN) {
		currentWeight = currentValue;
		heightFeet = heightFT;
		heightInches = heightIN;
	}
	
	/**
	 * When called, simply retrun the user's activity level. A getter of userChoice.
	 * @return the user's activity level when the method is called
	 */
	public String getUserChoice() {
		return userChoice;
	}
	
	/**
	 * When called, simply set the userChoice instance variable to the parameter
	 * @param theirChoice is user's activity level
	 */
	public void setUserChoice(String theirChoice) {
		userChoice = theirChoice;
	}
	
	//Following something similar to other fitness trackers. Estimates your steps per mile from your height.
	//Assumes you've taken 2000 to 2400 steps per mile when their choices are between moderate -> Extra Active. 
	//Only need height and their current weight to calculate. Outputs the number of calories burned per 5000 thousand steps. 
	/**
	 * Assumes you will be taking or plan on doing 2000 to 2400 steps per mile when using the program.
	 * Only need height and their current weight to calculate. Outputs the number of calories burned per 5000 thousand steps. 
	 * @return the number calories they have burned from the conditions given.
	 */
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
