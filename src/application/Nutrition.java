package application;

/**
 * An interface that contains methods to calculate either carbohydrates, protein, and fats. This class is used
 * in myPlan Controller. 
 * @author Ammaar Melethil (30141956)
 */
public interface Nutrition {
	
	/**
	 * Uses the parameters to calculate the user's carbohydrates that they must follow to achieve their weight goal.
	 * @param calories is the BMR from the Goals class
	 * @param goal is the user's weight plan from the Goals class
	 * @return the number of carbohydrates
	 */
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
	
	/**
	 * Uses the parameters to calculate the user's proteins that they must follow to achieve their weight goal.
	 * @param calories is the BMR from the Goals class
	 * @param goal is the user's weight plan from the Goals class
	 * @return the number of proteins
	 */
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
	
	/**
	 * Uses the parameters to calculate the user's fats that they must follow to achieve their weight goal.
	 * @param calories is the BMR from the Goals class
	 * @param goal is the user's weight plan from the Goals class
	 * @return the number of fats 
	 */
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

	
	
}
