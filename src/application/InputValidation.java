package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InputValidation {

    boolean valid;
    
    /**
     * validation for "age" textfield
     * age between 18-80
     * else send error message to window
     * empty input in console
     */
    public boolean setAge(TextField a, Label errorAge) {
        String currentAge = a.getText();
        int tracker = 0; // tracker
        
            for(char b : currentAge.toCharArray()) {
                if (b == '.') {
                	tracker = tracker +1;
                	
                	if (tracker > 1) {
                		valid = false;
                		errorAge.setText("Invalid input, no more than one decimal");
                		break;
                	}
                    continue; 
                
                } if(valid) {	
                    errorAge.setText("");
                    valid = true;
                }
                
                int ageInput = Integer.parseInt(currentAge);
				if(ageInput < 18 || ageInput > 80) {
					valid = false;
                	errorAge.setText("Invalid input, value must be within range of 18-80");
                }
            }
        return valid;
    }

    /**
     * Validation for "gender" textfield
     * input must either be "male" or "female"
     * capitalization does not matter
     * male, Male, MALE, MaLe
     * else send error message to window
     * empty input in console
     */
    public boolean setGender(TextField g, Label errorGender) {
        String gender = g.getText();

        if(!(gender instanceof String) || (!(gender.equalsIgnoreCase("Male")) && !(gender.equalsIgnoreCase("Female")))) {
            errorGender.setText("Must be letters or input Male or Female");
            valid = false;
        } else {
            errorGender.setText("");
            valid = true;
           
        }
    return valid;
    }
    
    /**
     * Validation for "current weight" textfield
     * input must contain max one decimal
     * filter for more than two decimals
     * else send error message to window
     * empty input in console
     */
    public boolean setCurrentWeight(TextField c, Label errorCurrentWeight) {
        String currentWeight = c.getText();
        int decimalCount = 0; // tracker
            for(char a : currentWeight.toCharArray()) {
                if (a == '.') {
                    decimalCount = decimalCount + 1;
                    if (decimalCount > 1) {
                        valid = false;
                        errorCurrentWeight.setText("Invalid input, no more than one decimal");
                    }

                } else {
                    errorCurrentWeight.setText("");
                    valid = true;
                }
            }
        return valid;
    }
    
    /**
     * Validation for "goal weight" textfield
     * input must contain max one decimal
     * filter for more than two decimals
     * else send error message to window
     * empty input in console
     */
    public boolean setGoalWeight(TextField d, Label errorGoalWeight) {
        String goalWeight = d.getText();
        int decimalCount = 0; // tracker
        
            for(char a : goalWeight.toCharArray()) {
                if (a == '.') {
                    decimalCount = decimalCount + 1;
                    if (decimalCount > 1) {
                        valid = false;
                        errorGoalWeight.setText("Invalid input, no more than one decimal");
                    }

                } else {
                    errorGoalWeight.setText("");
                    valid = true;
                }
            }
        return valid;
    }

    /**
     * Validation for "height" textfields
     * one for ft, one for inches
     * ensure all digit inputs
     * else send error message
     * empty console input
     */
    public boolean setHeight(TextField f, TextField i, Label errorHeight) {
        String currentHeightFt = f.getText();
        String currentHeightIn = i.getText();

        for(char b : currentHeightFt.toCharArray()) {
            if (!(Character.isDigit(b))) { // if number not digit, throw error
                valid = false;
                errorHeight.setText("Invalid input, please input numbers");
            } else {
                errorHeight.setText("");
                valid = true;
            }
        for(char c : currentHeightIn.toCharArray()) {
            if (!(Character.isDigit(c))) {
                valid = false;
                errorHeight.setText("Invalid input, please input numbers");
            } else {
                errorHeight.setText("");
                valid = true;
            }
        }
    }
    return valid;
}
}