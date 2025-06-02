/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package student;
package Week5;
import java.util.ArrayList;
/**
 *
 */
public class Module {
    private String name;
//    private Student[] students;
    private ArrayList<Student> students;
//    private int numStudents;

    // Constructor
    public Module(String name) {
        this.name = name;
        students = new ArrayList<>();
//        numStudents = 0;
    }
    
    public String getName() {
        return name;
        
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addStudent( Student student){
//        students[numStudents]= student;
//        numStudents++;
        students.add(student);
    }
}
