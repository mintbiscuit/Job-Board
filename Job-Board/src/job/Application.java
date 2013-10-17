package job;

     /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
      * This is the APPLICATION class that stores the application info  *
      * that the user entered. This class does reference the JobID from *
      * the JOB class so that it can be referenced by employers under   *
      * that job posting.                                               *
      *                                                                 *
      * This includes the display() method used to give a nice output.  *
      * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


public class Application {
	
	private String name;
	private String email;
	private String phone;
	private String id;
	
	// Construct
	public Application(String name, String email, String phone, String id) {
		// Set everything
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.id = id;
	}

	// Get the Name
	private String getName() {
		return name;
	}
	
	// Get the Email
	private String getEmail() {
		return email;
	}
	
	// Get the Phone #
	private String getPhone() {
		return phone;
	}
	
	// Get the Phone #
	private String getID() {
		return id;
	}
	
	
	// Method to display a nice output
	public String display() {
		// Format the String nicely
		return "Name: " + name + 
				"\nEmail: " + email + 
				"\nPhone Number: " + phone + 
				"\nRequested Position #: " + id;
	}

}
