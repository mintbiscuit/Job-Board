package Validation;

import java.util.Scanner;

     /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
      * This is the VALIDATION class which has two methods to check that  *
      * input is the correct type (String or Int).                        *
      * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Validate {
    
	// Method used to get String Input
    public static String getStringInput(Scanner sc, String prompt)
    {
        boolean isValid = false;
        String s = "";
        while (isValid == false)
        {
        	// Displays the prompt, checks for if there is input
            System.out.print(prompt);
            if (sc.hasNext())
            {
                s = sc.nextLine(); // Read the line for input
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid string value. Try again.");
            }
        }
        return s;
    }
    

    // Method used to get an Int input
    public static int getIntInput(Scanner sc, String prompt)
    {
        boolean isValidInt = false;
        int i = 0;
        while (isValidInt == false)
        {
        	// Displays the prompt, checks if the input is an Int
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValidInt = true;
            }
            else
            {    // If the input is NOT an Int, print out this message
                sc.next();    // Get rid of the input
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // Discard anything else on the line
        }
        return i;
    }

}
