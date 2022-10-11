public class TipCalculator {
    private double percentage;
    private int numOfPeople;
    private double totalCostBeforeTip;
    public TipCalculator(double percentage, int numOfPeople) {
        this.percentage = percentage;
        this.numOfPeople = numOfPeople;
    }
    void addMeal(double toAdd) {
        totalCostBeforeTip += toAdd;
    }
    double tipAmt() {
        return (totalCostBeforeTip * (percentage/100));
    }
    double getTipPercentage() {
        return percentage;
    }
    double getTotalBillBeforeTip() {
        return totalCostBeforeTip;
    }
    double totalTip() {
        return totalCostBeforeTip + tipAmt();
    }
    double perPersonCostBeforeTip() {
        return totalCostBeforeTip / numOfPeople;
    }
    double perPersonTipAmount() {
        return (tipAmt())/numOfPeople;
    }
    double perPersonTotalCost() {
        return perPersonTipAmount() + (totalCostBeforeTip/numOfPeople);
    }
}