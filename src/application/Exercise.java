package application;

import java.util.ArrayList;

public class Exercise extends Goals {	//Stuff like workouts, steps taken, mental health, etc. goes into this class
	private int days;
	private ArrayList<String> exercises = new ArrayList<String>();
	
	public Exercise(int d) {
		days = d;
		exercises = new ArrayList<String>();
	}
	
	public int getDays() {
		return this.days;
	}
	
	public void setDays(int d) {
		days = d;
	}
	
	public ArrayList<String> getExercises() {
		return this.exercises;
	}
	
	//public void setExercises(int d) {
		//days = d;
	//}
	
	
}
