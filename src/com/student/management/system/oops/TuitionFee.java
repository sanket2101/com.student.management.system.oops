package com.student.management.system.oops;

public class TuitionFee implements Payable{
    private final double baseFees;
    private final double scholarshipDeduction;
    private final double earlyPaymentDiscount;
    private double finalFeesAmount;

    public TuitionFee(double baseFees, double scholarshipDeduction, double earlyPaymentDiscount) {
        this.baseFees = baseFees;
        this.scholarshipDeduction = scholarshipDeduction;
        this.earlyPaymentDiscount = earlyPaymentDiscount;
    }

    @Override
    public double calculatePayment() {
        finalFeesAmount=baseFees-scholarshipDeduction-earlyPaymentDiscount;
        return finalFeesAmount;
    }

    @Override
    public void genrateReceipt() {
        System.out.println("******************** Generating Fess Receipt ******************** ");
        System.out.println("Basic Fees: "+baseFees);
        System.out.println("Deduction: -"+scholarshipDeduction);
        System.out.println("Early Discount: -"+earlyPaymentDiscount);
        System.out.println("Total Fees Paid: "+finalFeesAmount);
        System.out.println("******************** Good Day!! ********************");
    }

    @Override
    public double getDiscount() {
        return (scholarshipDeduction+earlyPaymentDiscount);
    }
}
