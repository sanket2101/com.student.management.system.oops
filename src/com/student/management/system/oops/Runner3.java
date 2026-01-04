package com.student.management.system.oops;

import java.io.*;

public class Runner3 {
    public static void main(String[] args) throws IOException {
        File dataFile = new File("Student.ser");
        if(dataFile.exists()){

            System.out.println("Data Found !!!! Loading from old Student.ser file");

            //Deserialized  method
            Deserialized();
        }
        else{

            System.out.println("Data is not found !!! Entering the Data !!!");

            Student student= new RegularStudent.RegularStudentBuilder("Sanket",
                    14,"7766667766","Pune")
                    .withRollNumber(14)
                    .withmarksObtainedInEnglish(70)
                    .withmarksObtainedInMaths(71)
                    .withmarksObtainedInScience(72)
                    .build();

            Student student1= new SportStudent.SportStudentBuilder("Snehal",16,"7666667766","Mumbai")
                    .withSportScore(90)
                    .withRollNumber(15)
                    .withmarksObtainedInEnglish(77)
                    .withmarksObtainedInMaths(78)
                    .withmarksObtainedInScience(79)
                    .build();
            Student student2= new SportStudent.SportStudentBuilder("Smita",18,"8866667788","Kolhapur")
                    .withSportScore(99)
                    .withRollNumber(16)
                    .withmarksObtainedInEnglish(87)
                    .withmarksObtainedInMaths(88)
                    .withmarksObtainedInScience(89)
                    .build();

            //Array of Object?
            //Creating Reference of array object

            Student studentArray[]= new Student[3];
            studentArray[0]=student;
            studentArray[1]=student1;
            studentArray[2]= student2;
            // Serialization method
            serialized(studentArray);
        }




    }

    private static void Deserialized() {
        File serializedData = new File("Student.ser");
        FileInputStream fis;
        ObjectInputStream ois;
        Student[] data = null;
        try {
            fis= new FileInputStream(serializedData);
            ois= new ObjectInputStream(fis);
            data=(Student[])ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(Student s:data){
            System.out.println(s);
        }
    }

    private static void serialized(Student[] studentArray) throws IOException {
        File serializedData = new File("Student.ser");
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
             fos= new FileOutputStream(serializedData);
            oos= new ObjectOutputStream(fos);
            oos.writeObject(studentArray);
            System.out.println("Data stored successfully ");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
