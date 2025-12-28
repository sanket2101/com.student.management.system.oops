package com.student.management.system.oops;

import java.util.Objects;

public abstract   class Student extends Person { // start of student class

        // variable which are created inside in the method called cas local variable.
        // Local variable created in stack memory.
        // Local variable are never initialize the default value implicitly (Explicit initialization is required)


        // variable declared inside class and is going to non-static called as Instances variable.
        // Instance variable are always created inside heap memory.
        // Instance variable will initialize with default value.
        // called as Properties of the class.



        private final int rollnumber;
        private final  double marksObtainedInEnglish;
        private final  double marksObtainedInMaths;
        private final double marksObtainedInScience;
        protected  String grade;
        protected  double totalmarks;
        protected  double percentage;
        private  static int studentCount;


       // Parameter constructor
//        public Student(String name, int age, int rollnumber, String address, String contactNumber,double marksObtainedInEnglish, double marksObtainedInMaths, double marksObtainedInScience) {
//           super(name, age,contactNumber,address);
//        if (validateAge(age) && validateRollnumber(rollnumber) && validateMarkOfEachSubject(marksObtainedInEnglish) && validateMarkOfEachSubject(marksObtainedInMaths) && validateMarkOfEachSubject(marksObtainedInScience) && validateAddress(address)&& validateContactNumber(contactNumber)) {
//            this.name = name;
//            this.age = age;
//            this.rollnumber = rollnumber;
//            this.contactNumber=contactNumber;
//            this.address=address;
//            this.marksObtainedInEnglish = marksObtainedInEnglish;
//            this.marksObtainedInMaths = marksObtainedInMaths;
//            this.marksObtainedInScience = marksObtainedInScience;
//            this.grade = grade;
//            this.totalmarks = totalmarks;
//            this.percentage = percentage;
//            studentCount++;
//        }
//    }

    protected Student(StudentBuilder studentBuilder){
        super(studentBuilder.name,studentBuilder.age,studentBuilder.contactNumber,studentBuilder.address);
        this.rollnumber=studentBuilder.rollnumber;
        this.marksObtainedInEnglish=studentBuilder.marksObtainedInEnglish;
        this.marksObtainedInMaths=studentBuilder.marksObtainedInMaths;
        this.marksObtainedInScience=studentBuilder.marksObtainedInScience;
        totalmarks=calculateTotalMarks();

        studentCount++;
    }


    // Setters and Getters
    public double getMarksObtainedInMaths() {
        return marksObtainedInMaths;
    }


    public String getName() {
           return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>10 && age<21){
            this.age = age;
        }
        else {
            System.out.println("Enter Student Age in between 18 to 35 Year");
        }
    }

    public int getRollnumber() {
        return rollnumber;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(validateAddress(address)) {
            this.address = address;
        }
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        if(validateContactNumber(contactNumber)) {
            this.contactNumber = contactNumber;
        }
    }

    public double getMarksObtainedInEnglish() {
        return marksObtainedInEnglish;
    }

    public double getMarksObtainedInScience() {
        return marksObtainedInScience;
    }

    public String getGrade() {
           return grade;
    }

    public double getTotalmarks() {
        return totalmarks;
    }

    //calculate methods
    public final double calculateTotalMarks() {  //restrict the method overriding
            double totalmarks;
             totalmarks=marksObtainedInEnglish+marksObtainedInMaths+marksObtainedInScience;
             return totalmarks;
            //System.out.println("Total marks Obtained:"+totalmarks);
        }

    public abstract  double calculatePercentage();

    public final String calculateGrade(){
        String grade;
           if(percentage==0){
              grade="Percentage can not be calculated";
           }
           else {
             grade=GradePolicy.calculateGrade(percentage);
           }
           return grade;
    }

    // Validation methods

     public  void displayStudentInfo() {
         System.out.println("-------StudentInfo -------");
         System.out.println("Name: "+name);
         System.out.println("Age: "+age);
         System.out.println("Rollnumber: "+rollnumber);
         System.out.println("Address: "+address);
         System.out.println("ContactNumber: "+contactNumber);
         System.out.println("MarksObtainedEnglish: "+marksObtainedInEnglish);
         System.out.println("MarksObtainedMaths: "+marksObtainedInMaths);
         System.out.println("MarksObtainedScience: "+marksObtainedInScience);
         System.out.println("---------------------------");
         System.out.println("TotalMark: "+totalmarks);
         System.out.println("Percentage: "+percentage);
         System.out.println("Grade: "+grade);
         System.out.println("-------------------------");
     }

