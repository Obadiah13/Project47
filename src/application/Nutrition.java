package application;

public interface Nutrition {
//	private String userChoice;
	
	
	
	
	public static int getCarbs(double calories, String goal) {
		int carbs = 0;
		if (goal == "Weight loss of 1 Ibs (0.5kg) per week") {
			carbs = (int) ((calories * .4) / 4);
		} else if (goal == "Weight gain of 1 Ibs (0.5kg) per week") {
			carbs = (int) ((calories * .4) / 4);
		} else if (goal == "Maintain Weight") {
			carbs = (int) ((calories * .5) / 4);
		}
		return carbs;
	}
	
	public static int getProtein(double calories, String goal) {
		int protein = 0;
		if (goal == "Weight loss of 1 Ibs (0.5kg) per week") {
			protein = (int) ((calories * .4) / 4);
		} else if (goal == "Weight gain of 1 Ibs (0.5kg) per week") {
			protein = (int) ((calories * .3) / 4);
		} else if (goal == "Maintain Weight") {
			protein = (int) ((calories * .25) / 4);
		}
		return protein;
	}
	
	public static int getFat(double calories, String goal) {
		int fat = 0;
		if (goal == "Weight loss of 1 Ibs (0.5kg) per week") {
			fat = (int) ((calories * .2) / 9) ;
		} else if (goal == "Weight gain of 1 Ibs (0.5kg) per week") {
			fat = (int) ((calories * .3) / 9) ;
		} else if (goal == "Maintain Weight") {
			fat = (int) ((calories * .25) / 9) ;
		}
		return fat;
	}
	
	
//	
//	public Nutrition(String theirChoice) {
//		userChoice = theirChoice;
//	}
//	
//	public Nutrition() {
//		
//	}
//	
//	public String getUserChoice() {
//		return userChoice;
//	}
//	
//	public void setUserChoice(String theirChoice) {
//		userChoice = theirChoice;
//		
//	}
	
	
}
