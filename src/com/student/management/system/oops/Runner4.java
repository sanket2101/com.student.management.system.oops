package com.student.management.system.oops;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner4 {
    public static void main(String[] args) throws IOException {
        File dataFile = new File("Student.ser");
        System.out.println("*******************Student Management System **************");
        if(dataFile.exists()){

            System.out.println("Data Found !!!! Loading from old Student.ser file");

            //Deserialized  method
            Deserialized();
        }
        else{

            System.out.println("No Backup (Student.ser) found !!!!!");
            Scanner sc= new Scanner(System.in);
            ArrayList<Student>studentList= new ArrayList<Student>();

            while (true){
                System.out.println("Enter Student Name: ");
                String studentName = sc.nextLine();
                System.out.println("Enter Student age: ");
                int studentAge = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Student Address: ");
                String studentAddress = sc.nextLine();
                System.out.println("Enter  Parent contact number: ");
                String parentContactNumber = sc.nextLine();
                System.out.println("Enter Student RollNumber: ");
                int studentRollNumber = sc.nextInt();
                System.out.println("Enter Student Marks in English: ");
                int studentMarkInEnglish = sc.nextInt();
                System.out.println("Enter Student Marks in Science: ");
                int studentMarkInScience = sc.nextInt();
                System.out.println("Enter Student Marks in Maths: ");
                int studentMarkInMath = sc.nextInt();
                sc.nextLine();
                System.out.println("Is the Student a sport student? Yes or No ");
                String isSportStudent = sc.nextLine();
                if (isSportStudent.equalsIgnoreCase("yes")) {
                    System.out.println("Enter sport Marks: ");
                    int sportScore = sc.nextInt();
                    sc.nextLine();
                    Student student2 = new SportStudent.SportStudentBuilder(studentName, studentAge, parentContactNumber, studentAddress)
                            .withSportScore(sportScore)
                            .withRollNumber(studentRollNumber)
                            .withmarksObtainedInEnglish(studentMarkInEnglish)
                            .withmarksObtainedInMaths(studentMarkInMath)
                            .withmarksObtainedInScience(studentMarkInScience)
                            .build();
                    System.out.println(student2);
                    //studentArray[i]=student2;
                    studentList.add(student2);
                } else if (isSportStudent.equalsIgnoreCase("no")) {
                    Student student = new RegularStudent.RegularStudentBuilder(studentName,
                            studentAge, parentContactNumber, studentAddress)
                            .withRollNumber(studentRollNumber)
                            .withmarksObtainedInEnglish(studentMarkInEnglish)
                            .withmarksObtainedInMaths(studentMarkInMath)
                            .withmarksObtainedInScience(studentMarkInScience)
                            .build();
                    System.out.println(student);
                    //studentArray[i]=student;
                    studentList.add(student);
                } else {
                    throw new IllegalArgumentException("Enter the option is Yes or no");
                }
                System.out.println("Student Info Added ? Do you wish to add Anather Student(Yes/No)");
                String choice=sc.nextLine();
                if(choice.equalsIgnoreCase("NO")){
                    break;
                }
            }
//            for(Student array:studentArray){
//                System.out.println(array);
//            }
            serialized(studentList);


//            Student student1= new SportStudent.SportStudentBuilder("Snehal",16,"7666667766","Mumbai")
//                    .withSportScore(90)
//                    .withRollNumber(15)
//                    .withmarksObtainedInEnglish(77)
//                    .withmarksObtainedInMaths(78)
//                    .withmarksObtainedInScience(79)
//                    .build();
            //Array of Object?
            //Creating Reference of array object

//            Student studentArray[]= new Student[3];
//            studentArray[0]=student;
//            studentArray[1]=student1;
//            studentArray[2]= student2;
//            // Serialization method
//            serialized(studentArray);
        }




    }

    private static void Deserialized() {
        File serializedData = new File("Student.ser");
        FileInputStream fis;
        ObjectInputStream ois;
        List<Student> studentList= new ArrayList<Student>();
        try {
            fis= new FileInputStream(serializedData);
            ois= new ObjectInputStream(fis);
            studentList=(ArrayList<Student>)ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(Student s:studentList){
            System.out.println(s);
        }
    }

    private static void serialized(ArrayList<Student> studentList) throws IOException {
        File serializedData = new File("Student.ser");
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
             fos= new FileOutputStream(serializedData);
            oos= new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            System.out.println("Data stored successfully ");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
