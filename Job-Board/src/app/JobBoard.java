

     /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
      * JOB BOARD is a console-based job posting application.               *
      *                                                                     *
      * It allows users to apply for jobs. It also  allows users to add and *
      * delete their own job postings and view applications regarding them. *
      *                                                                     *
      * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


package app;

import java.util.ArrayList;
import java.util.Scanner;
import Validation.Validate;
import job.Application;
import job.Job;


public class JobBoard {
	
	// ArrayList to hold job list
	public static ArrayList<String> jobList = new ArrayList<String>();
	// ArrayList to hold applications
	public static ArrayList<String> jobApps = new ArrayList<String>();
	// Scanner object to use in all methods
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		// Start by populating the ArrayList with base jobs and applications
		createJobs();
		createApplications();
		
		String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
			
		// Welcome User/Employer, prompt for desired area
		System.out.println("Welcome to the Job Board!");
		
		String area = Validate.getStringInput(sc, "\nWould you like to VIEW CURRENT JOB POSTINGS ('V'), MODIFY JOBS ('M'), or VIEW APPLICATIONS ('A')?: ");
		
		// If a user wants to VIEW job postings
		if (area.toLowerCase().contains("v")) {
			String type = Validate.getStringInput(sc, "\nHere is a list of available job types:\n\tAccounting, Marketing, Information Technology\n\nWhat type of job are you searching for?: ");
			
			// User wants Accounting
			if (type.toLowerCase().startsWith("a")) {
				// Call method to view/apply to Accounting jobs
				viewAccountingJobs();
			}
						
			// User wants Marketing
			else if (type.toLowerCase().startsWith("m")) {
				// Call method to view/apply to Marketing jobs
				viewMarketingJobs();
			}
			
			// User wants IT
			else if (type.toLowerCase().startsWith("i")) {
				// Call method to view/apply to IT jobs
				viewITJobs();
			}
			
			// User entered a wrong letter
			else { 
				// Print out a message
				System.out.println("I'm sorry, buy there are no jobs available in that area.");
				}
			
			}
		
		// If a user wants to MODIFY (add/delete) job postings
		else if (area.toLowerCase().contains("m")) {
			// Prompt user to add or delete
			String add_or_del = Validate.getStringInput(sc, "\nAre you interested in ADDING ('A') or DELETING ('D') a job posting?: ");
			
			// If a user wants to ADD
			if (add_or_del.toLowerCase().contains("a")) {
				// Call method to add the Job
				addJob();
			}
			// If a user wants to DELETE
			else if (add_or_del.toLowerCase().contains("d")) {
				// Call method to delete the Job
				deleteJob();
			}
			// If a user didn't choose either..
			else {
				System.out.println("Invalid choice. Please restart the operation.");
			}
		}
		
		// If a user wants to VIEW APPLICATIONS
		else if (area.toLowerCase().contains("a")) {
			// Call method to View Apps
			viewApplications();
			
		}
		
