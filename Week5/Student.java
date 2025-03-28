/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package student;
package Week5;
import java.util.ArrayList;
public class Student {

    protected int number;
    private String name;
    String course;
//    private Module[] modules;
    private ArrayList<Module> modules;
//    private int numModules; // 0 .. 5

    // Constructor
    public Student(String name, int number) {
        this.name = name;
        this.number = number;
        modules = new ArrayList<>();
//        numModules = 0;
    }

    public void changeCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addModule(Module module) {
//        modules[numModules] = module; // at end of array
//        numModules++; // one more module
        modules.add(module); // at end of array
    }

    public int findModule(String moduleName) {
        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getName().equals(moduleName)) {
                return i;
            }
        }
        return 0;
    }

    public void deleteModule(String moduleName) {
        int index = findModule(moduleName);
        if (index != 0) {
            modules.remove(index);
        }
    }

    public void displayModules() {
        for (Module module : modules) {
            System.out.println(module.getName());
        }
    }
}
