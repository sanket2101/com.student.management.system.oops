package com.student.management.system.oops;

public class SportsActivityFee implements Payable{
    private double equipmentCharges;
    private double tournamentFees;
    private double teamUniformCost;
    private double discountForStatePlayer;
    private double finalSportFees;

    public SportsActivityFee(double equipmentCharges, double tournamentFees, double teamUniformCost, double discountForStatePlayer) {
        this.equipmentCharges = equipmentCharges;
        this.tournamentFees = tournamentFees;
        this.teamUniformCost = teamUniformCost;
        this.discountForStatePlayer = discountForStatePlayer;
    }

    @Override
    public double calculatePayment() {
        finalSportFees=equipmentCharges+tournamentFees+teamUniformCost-discountForStatePlayer;
        return finalSportFees;
    }

    @Override
    public void genrateReceipt() {
        System.out.println("******************** Generating Sport Fess Receipt ******************** ");
        System.out.println("EquipmentCharges: "+equipmentCharges);
        System.out.println("tournamentFees: +"+tournamentFees);
        System.out.println("TeamUniformCost: +"+teamUniformCost);
        System.out.println("DiscountForStatePlayer: -"+discountForStatePlayer);
        System.out.println("FinalSportFees: "+finalSportFees);
        System.out.println("******************** Good Day!! ********************");
    }

    @Override
    public double getDiscount() {
        return discountForStatePlayer;
    }
}