		// If a user didn't select either..
		else {
			System.out.println("You have selected neither option. Have a good day anyways!");
		}
		
		
		// Check if user wants to continue
        choice = Validate.getStringInput(sc, "\nContinue? (Y/N): ");
        System.out.println();
    
    }
		
	} // end of Main class
	
	
	
	// Method used to view Accounting jobs
	public static void viewAccountingJobs() {
		// String for storing positions
		String accounting = "";
		
		System.out.println("\nHere is a list of available positions:\n");
		
		// Search jobList for Marketing records
		for (String a : jobList) {
			if (a.toLowerCase().contains("type: a")) {
				accounting += a + "\n\n";
			}
		}
		
		// Print out records
		System.out.println(accounting);
	
		// There are positions
		if (accounting.length() > 0) {
			String apply = Validate.getStringInput(sc, "Would you like to apply for any of these jobs? (Y/N):");
		
			// User wants to apply for a job
			if (apply.toLowerCase().contains("y")) {
				// Method to apply
				applyToJob();
				
			}
			// User doesn't want to apply
			else {
				System.out.println("Application process has ended. Thank you for your time.");
				}
		}
		
		// There are no positions
		else {
			System.out.println("There are currently no Accounting positions available.");
		}
	}
	
	
	
	// Method used to view Marketing jobs
	public static void viewMarketingJobs() {
		// String for storing positions
		String market = "";
		
		System.out.println("\nHere is a list of available positions:\n");
		
		// Search jobList for Marketing records
		for (String m : jobList) {
			if (m.toLowerCase().contains("type: m")) {
				market += m + "\n\n";
			}
		}
		
		// Print out records
		System.out.println(market);
		
		// There are positions
		if (market.length() > 0) {
			String apply = Validate.getStringInput(sc, "Would you like to apply for any of these jobs? (Y/N):");
		
			// User wants to apply for a job
			if (apply.toLowerCase().contains("y")) {
				// Method to apply
				applyToJob();
				
			}
			// User doesn't want to apply
			else {
				System.out.println("Application process has ended. Thank you for your time.");
				}
			
		}
		
		// There are no positions
		else {
			System.out.println("There are currently no Marketing positions available.");
		}
	}
	
	
	
	// Method used to view IT jobs
	public static void viewITJobs() {
		// String for storing positions
		String it = "";
		
		System.out.println("\nHere is a list of available positions:\n");
		
		// Search jobList for Marketing records
		for (String i : jobList) {
			if (i.toLowerCase().contains("type: i")) {
				it += i + "\n";
			}
		}
		
		// Print out records
		System.out.println(it);
		
		// There are positions
		if (it.length() > 0) {
			String apply = Validate.getStringInput(sc, "Would you like to apply for any of these jobs? (Y/N):");
		
			// User wants to apply for a job
			if (apply.toLowerCase().contains("y")) {
				// Method to apply
				applyToJob();
				
			}
			// User doesn't want to apply
			else {
				System.out.println("Application process has ended. Thank you for your time.");
				}
			
		}
		
		// There are no positions
		else {
			System.out.println("There are currently no IT positions available.");
		}
	}
	
	
	
	// Method to Apply to a Job
	public static void applyToJob() {
		// Prompt for the jobID
		String id = Validate.getStringInput(sc, "Please provide the Job ID # for the position you wish to apply: ");
		
		// Prompt the user additional input
		System.out.println("\nPlease fill in the following sections.");
		String name = Validate.getStringInput(sc, "Name: ");
		String email = Validate.getStringInput(sc, "Email Address: ");
		String phone = Validate.getStringInput(sc, "Phone #: ");
		
		String confirm2 = Validate.getStringInput(sc, "\nWould you like to submit your application? (Y/N): ");
		
		// User submits
		if (confirm2.toLowerCase().contains("y")) {
			// Save the application
			Application app = new Application(name, email, phone, id);
			
			// Save it to the App List
			jobApps.add(app.display());
			
			// Display Application
			System.out.println("Thank you for your application. Here is a copy of what you submitted.\n");
			System.out.println(app.display());
			
			
		}
		// User decides not to submit application
		else {
			System.out.println("Application was not processed.");
		}
	}
	
	
	
	// Method used when adding a job
	public static void addJob() {
		// Prompt for information
		System.out.println("To add a job posting, please fill out the following information.");
		String id = Validate.getStringInput(sc, "\nJob ID #: ");
		String type = Validate.getStringInput(sc, "\nType (Accounting, Marketing, Information Technology): ");
		String pos = Validate.getStringInput(sc, "Position Title: ");
		String desc = Validate.getStringInput(sc, "Description: ");
		
		// Using the inputs, create a Job Object
		Job newJob = new Job();
		
		// Set all the variables to the object
		newJob.setJobID(id);
		newJob.setPosition(pos);
		newJob.setDescription(desc);
		newJob.setType(type);
		
		String save = Validate.getStringInput(sc, "\nWould you like to submit this entry? (Y/N): ");
		
		if (save.toLowerCase().contains("y")) {
			// Save the view of the job posting to the ArrayList
			jobList.add(newJob.view());
			
			// Print out a message reviewing the contents of the position
			System.out.println("\nThank you for your submission. Here is a preview of your job posting:\n\n" + newJob.view());
			
		}
		else {
			// Don't add to ArrayList
			// Print a message to the user
			System.out.println("\nThis job posting has not been entered into the system.");
		}
	}
	
	
	
	// Delete the Job
	public static void deleteJob() {
		// Prompt user for Job ID (required to be able to delete!)
		int id = Validate.getIntInput(sc, "\nPlease enter the ID # of the position you want to remove: ");
		String job = "";
		
		// Find the Job Posting, show it
		for (String s : jobList) {
			if (s.toLowerCase().contains("#: " + id)) {
				job = s;
			}
		}
		
		System.out.println("\n" + job);
		
		// Confirm that the user wishes to delete
		String confirm = Validate.getStringInput(sc, "\n\nAre you sure you wish to delete this record? (Y/N): ");
		
		// Delete the view of the job posting to the ArrayList
		if (confirm.toLowerCase().contains("y")) {
			// Delete the record from the ArrayList
			jobList.remove(job);
			
			
			// Also delete any applications for that job
			for (String a : jobApps) {
				if (a.contains("#: " + id)) {
					jobApps.remove(a);
					
				}
				
			}
			
			// Print back a message
			System.out.println("Record has been deleted.");
		}
		else {
			// Print that nothing was deleted.
			System.out.println("No deletion occured.");
		}
	}
	
	
	
	// View the Applications for a specific Job
	public static void viewApplications() {
		// Prompt user for Job ID #
		int id = Validate.getIntInput(sc, "\nPlease enter the Job ID # to view its applicants: ");
		
		// Set up String for display
		String apps = "";
		
		// Search App list for Apps that include that ID
		for (String s : jobApps) {
			if(s.toLowerCase().contains("#: " + id)) {
				apps += s + "\n\n";
			}
		}
		
		// If there are applications, display them
		if (apps.length() > 0) {
			System.out.println("\n" + apps);
		}
		// Otherwise, there isn't anyone. Display a nice message.
		else {
			System.out.println("There are currently no applications for that position.");
		}
	}
	
	
	
	// Populate the jobList
	public static void createJobs() {
		
		// Add some Accounting Jobs
		Job act1 = new Job();
		act1.setJobID("1230");
		act1.setType("Accounting");
		act1.setPosition("Financial Accountant");
		act1.setDescription("You do fun accounting work.");
		jobList.add(act1.view());
		
		Job act2 = new Job();
		act2.setJobID("1231");
		act2.setType("Accounting");
		act2.setPosition("Tax Accountant");
		act2.setDescription("I'm so glad people are willing to take this job.");
		jobList.add(act2.view());		
		
		
		// Add some Marketing Jobs
		Job mar1 = new Job();
		mar1.setJobID("1232");
		mar1.setType("Marketing");
		mar1.setPosition("Sales Associate");
		mar1.setDescription("Sell stuff to people.");
		jobList.add(mar1.view());
		
		Job mar2 = new Job();
		mar2.setJobID("1233");
		mar2.setType("Marketing");
		mar2.setPosition("Marketing Consultant I");
		mar2.setDescription("Figure out how to sell stuff to people.");
		jobList.add(mar2.view());	
		
		
		// Add some IT jobs
		Job it1 = new Job();
		it1.setJobID("1232");
		it1.setType("Information Technology");
		it1.setPosition("Helpdesk Technician");
		it1.setDescription("Assist people with fixing technical issues.");
		jobList.add(it1.view());
			
	}
	
	
	
	// Populate some job applications
	public static void createApplications() {
		
		// Create some Accounting Applications
		Application act1 = new Application("Billy Jean", "billy@jean.com", "555-1234", "1230");
		jobApps.add(act1.display());
		
		Application act2 = new Application("Twilight Sparkle", "twili@mlp.com", "123-3333", "1230");
		jobApps.add(act2.display());
		
		
	}
	
	
}
