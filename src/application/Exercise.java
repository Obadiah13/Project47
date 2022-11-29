package application;

public class Exercise extends Goals {	//Stuff like workouts, steps taken, mental health, etc. goes into this class
	String typeExercise;
	double minutes;
	double caloriesBurned;
	
	public void savePlanCardioClass(String typeEx, double min, double burned) {
		typeExercise = typeEx;
		minutes = min;
		caloriesBurned = burned;			
	}
	
	public String getTypeExercise() {
		return typeExercise;
	}
	
	public double getMinutes() {
		return minutes;
	}
	
	public double getCaloriesBurned() {
		return caloriesBurned;
	}
	
	
	
	
}
