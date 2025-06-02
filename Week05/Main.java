/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package student;
package Week5;
/**
 *
 * @author gore
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student student = new Student("Daisy", 6666);
        Module module = new Module("OOP");
        
        student.addModule(module);
        student.addModule(new Module("IS"));
        student.addModule(new Module("DevOps"));
        student.addModule(new Module("MfC"));
        student.addModule(new Module("CaDL"));

        System.out.println("student name: " + student.getName()); 
        student.displayModules();
    }
    
}
