package com.student.management.system.oops;

public class RegularStudent extends Student{

    public RegularStudent(StudentBuilder studentBuilder) {
        super(studentBuilder);
        percentage=calculatePercentage();
        grade=calculateGrade();
    }

    @Override
    public double calculatePercentage() {
        //total marks
        double percentage=totalmarks/3.0;
        return percentage;
    }
    public  static class RegularStudentBuilder extends StudentBuilder {
        public RegularStudentBuilder(String name, int age, String contactNumber, String address) {
            super(name, age, contactNumber, address);
        }

        @Override
        public Student build() {
            Student student= new RegularStudent(this);
            return student;
        }
    }
}
