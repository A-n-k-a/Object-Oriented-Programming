package Week3;

public class Student {
    public String std_name;
    public String std_ID;
    public String college_name;
    public String tutor_name;

    // Constructor to initialize the Student object
    public Student(String std_name, String std_ID, String college_name, String tutor_name) {
        this.std_name = std_name;
        this.std_ID = std_ID;
        this.college_name = college_name;
        this.tutor_name = tutor_name;
    }
    
    public String getName() {
        return std_name;
    }
    public void setTutor(String name){
        tutor_name = name;
    }

}
