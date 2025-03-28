package Week3;

public class StudentMgt {
    public static void main(String[] args) {
        // Create a new Student object
        Student student = new Student("John Doe", "12345", "Engineering", "Dr. Smith");

        // Print the details of the student
        System.out.println("Student Name: " + student.std_name);
        System.out.println("Student ID: " + student.std_ID);
        System.out.println("College Name: " + student.college_name);
        System.out.println("Tutor Name: " + student.tutor_name);

    }
}
