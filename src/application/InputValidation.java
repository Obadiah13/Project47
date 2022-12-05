package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
// import javafx.scene.control.TextField;

public class InputValidation {

    boolean valid;
    int tracker = 0;

    // update
    // age between 18-80
    // requires test
    public boolean setAge(TextField a, Label errorAge) {
        String currentAge = a.getText();

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
                	errorAge.setText("Invalid input, value within range of 18-80");
                }
            }
        return valid;
    }

    // still good
    public boolean setGender(TextField g, Label errorGender) {
        String gender = g.getText();

        if(!(gender instanceof String) || (!(gender.equalsIgnoreCase("Male")) && !(gender.equalsIgnoreCase("Female")))) {
            errorGender.setText("Must be letters or input Male or Female");
            valid = false;
        } else {
            errorGender.setText("");
            valid = true;
            // no scanners for textfields fix in other methods
        }
    return valid;
    }
    // still good
    public boolean setCurrentWeight(TextField c, Label errorCurrentWeight) {
        String currentWeight = c.getText();
        int decimalCount = 0;
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
    
      // duplicate code above for goalValue //////////////////////////////////////////////////////////////////////// NOT good
    public boolean setGoalWeight(TextField d, Label errorGoalWeight) {
        String goalWeight = d.getText();
        int decimalCount = 0;
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

    // update
    // check 2 textboxes ft and inches
    // another for loop 
    // error:
    // overlooks ft textbox
    // requires test
    
    public boolean setHeight(TextField f, TextField i, Label errorHeight) {
        String currentHeightFt = f.getText();
        String currentHeightIn = i.getText();

        for(char b : currentHeightFt.toCharArray()) {
            if (!(Character.isDigit(b))) { // if number not digit, throw error
                valid = false;
                errorHeight.setText("Invalid input, no more than one decimal");
            } else {
                errorHeight.setText("");
                valid = true;
            }
        for(char c : currentHeightIn.toCharArray()) {
            if (!(Character.isDigit(c))) {
                valid = false;
                errorHeight.setText("Invalid input, no more than one decimal");
            } else {
                errorHeight.setText("");
                valid = true;
            }
        }
    }
    return valid;
}
}