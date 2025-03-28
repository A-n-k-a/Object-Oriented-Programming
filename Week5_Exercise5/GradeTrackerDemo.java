/// move this to a new project
package Week5_Exercise5;
import java.util.ArrayList;
import java.util.HashMap;

class Subject {
    private String name;
    private int grade;

    public Subject(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
}
class Module {
    private String name;
    private int grade;
    
    public Module(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    
}

class Student {
    private String name;
//    private ArrayList<Module> modules;
    private ArrayList<Subject> subjects;
    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }
    
    // Add a subject with grade
    public void addSubject(String subjectName, int grade) {
        // Check if module is already existing
        Subject existingSubject = findSubject(subjectName);
            // Update existing module grade
            if (existingSubject != null) {
                existingSubject.setGrade(grade);
                return;
            }
            // Add new module
            Subject newSubject = new Subject(subjectName, grade);
            
    }
    
    // Find a module by name
    public Subject findSubject(String subjectName) {
        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName)) {
                return subject;
            }
        }
        return null; // Module not found
    }
    
    // Calculate average grade for this student
    public double calculateAverage() {
        int total = 0;
        for (Subject subject : subjects) {
            total += subject.getGrade();
        }
        return subjects.isEmpty() ? 0 : (double) total / subjects.size();
        
    }
    
    // Getters
    public String getName() {
        return name;
    }
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
   
}

class GradeTracker {
    private HashMap<String, Student> students;
    
    public GradeTracker() {
        students = new HashMap<>();
    }
    
    // Add a new student
    public void addStudent(String name) {
        if (!students.containsKey(name)) {
            students.put(name, new Student(name));
        } else {
            System.out.println("Student already exists.");
        }
    }
    
    // Add grade for a student in a subject
    public void addGrade(String studentName, String subjectName, int grade) {
        Student student = students.get(studentName);
        if (student != null) {
            student.addSubject(subjectName, grade);
        } else {
            System.out.println("Student not found.");
        }
        
    }
    
    // Get grade for a specific student and module
    public Integer getGrade(String studentName, String moduleName) {
        Student student = students.get(studentName);
        if (student != null) {
            Subject subject = student.findSubject(moduleName);
            if (subject != null) {
                return subject.getGrade();
            } else {
                System.out.println("Module not found for this student.");
            }
        } else {
            System.out.println("Student not found.");
        }
        return null; // Grade not found
    }
    
    // Get average grade for a student
    public double getStudentAverage(String studentName) {
        Student student = students.get(studentName);
        if (student != null) {
            return student.calculateAverage();
        } else {
            System.out.println("Student not found.");
        }
        return 0.0; // Average not found
    }
    
    // Get average grade for a module across all students
    public double getSubjectAverage(String subjectName) {
        int count = 0;
        int total = 0;
        
        for (Student student : students.values()) {
            Subject subject = student.findSubject(subjectName);
            if (subject != null) {
                total += subject.getGrade();
                count++;
            }
        }
        
        if (count == 0) {
            return 0.0;
        }
        
        return (double) total / count;
    }
    
    // Display all grades
    public void displayAllGrades() {
        System.out.println("\nAll Grades:");
        for (String studentName : students.keySet()) {
            Student student = students.get(studentName);
            System.out.println("Student: " + studentName);
            for (Subject subject : student.getSubjects()) {
                System.out.println("  " + subject.getName() + ": " + subject.getGrade());
            }
        }
        
    }
}

// Example main method to test the GradeTracker
public class GradeTrackerDemo {
    public static void main(String[] args) {
        System.out.println("===== Exercise 5: Student Grade Tracker =====");
        GradeTracker gradeTracker = new GradeTracker();
        // Adding students
        //("Alice");
        //("Bob");
        //("Charlie");
        gradeTracker.addStudent("Alice");
        gradeTracker.addStudent("Bob");
        gradeTracker.addStudent("Charlie");

        // Adding grades for students in different modules
        // ("Alice", "MFC", 95);
        // ("Alice", "OOP", 88);
        // ("Alice", "DevOPs", 92);
        gradeTracker.addGrade("Alice", "MFC", 95);
        gradeTracker.addGrade("Alice", "OOP", 88);
        gradeTracker.addGrade("Alice", "DevOPs", 92);
        
        //("Bob", "MFC", 78);
        //("Bob", "OOP", 85);
        //("Bob", "DevOPs", 80);
        gradeTracker.addGrade("Bob", "MFC", 78);
        gradeTracker.addGrade("Bob", "OOP", 85);
        gradeTracker.addGrade("Bob", "DevOPs", 80);
        
        //("Charlie", "MFC", 88);
        //("Charlie", "OOP", 91);
        //("Charlie", "DevOPs", 85);
        gradeTracker.addGrade("Charlie", "MFC", 88);
        gradeTracker.addGrade("Charlie", "OOP", 91);
        gradeTracker.addGrade("Charlie", "DevOPs", 85);
        
        // Retrieving specific grades
        System.out.println("\nAlice's MFC grade: " + gradeTracker.getGrade("Alice", "MFC"));
        System.out.println("Bob's OOP grade: " + gradeTracker.getGrade("Bob", "OOP"));
        System.out.println("Charlie's DevOPs grade: " + gradeTracker.getGrade("Charlie", "DevOPs"));
        
        // Calculating and displaying student averages
        System.out.println("\nAlice's average grade: " + gradeTracker.getStudentAverage("Alice"));
        System.out.println("Bob's average grade: " + gradeTracker.getStudentAverage("Bob"));
        System.out.println("Charlie's average grade: " + gradeTracker.getStudentAverage("Charlie"));
        
        // Calculating and displaying module averages
        System.out.println("\nAverage grade for MFC: " + gradeTracker.getSubjectAverage("MFC"));
        System.out.println("Average grade for OOP: " + gradeTracker.getSubjectAverage("OOP"));
        System.out.println("Average grade for DevOPs: " + gradeTracker.getSubjectAverage("DevOPs"));
        
        // Displaying all grades
        gradeTracker.displayAllGrades();

        // Demonstrating updating a grade
        System.out.println("\nUpdating Alice's OOP grade to 90.");
        gradeTracker.addGrade("Alice", "OOP", 90);
        
    }
}