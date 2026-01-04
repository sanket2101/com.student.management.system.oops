package com.student.management.system.oops;

import com.student.management.system.exception.InvalidAddressException;
import com.student.management.system.exception.InvalidContactNumberException;

import java.io.Serializable;

public abstract class Person  implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String name;
    protected int age;
    protected String contactNumber;
    protected String address;
    private static int personCount=0;

    public Person(String name, int age, String contactNumber, String address) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.address = address;
        personCount++;
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
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        if((validateContactNumber(contactNumber))) {
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
    //Validation method
    public boolean validateAddress( String address){
        if(address !=""){
            return true;
        }
        else {
            throw new InvalidAddressException("Address can not be empty or NULL");
        }
    }
    public  boolean validateContactNumber(String contactNumber){
        if(contactNumber!=null && contactNumber.matches("\\d{10}")){
            return true;
        }
        else {
            throw  new InvalidContactNumberException("Contact number should be in 10 Digit Number");
        }
    }

//updatingInformation
    protected boolean updateInformation(String newAddress, String newContactNumber) {
        if(validateAddress(newAddress)&& validateContactNumber(newContactNumber)){
            address=newAddress;
            contactNumber=newContactNumber;
            return true;
        }
        else{
            return false;
        }
    }

    protected boolean updateInformation(String newAddress) {
        if(validateAddress(newAddress)){
            address=newAddress;
            return true;
        }
        else{
            return false;
        }
    }
    protected boolean updateInformation(String newContactNumber, boolean update) {
        if(validateContactNumber(newContactNumber)){
            contactNumber=newContactNumber;
            return true;
        }
        else{
            return false;
        }
    }
    public static int getTotalPersonCount(){
        return personCount;
    }
}
