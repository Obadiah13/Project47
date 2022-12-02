package application;

import java.util.Scanner;

public class Goals extends FitnessTrackerController {
//Setting goals that the user has, etc, goes into this class
	double weightGoal;
	double currentWeight;
	double bodyFat;
	String gender;
	int age;
	
	Scanner input = new Scanner(System.in);
	int tracker = 0;
	boolean valid;
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int a) {
		int age = 0;
		
		do {
			if (input.hasNextInt()) {
				// System.out.print
				age = input.nextInt();
				valid = true;
			} else {
				// System.out.println
				valid = false;
				input.next();
			}
		} while (valid = false);
			System.out.println(age);
		this.age = a; //?
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String g) {
		String gender = g;
		
		do {
			if (input.hasNext()) {
				gender = input.nextLine(); //?
				valid = true;
			} else {
				valid = false;
				input.next();
			}
		} while (valid = false);
			System.out.println(gender);
//		this.gender = g;
	}
	
	public double getWeightGoal() {
		return this.weightGoal;
	}
	
	public void setWeightGoal(double w) {
		double weightGoal = 0.0;
		
		do {
			if (input.hasNextDouble()) {
				weightGoal = input.nextDouble();
				valid = true;
			} else {
				valid = false;
				input.next();
			}
		} while (valid = false);
			System.out.println(weightGoal);
//		this.weightGoal = w;
	}
	
	public double getCurrentWeight() {
		return this.currentWeight;
	}
	
	public void setCurrentWeight(double c) {
		double currentWeight = 0.0;
		
		do {
			if (input.hasNextDouble()) {
				currentWeight = input.nextDouble();
				valid = true;
			} else {
				valid = false;
				input.next();
			}
		} while (valid = false);
			System.out.println(currentWeight);
//		this.currentWeight = c;
	}
	
	public double getBodyFat() {
		return this.bodyFat;
	}
	
	public void setBodyFat(double b) {
		double bodyFat = 0.0;
		
		do {
			if (input.hasNextDouble()) {
				bodyFat = input.nextDouble();
				valid = true;
			} else {
				valid = false;
				input.next();
			}
		} while (valid = false);
			System.out.println(bodyFat);
//		this.bodyFat = b;
	}
	
	public double getHeight() {
		return this.bodyFat;
	}
	
	public void setHeight(double h) {
		double setHeight = 0.0;
		
		do {
			if (input.hasNextDouble()) {
				setHeight = input.nextDouble();
				valid = true;
			} else {
				valid = false;
				input.next();
			}
		} while (valid = false);
			System.out.println(setHeight);
//		this.setHeight = h;
	}
	
	
}
