package business;

public class Student implements Comparable {

	private String firstName;
	private String lastName;
	private int score;
	
	public Student() {
		super();
	}

	public Student(String firstName, String lastName, int score) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return lastName+", "+firstName+": "+score;
	}

	@Override
	public int compareTo(Object o) {
		Student s2 = (Student)o;
		int i = 0;
		// compare last names
		i = this.lastName.compareToIgnoreCase(s2.lastName);
		
		// if last names are equal, compare first names
		if (i==0)
			i = this.firstName.compareToIgnoreCase(s2.firstName);
		return i;
	}
	
	
}
