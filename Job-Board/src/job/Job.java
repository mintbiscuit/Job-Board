package job;

     /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
      * This is the JOB class that stores information about every job   *
      * that a user enters into the system. The APPLICATION references  *
      * only the JobID from this class.                                 *
      *                                                                 *
      * This also includes a VIEW method to output the info.            *
      * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Job {
	
	// Declare constructors
	private String jobID;
	private String position;
	private String description;
	private String type;
	
	// Get JobID
	public String getJobID() {
		return jobID;
	}
	
	// Set the JobID based on user input
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	
	// Get the Position
	public String getPosition() {
		return position;
	}
	
	// Set the Position based on user input
	public void setPosition(String position) {
		this.position = position;
	}
	
	// Get the Description
	public String getDescription() {
		return description;
	}
	
	// Set the Description based on user input
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Get the Job Type
	public String getType() {
		return type;
	}

	// Set the Job Type based on user input
	public void setType(String type) {
		this.type = type;
	}

	
	
	// Sets up a nice view of the entire job posting
	public String view() {
		// A nice, formatted String
		return "Job ID #: " + jobID + 
				"\nJob Type: " + type + 
				"\nPosition Title: " + position +
				"\nDescription: " + description;
	}

}
