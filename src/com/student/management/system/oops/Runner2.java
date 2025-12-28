package com.student.management.system.oops;
//static import
import static com.student.management.system.oops.Student.*;
// if we use static import then we call method/instance variable without class name

public class Runner2 {
    public static void main(String[] args) {
        Student s1= new Student.StudentBuilder("Sanket",14,"7768936548","Kolhapur").withRollNumber(12).withmarksObtainedInEnglish(77).withmarksObtainedInMaths(77).withmarksObtainedInScience(77).build();
        System.out.println(s1);
        s1.displayStudentInfo();
        System.out.println(getTotalStudentCount());  // called directly method without class name
    }
}
