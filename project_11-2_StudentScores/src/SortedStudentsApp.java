import java.util.Arrays;

public class SortedStudentsApp {

    public static void main(String[] args) {

        System.out.println("The Student Scores application\n");

        // get the number of students
        int studentCount = Console.getInt("Number of students: ", 0, 501);
        System.out.println();

        // create the array
        Student[] students = new Student[studentCount];

        // get the data for each student
        for (int i = 0; i < studentCount; i++) {
            System.out.println("STUDENT " + (i + 1));
            String lastName = Console.getString("Last name: ");
            String firstName = Console.getString("First name: ");
            int score = Console.getInt("Score: ", -1, 101);
            System.out.println();
            students[i] = new Student(lastName, firstName, score);
        }

        // sort the array
        Arrays.sort(students);

        // print the array
        System.out.println("SUMMARY");
        for (Student s : students) {
            System.out.println(s.getSummaryLine());
        }
    }
}