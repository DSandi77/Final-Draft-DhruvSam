package ca_1;

public class Actor {

    private String name;
    private String dob;
    private String gender;
    private String nationality;


    public Actor(String name, String dob, String gender, String nationality) {
	super();
	this.name = name;
	this.dob = dob;
	this.gender = gender;
	this.nationality = nationality;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDob() {
	return dob;
    }

    public void setDob(String dob) {
	this.dob = dob;
    }

    public String getGender() {
	return gender;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public String getNationality() {
	return nationality;
    }

    public void setNationality(String nationality) {
	this.nationality = nationality;
    }


    @Override
    public String toString() {
	return "Actor [ Name =" + name + ", D.O.B =" + dob + ", Gender =" + gender + ", Nationality =" + nationality
		+ "]";
    }

}