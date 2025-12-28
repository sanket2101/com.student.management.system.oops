package com.student.management.system.oops;

public class Runner3 {
    public static void main(String[] args) {
        Student student= new RegularStudent.RegularStudentBuilder("Sanket",14,"7766667766","Pune")
                .withRollNumber(14)
                .withmarksObtainedInEnglish(77)
                .withmarksObtainedInMaths(77)
                .withmarksObtainedInScience(77)
                .build();
        System.out.println(student);

        Student student1= new SportStudent.SportStudentBuilder("Snehal",16,"7666667766","Mumbai")
                .withSportScore(90)
                .withRollNumber(14)
                .withmarksObtainedInEnglish(77)
                .withmarksObtainedInMaths(77)
                .withmarksObtainedInScience(77)
                .build();
        System.out.println(student1);
    }
}
