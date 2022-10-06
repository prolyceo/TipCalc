import java.util.Scanner;
import java.text.DecimalFormat;

public class TipCalculatorRunner {
    public static void main(String[] args) {
        Scanner inpS = new Scanner(System.in);
        DecimalFormat decF = new DecimalFormat("#.##");

        System.out.println("This is a tip calculator.");
        System.out.print("How many people are in your group? ");
        int numOfPeople = inpS.nextInt();
        inpS.nextLine();

        System.out.print("What is the tip percentage, up to 100? ");
        double tipPercent = inpS.nextDouble();
        if (tipPercent <= 0 || tipPercent > 100) {
            System.out.println("The percentage cannot be less than 0 or more than 100.");
            System.exit(1);
        }
        inpS.nextLine();

        TipCalculator tipCalc = new TipCalculator(tipPercent, numOfPeople);

        // get food costs
        int finLoop = 0;
        double totalCost = 0;
        while (finLoop == 0) {
            System.out.print("Enter a cost of an item in dollars and cents, or -1 to finish: ");
            double tempVar = inpS.nextDouble();
            inpS.nextLine();
            if (tempVar > 0) {
                tipCalc.addMeal(tempVar);
            } else if (tempVar < 0) {
                finLoop = -1;
            }
        }

        // calculate tip itself
        double tipAmt = (totalCost * (tipPercent/100));

        // calculate cost with tip
        double costWithTip = (totalCost + tipAmt);

        // calculate cost per person before tip
        double perPersonNoTip = (totalCost / numOfPeople);

        // calculate tip per person
        double tipPerPerson = (tipAmt / numOfPeople);

        // calculate cost per person
        double costPerPerson = (costWithTip / numOfPeople);

        // format doubles and strings
        String formattedInitialC = decF.format(totalCost);
        String formattedTipAmt = decF.format(tipAmt);
        String formattedCwithT = decF.format(costWithTip);
        String formattedPerPNT = decF.format(perPersonNoTip);
        String formattedTipPerPerson = decF.format(tipPerPerson);
        String formattedCostPerPerson = decF.format(costPerPerson);

        // print
        System.out.println("Bill before tip: $"+formattedInitialC);
        System.out.println("Tip percentage: "+tipPercent+"%");
        System.out.println("Total tip: $"+formattedTipAmt);
        System.out.println("Total bill with tip: $"+formattedCwithT);
        System.out.println("Cost per person before tip: $"+formattedPerPNT);
        System.out.println("Tip per person: $"+formattedTipPerPerson);
        System.out.println("Total cost per person: $"+formattedCostPerPerson);


        inpS.close();
    }
}
