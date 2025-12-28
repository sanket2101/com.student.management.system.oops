package com.student.management.system.oops;

public class SportStudent extends Student {
    private double sportScore;

    private SportStudent(StudentBuilder studentBuilder) {
        super(studentBuilder);
        this.sportScore=((SportStudentBuilder)studentBuilder).sportScore;
        percentage=calculatePercentage();
        grade=calculateGrade();
    }

    @Override
    public double calculatePercentage() {
        System.out.println("Total Marks: "+getTotalmarks());
        System.out.println("sportScore Marks: "+sportScore);
        double academicPercentage=getTotalmarks()/3.0;
        double finalPercentage=(academicPercentage*0.8)+(sportScore*0.2);
        return finalPercentage;
    }

    @Override
    public String toString() {
        return "com.student.management.system.oops.SportStudent{" +
                "address='" + getAddress() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", contactNumber='" + getContactNumber() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", sportScore=" + sportScore +
                ", grade='" + getGrade() + '\'' +
                ", totalmarks=" + getTotalmarks() +
                ", percentage=" + percentage +
                ", rollnumber=" + getRollnumber() +
                ", marksObtainedInEnglish=" + getMarksObtainedInEnglish() +
                ", marksObtainedInScience=" + getMarksObtainedInScience() +
                ", grade='" + getGrade() + '\'' +
                ", totalmarks=" + getTotalmarks() +
                '}';
    }

    public  static class SportStudentBuilder extends StudentBuilder{

        private double sportScore;

        public SportStudentBuilder(String name, int age, String contactNumber, String address) {
            super(name, age, contactNumber, address);
        }

        public SportStudentBuilder withSportScore(double sportScore){
            if(sportScore>=0 && sportScore<=100){
                this.sportScore = sportScore;
            }
            return this;
        }
        @Override
        public Student build() {
            Student student= new SportStudent(this);
            return student;
        }
    }
}
