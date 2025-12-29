package com.student.management.system.oops;

public class TransportFee implements Payable{
    private double baseFee;
    private  int paymentMonth;
    private double siblingDiscount;
    private double finalTransportFee;

    public TransportFee(double baseFee, int paymentMonth, double siblingDiscount) {
        this.baseFee = baseFee;
        this.paymentMonth = paymentMonth;
        this.siblingDiscount = siblingDiscount;
    }

    @Override
    public double calculatePayment() {
        finalTransportFee=(baseFee*paymentMonth)-siblingDiscount;
        return finalTransportFee;
    }

    @Override
    public void genrateReceipt() {
        System.out.println("******************** Generating Transport Fess Receipt ******************** ");
        System.out.println("Base Fee: "+baseFee);
        System.out.println("Payment for Month: *"+paymentMonth);
        System.out.println("SiblingDiscount: -"+siblingDiscount);
        System.out.println("FinalTransportFee: "+finalTransportFee);
        System.out.println("******************** Good Day!! ********************");
    }

    @Override
    public double getDiscount() {
        return siblingDiscount;
    }
}
