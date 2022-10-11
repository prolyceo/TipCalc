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

        TipCalculator Calc = new TipCalculator(tipPercent, numOfPeople);

        // get food costs
        int finLoop = 0;
        while (finLoop == 0) {
            System.out.print("Enter a cost of an item in dollars and cents, or -1 to finish: ");
            double tempVar = inpS.nextDouble();
            inpS.nextLine();
            if (tempVar > 0) {
                Calc.addMeal(tempVar);
            } else if (tempVar < 0) {
                finLoop = -1;
            }
        }

        // format doubles and strings
        String formattedInitialC = decF.format(Calc.getTotalBillBeforeTip());
        String formattedTipAmt = decF.format(Calc.tipAmt());
        String formattedCwithT = decF.format(Calc.totalTip());
        String formattedPerPNT = decF.format(Calc.perPersonCostBeforeTip());
        String formattedTipPerPerson = decF.format(Calc.perPersonTipAmount());
        String formattedCostPerPerson = decF.format(Calc.perPersonTotalCost());

        // print
        System.out.println("Bill before tip: $"+formattedInitialC);
        System.out.println("Tip percentage: "+Calc.getTipPercentage()+"%");
        System.out.println("Total tip: $"+formattedTipAmt);
        System.out.println("Total bill with tip: $"+formattedCwithT);
        System.out.println("Cost per person before tip: $"+formattedPerPNT);
        System.out.println("Tip per person: $"+formattedTipPerPerson);
        System.out.println("Total cost per person: $"+formattedCostPerPerson);


        inpS.close();
    }
}