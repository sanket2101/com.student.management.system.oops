package com.student.management.system.oops;

public class PaymentRunner {
    public static void main(String[] args) {
        Payable payable= new TuitionFee(50000,10000,5000);
        payable.processPayment(PaymentMode.CASH);
        payable.calculatePayment();
        payable.genrateReceipt();
        System.out.println(payable.getDiscount());

        Payable payable1= new SportsActivityFee(5000,3000,2000,1000);
        payable1.processPayment(PaymentMode.UPI);
        payable1.calculatePayment();
        payable1.genrateReceipt();
        System.out.println(payable1.getDiscount());

        Payable payable2= new TransportFee(1000,3,500);
        payable2.processPayment(PaymentMode.UPI);
        payable2.calculatePayment();
        payable2.genrateReceipt();

        Payable payable3= new LibraryFee(500,200,100);
        //payable3.processPayment("BITCOIN");
        payable3.calculatePayment();
        payable3.genrateReceipt();
        System.out.println(payable3.getDiscount());


    }
}
