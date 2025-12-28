package com.student.management.system.oops;

public class Runner {
    public static void main(String[] args) {

//        Student s1;  // s1 is reference variable
//        s1= new Student("Sanket",19,12,"Pune","7768936548",77,77,77); // new Student() is object of student variable
//        // when object will create then
//        // 1. class is loaded in the memory
//        // 2. instances variable created inside in heap memory
//        // 3. constructor will call
//        s1.calculateTotalMarks();
//        s1.calculatePercentage();
//        s1.calculateGrade();
//        s1.displayStudentInfo();
//        System.out.println(s1);
//        s1.updateInformation("Mumbai","9898987766");
//        s1.displayStudentInfo();
//        System.out.println(("Total student joined today: "+s1.getTotalStudentCount()));


        /*
        s1.setName("Sanket");
        s1.setAge(18);
        s1.setRollnumber(12);
        s1.setMarksObtainedInEnglish(27);
        s1.setMarksObtainedInMaths(30);
        s1.setMarksObtainedInScience(32);
        s1.calculateTotalMarks();
        s1.calculatePercentage();
        s1.calculateGrade();
        s1.toString();


        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        System.out.println(s1.getRollnumber());
        System.out.println(s1.getMarksObtainedInScience());
        System.out.println(s1.getMarksObtainedInMaths());
        System.out.println(s1.getMarksObtainedInMaths());
        System.out.println(s1.getGrade());
        */



        // Teacher class creating object

        //This is polymorphism
        //1. Creating Parent class Reference variable and object creating for child class
        //2. This is called down casting and it is implicit
        //3. method overriding
        Person T1= new Teacher("Sanket Patil",23,"7768936548","Pune","T192","Maths",7);  //Down casting
        ((Teacher)T1).displayBasicInfo();  //upcasting  creating reference of child class and this is doing explicitly
        T1.updateInformation("Kolhapur","9011223344"); //This is method overriding while running used child class method
        ((Teacher)T1).displayBasicInfo();//upcasting  creating reference of child class and this is doing explicitly
        System.out.println("Total Teacher joined today: "+((Teacher)T1).getTotalTeacherCount());
    }
}
