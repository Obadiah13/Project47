package application;

import java.util.ArrayList;

import javafx.scene.control.TextField;

public class Exercise extends Goals {	//Stuff like workouts, steps taken, mental health, etc. goes into this class
	private String userChoice;
	
	public Exercise(String theirChoice) {
		userChoice = theirChoice;
	}
	
	public Exercise() {
		
	}
	
	public String getUserChoice() {
		return userChoice;
	}
	
	public void setUserChoice(String theirChoice) {
		userChoice = theirChoice;
	}
	
}
