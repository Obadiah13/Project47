package application;

import java.util.ArrayList;

import javafx.scene.control.TextField;

public class Exercise /*extends Goals*/ {	//Stuff like workouts, steps taken, mental health, etc. goes into this class

	private String typeExercise;
	private double minutes;
	private double caloriesBurned;
	
	private String description;
	private int sets;
	private int reps;
	
	private ArrayList<TextField> exercise;
	private ArrayList<TextField> Ibs;
	private ArrayList<TextField> repsText;
	
	public void savePlanClass(String typeEx, double min, double burned) {
		typeExercise = typeEx;
		minutes = min;
		caloriesBurned = burned;			
	}
	
	public void savePlanClass(String des, int set, int rep) {
		description = des;
		sets = set;
		reps = rep;			
	}
	
	public void savePlanClass(ArrayList<TextField> e, ArrayList<TextField> I, ArrayList<TextField> r) {
		exercise = e;
		Ibs  = I;
		repsText = r;			
	}
	
	public ArrayList<TextField> getExerciseWorkout() {
		return exercise;
	}
	
	public ArrayList<TextField> getIbs() {
		return Ibs;
	}
	
	public ArrayList<TextField> getRepsWorkout() {
		return repsText;
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
	
	public String getDescription() {
		return description;
	}
	
	public int getSets() {
		return sets;
	}
	
	public int getReps() {
		return reps;
	}
	
	
	
}
