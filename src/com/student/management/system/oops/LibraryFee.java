package com.student.management.system.oops;

public class LibraryFee implements Payable{
    private  double basicSubscription;
    private  double additionalBookCharges;
    private  double lateReturnPenalty;
    private double finalLibraryFees;

    public LibraryFee(double basicSubscription, double additionalBookCharges, double lateReturnPenalty) {
        this.basicSubscription = basicSubscription;
        this.additionalBookCharges = additionalBookCharges;
        this.lateReturnPenalty = lateReturnPenalty;
    }

    @Override
    public double calculatePayment() {
        finalLibraryFees=basicSubscription+additionalBookCharges+lateReturnPenalty;
        return finalLibraryFees;
    }
    public  boolean processPayment(String paymentMode){
        if(paymentMode.equalsIgnoreCase("BITCOIN") ) {
            System.out.println("Connecting to Wallet !!! and Transferring 0000000.1 ");
            return true;
        }
        else{
            System.err.println("Something went wrong!!! ");
            return false;
        }
    }
    @Override
    public void genrateReceipt() {
        System.out.println("******************** Generating Library Fess Receipt ******************** ");
        System.out.println("basicSubscription: "+basicSubscription);
        System.out.println("additionalBookCharges: +"+additionalBookCharges);
        System.out.println("LateReturnPenalty: +"+lateReturnPenalty);
        System.out.println("FinalLibraryFees: "+finalLibraryFees);
        System.out.println("******************** Good Day!! ********************");
    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
