package com.student.management.system.oops;

public enum PaymentMode implements DemoInterface{
    CASH("Payment received via Cash") {
        @Override
        public void test() {
            System.out.println("Test method from CASH");
        }
    },
    UPI("Payment received via Google Pay") {
        @Override
        public void test() {
            System.out.println("Test method from Google Pay");

        }
    },
    CARD("Payment received via credit card") {
        @Override
        public void test() {
            System.out.println("Test method from credit card");
        }
    };

    private String description;
    private PaymentMode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public abstract  void test();

    @Override
    public void demo() {
        System.out.println("From payment mode Demo method");
    }
}
