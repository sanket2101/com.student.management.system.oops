package com.student.management.system.oops;

import com.student.management.system.exception.*;

import java.sql.SQLOutput;
import java.util.Objects;

public final class Teacher extends Person {
    //instance variable

    private String employeeId;
    private String subjectTheyTeach;
    private int yearOfExperience;
    private double salaryDetails;
    private static int teacherCount;
    private static final int BASE_SALEY=30000; //Constant -----final-----static----Upper case
    private static final int EXPERIENCE_BONUS=2000;
    //parameterize constructor
    public Teacher(String name, int age, String contactNumber, String address ,String employeeId, String subjectTheyTeach, int yearOfExperience) {
        super(name,age,contactNumber,address);
        if(validateAddress(address) && validateAge(age)&& validateContactNumber(contactNumber) && validateEmpID(employeeId) &&validateSubject(subjectTheyTeach) && validateTeacherYearOfExperience(yearOfExperience)) {
            this.name = name;
            this.age = age;
            this.contactNumber = contactNumber;
            this.address = address;
            this.employeeId = employeeId;
            this.subjectTheyTeach = subjectTheyTeach;
            this.yearOfExperience = yearOfExperience;
            calculateTotalSalary();
            teacherCount++;
        }
    }

    //Getter and Setter
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
        if(validateAge(age)) {
            this.age = age;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(validateAddress(address)) {
            this.address = address;
        }
    }
    public String getEmployeeId() {
        return employeeId;
    }


    public String getSubjectTheyTeach() {
        return subjectTheyTeach;
    }

    public void setSubjectTheyTeach(String subjectTheyTeach) {
        if(validateSubject(subjectTheyTeach)) {
            this.subjectTheyTeach = subjectTheyTeach;
        }
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        if(validateTeacherYearOfExperience(yearOfExperience)) {
            this.yearOfExperience = yearOfExperience;
        }
    }

    public double getSalaryDetails() {
        return salaryDetails;
    }

    public void setSalaryDetails(double salaryDetails) {
        this.salaryDetails = salaryDetails;
    }

    //calculate method
    protected final void calculateTotalSalary(){  //restrict method overriding
        salaryDetails=(yearOfExperience*EXPERIENCE_BONUS)+BASE_SALEY;
    }


    // Validation methods
    public boolean validateAge(int age){

        if(age>21 && age<=58){
            return true;
        }
        else {
            throw new InvalidAgeException("Enter Teacher Age in between 21 to 58 Year");
        }
    }
    public boolean validateAddress( String address){
        if(address !=""){
            return true;
        }
        else {
            throw  new InvalidAddressException("Teacher address should not be empty");
        }
    }
    public  boolean validateContactNumber(String contactNumber){
        if(contactNumber!=null && contactNumber.matches("\\d{10}")){
            return true;
        }
        else {
            throw  new InvalidContactNumberException("Teacher contact number should be in 10 Digit Number");
        }
    }
    public boolean validateEmpID(String employeeId){
        if(employeeId.matches("T\\d{3}")) {
            return true;
        }
        else
            throw  new InvalidEmpIdException("Enter Employee id in Start with T and later 3 digit i.e. T123");

    }
    public boolean validateSubject( String subject){
        if(subject !=""){
            return true;
        }
        else {
            throw  new InvalidSubjectException("Subject should not be empty");
        }
    }
    public boolean validateTeacherYearOfExperience(int yearOfExperience) {
        if(yearOfExperience>=0 && yearOfExperience<=35){
            return  true;
        }
        else
            return false;
    }

    //displayTeacherBasicInfo method

    public  void displayBasicInfo(){
        System.out.println("------------Teacher Info-----------");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("ContactNumber: "+contactNumber);
        System.out.println("Address: "+address);
        System.out.println("Employee ID: "+employeeId);
        System.out.println("Subject: "+subjectTheyTeach);
        System.out.println("Experience: "+yearOfExperience);
        System.out.println("Excepted salary: "+salaryDetails);
        System.out.println("------------------------------------");
    }


    // updating addresses and contactNumber
    public boolean updateInformation(String newAddress, String newContactNumber) {
        //HR approval
        System.out.println("Request to HR Approval ");
        boolean hrApprovalStatus = getHRApproval();

        if (hrApprovalStatus) {
            if (super.updateInformation(newAddress, newContactNumber)) {
                System.out.println("Notifying to HR");
                return true;
            }
            else{
                System.err.println("No approval from HR");
                return false;
            }
        }
        return false;

    }
    public boolean updateInformation(String newAddress) {
        //HR approval
        System.out.println("Request to HR Approval ");
        boolean hrApprovalStatus = getHRApproval();

        if (hrApprovalStatus) {
            if (super.updateInformation(newAddress)) {
                System.out.println("Notifying to HR");
                return true;
            }
            else{
                System.err.println("No approval from HR");
                return false;
            }
        }
        return false;

    }
    public boolean updateInformation(String newAddress, boolean update) {
        //HR approval
        System.out.println("Request to HR Approval ");
        boolean hrApprovalStatus = getHRApproval();

        if (hrApprovalStatus) {
            if (super.updateInformation(newAddress, update)) {
                System.out.println("Notifying to HR");
                return true;
            }
            else{
                System.err.println("No approval from HR");
                return false;
            }
        }
        return false;

    }
    //Dummy Method for approval
    private boolean getHRApproval() {
        //dummy
        return true;
    }


    //ToString and equels and hash code methods
    public  static int getTotalTeacherCount(){
        return teacherCount;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", subjectTheyTeach='" + subjectTheyTeach + '\'' +
                ", yearOfExperience=" + yearOfExperience +
                ", salaryDetails=" + salaryDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age && yearOfExperience == teacher.yearOfExperience && Double.compare(salaryDetails, teacher.salaryDetails) == 0 && Objects.equals(name, teacher.name) && Objects.equals(contactNumber, teacher.contactNumber) && Objects.equals(address, teacher.address) && Objects.equals(employeeId, teacher.employeeId) && Objects.equals(subjectTheyTeach, teacher.subjectTheyTeach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, contactNumber, address, employeeId, subjectTheyTeach, yearOfExperience, salaryDetails);
    }
}
