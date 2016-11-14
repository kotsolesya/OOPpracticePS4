package GroupStudents;

public class Student {
	 private String name;
	    private String surname;
	    private String phone;
	 
	    public Student(String name, String surname, String phone) {
	        this.name = name;
	        this.surname = surname;
	        this.phone = phone;
	    }
	 
	    public String getName() { return name; }
	 
	    public String getPhone() { return phone; }
	 
	    public String getSurname() { return surname; }
}
