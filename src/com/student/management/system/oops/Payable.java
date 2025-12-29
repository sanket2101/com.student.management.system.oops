package com.student.management.system.oops;

public interface Payable {
    /*
     Interface is always going to have variable as CONSTANT!!
     method ->
     before java 1.8 -> abstract
     java 8 ->  Default Method :--- body
     java 9->  private

     */

    public abstract double calculatePayment();

//    public default boolean processPayment(String paymentMode){
//        if(paymentMode.equalsIgnoreCase("CASH") || paymentMode.equalsIgnoreCase("UPI")|| paymentMode.equalsIgnoreCase("CARD")){
//            System.out.println("Payment is Processing.......");
//            System.out.println("Payment Successful");
//            return true;
//        }
//        else{
//            System.err.println("Something went wrong!!! ");
//            return false;
//        }
//    }

    public default boolean processPayment(PaymentMode paymentMode){
        if(paymentMode==PaymentMode.CASH || paymentMode==PaymentMode.UPI|| paymentMode==PaymentMode.CARD){
            System.out.println("Payment is Processing.......");
            System.out.println("Payment Successful");
            return true;
        }
        else{
            System.err.println("Something went wrong!!! ");
            return false;
        }
    }

    public abstract void genrateReceipt();

    public abstract double getDiscount();

}
