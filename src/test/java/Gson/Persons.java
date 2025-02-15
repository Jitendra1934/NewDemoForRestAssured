package Gson;

public class Persons {

	private String firstname;
	private String lastname;
	private int rollNo;
	
	public Persons() {
		//default constructor 
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "Persons [firstname=" + firstname + ", lastname=" + lastname + ", rollNo=" + rollNo + "]";
	}
	
	
	

}