// updating addresses and contactNumber
   public boolean updateInformation(String newAddress, String newContactNumber) {
       //Parent approval
       System.out.println("Request to Parent Approval ");
       boolean parentApprovalStatus = parentApproval();

       if (parentApprovalStatus) {
           if (super.updateInformation(newAddress, newContactNumber)) {
               System.out.println("Notifying from parent");
               return true;
           }
           else{
               System.err.println("No approval from parent");
               return false;
           }
       }

       return false;

   }
    public boolean updateInformation(String newAddress) {
        //Parent approval
        System.out.println("Request to Parent Approval ");
        boolean parentApprovalStatus = parentApproval();

        if (parentApprovalStatus) {
            if (super.updateInformation(newAddress)) {
                System.out.println("Notifying from parent");
                return true;
            }
            else{
                System.err.println("No approval from parent");
                return false;
            }
        }

        return false;

    }
    public boolean updateInformation(String newContactNumber,boolean update) {
        //Parent approval
        System.out.println("Request to Parent Approval ");
        boolean parentApprovalStatus = parentApproval();

        if (parentApprovalStatus) {
            if (super.updateInformation(newContactNumber,update)) {
                System.out.println("Notifying from parent");
                return true;
            }
            else{
                System.err.println("No approval from parent");
                return false;
            }
        }

        return false;

    }

    //Dummy Method for approval
    private boolean parentApproval() {
        return true;
    }

    public static int getTotalStudentCount(){
            return studentCount++;
}

    // tostring ,equals and hashcode method

       @Override
       public String toString () {
           return "Student{" +
                   "name='" + name + '\'' +
                   ", age=" + age +
                   ", rollnumber=" + rollnumber +
                   ", address='" + address + '\'' +
                   ", contactNumber='" + contactNumber + '\'' +
                   ", marksObtainedInEnglish=" + marksObtainedInEnglish +
                   ", marksObtainedInMaths=" + marksObtainedInMaths +
                   ", marksObtainedInScience=" + marksObtainedInScience +
                   ", grade='" + grade + '\'' +
                   ", totalmarks=" + totalmarks +
                   ", percentage=" + percentage +
                   '}';
       }

       @Override
       public boolean equals (Object o){
           if (o == null || getClass() != o.getClass()) return false;
           Student student = (Student) o;
           return age == student.age && rollnumber == student.rollnumber && Double.compare(marksObtainedInEnglish, student.marksObtainedInEnglish) == 0 && Double.compare(marksObtainedInMaths, student.marksObtainedInMaths) == 0 && Double.compare(marksObtainedInScience, student.marksObtainedInScience) == 0 && Double.compare(totalmarks, student.totalmarks) == 0 && Double.compare(percentage, student.percentage) == 0 && Objects.equals(name, student.name) && Objects.equals(grade, student.grade);
       }

       @Override
       public int hashCode () {
           return Objects.hash(name, age, rollnumber, marksObtainedInEnglish, marksObtainedInMaths, marksObtainedInScience, grade, totalmarks, percentage);
       }



       public abstract static class StudentBuilder {
            //Mandatory
            private String name;
            private int age;
            private String contactNumber;
            private String address;
            //optional
            private int rollnumber;
            private double marksObtainedInEnglish;
            private double marksObtainedInMaths;
            private double marksObtainedInScience;

           public StudentBuilder(String name, int age, String contactNumber, String address) {
               if (validateAge(age) && validateAddress(address) && validateContactNumber(contactNumber)) {
                   this.name = name;
                   this.age = age;
                   this.contactNumber = contactNumber;
                   this.address = address;
               }
           }

           public StudentBuilder withRollNumber(int rollnumber){
               if(validateRollnumber(rollnumber)) {
                   this.rollnumber = rollnumber;
               }
               return this;
           }

           public StudentBuilder withmarksObtainedInEnglish(double marksObtainedInEnglish){
               if(validateMarkOfEachSubject(marksObtainedInEnglish)) {
                   this.marksObtainedInEnglish = marksObtainedInEnglish;
               }
               return this;
           }

           public StudentBuilder withmarksObtainedInMaths(double marksObtainedInMaths){
               if(validateMarkOfEachSubject(marksObtainedInMaths)) {
                   this.marksObtainedInMaths = marksObtainedInMaths;
               }
               return this;
           }

           public StudentBuilder withmarksObtainedInScience(double marksObtainedInScience){
               if(validateMarkOfEachSubject(marksObtainedInScience)) {
                   this.marksObtainedInScience = marksObtainedInScience;
               }
               return this;
           }
           public abstract Student build();

           // validation method
           private boolean validateAge(int age){
               if(age>10 && age<=21){
                   return true;
               }
               else {
                   System.err.println("Enter Student Age in between 18 to 35 Year");
                   return false;
               }
           }

           private   boolean validateRollnumber(int rollnumber){
               if(rollnumber>=1){
                   return true;
               }
               else {
                   System.err.println("The roll number is invalid");
                   return false;
               }
           }
           private boolean validateMarkOfEachSubject(double marksofeachsubject){
               if(marksofeachsubject>100 && marksofeachsubject<0){
                   System.err.println("Enter marks is invalid");
                   return  false;
               }
               else
                   return true;
           }
           private boolean validateAddress( String address){
               if(address !=""){
                   return true;
               }
               else {
                   System.err.println("address should not be empty");
                   return false;
               }
           }
           private   boolean validateContactNumber(String contactNumber){
               if(contactNumber!=null && contactNumber.matches("\\d{10}")){
                   return true;
               }
               else {
                   System.err.println("Contact number should be in 10 Digit Number");
                   return false;
               }
           }

       }


}// end of student class
