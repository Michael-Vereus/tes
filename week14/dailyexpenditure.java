package week14;

import java.text.DecimalFormat;
import java.util.*;

public class dailyexpenditure {
    static String day;
    static double budget;
    static Scanner sc = new Scanner(System.in);
    static String opt ;
    static ArrayList<String> expenseName = new ArrayList<>();
    static ArrayList<Double> expenseValues = new ArrayList<>();
    public static void main(String[] args) {
        budgetnDateInput();
        boolean running = true;
        while(running){
            menu();
            switch(opt){
                case "1" :
                    adjustBudget();
                break;
                case "2" :
                    addExpenditure();
                break;
                case "3" :
                    totalExpense();
                break;
                case "4" :
                    showBiggestExpenditure();
                break;
                case "5" :
                    removeExpenditure();
                break;
                case "0" :
                running = false;
                break;
            }

            confirmation();
            clearScreen();
        }
    }

    public static void budgetnDateInput(){
        System.out.println("Pocket Track");
        System.out.print("Day     : ");
        day = sc.nextLine();
        System.out.print("Budget  : ");
        String budgetInput = sc.nextLine();
        String budgetInputBersih = budgetInput.replaceAll("[^\\d]", "");
        budget = Double.parseDouble(budgetInputBersih);
    }

    public static void menu(){
        System.out.println("== PocketTrack Menu ==");
        budgetOutput();
        System.out.println("1. Adjust Budget (Increase/Decrease)");
        System.out.println("2. Add New Expenditure");
        System.out.println("3. View Total Expenditure");
        System.out.println("4. Show Biggest Expenditure");
        System.out.println("5. Remove an Expenditure");
        System.out.println("0. Exit");
        System.out.print("Enter Menu Num  : ");
        opt = sc.nextLine();

    }

    public static void budgetOutput(){
        DecimalFormat df = new DecimalFormat("#,###");
        String budgetOutput = "Rp " + df.format(budget);
        System.out.println("---- " + day + " ----");
        System.out.println("Budget : " + budgetOutput);
    }

    public static void adjustBudget(){
        boolean status = true;
        String adjust = "";
        while(status){
            System.out.println("Increase(I) / Decrease(D)");
            System.out.print("Choose : ");
            String decision = sc.nextLine();

            if(decision.equalsIgnoreCase("I")){
                adjust = "Increase";
                status = false;
            }
            else if(decision.equalsIgnoreCase("D")){
                adjust = "Decrease";
                status = false;
            }
            else{System.out.println("Invalid Input Please Try Again.");}
        }
        double amount = 0;
        status = true;
        while(status){
            System.out.print("Enter the amount : ");
            String amountInput = sc.nextLine();
            String amountInputClean = amountInput.replaceAll("[^\\d]", "");
            amount = Double.parseDouble(amountInputClean);
            if(amount < 0){
                System.out.println("Invalid Amount! Try Again");
            }
            else{
                status = false;
            }
        }
        if(adjust.equals("Increase")){
            budget = budget + amount;
        }
        else if(adjust.equals("Decrease")){
            budget = budget - amount;
        }
    }

    public static void addExpenditure(){
        boolean status = true;
        while(status){
            System.out.print("Expense Name : ");
            String inputNames = sc.nextLine();
            expenseName.add(inputNames);

            while (true){
                System.out.print("Expense Cost : ");
                String inputCost = sc.nextLine();
                String inputCostClean = inputCost.replaceAll("[^\\d]", "");
                double cost = Double.parseDouble(inputCostClean);
                if (cost <= 0){
                    System.out.println("Invalid number ! Try Again");
                }
                else{
                    expenseValues.add(cost);
                    break;
                }
            }
            while(true){
                System.out.println("Do you want to add another expense ? (Y/n)");
                String loop = sc.nextLine();
                if(loop.equalsIgnoreCase("Y")){break;}
                else if(loop.equalsIgnoreCase("n")){status = false; break;}
                else{System.out.println("Invalid Try Again.");}
            }
        }
    }

    public static void totalExpense(){
        System.out.println("--------------");
        DecimalFormat df = new DecimalFormat("#,###");
        double grandtotal = 0;
        for(int i = 0; i < expenseName.size(); i++ ){
            String valueOutput = "Rp " + df.format(expenseValues.get(i));
            grandtotal = grandtotal + expenseValues.get(i);
            System.out.println((i+1)+ ". " + expenseName.get(i) + " : " + valueOutput);
        }
        System.out.println("--------------");
        String grandTotalOutput = "Rp " + df.format(grandtotal);
        System.out.println("Total Expenditures : " + grandTotalOutput);
        if(grandtotal > budget){
            double diff = grandtotal - budget;
            String diffOutput = "Rp " + df.format(diff);
            System.out.println("You're Overbudget by " + diffOutput );
        }else {
            System.out.println("");
        }
    }

    public static void showBiggestExpenditure() {
        if (expenseValues.isEmpty()) {
            System.out.println("No expenditures recorded.");
            return;
        }

        double max = expenseValues.get(0);
        int indexMax = 0;
        for (int i = 1; i < expenseValues.size(); i++) {
            if (expenseValues.get(i) > max) {
                max = expenseValues.get(i);
                indexMax = i;
            }
        }

        DecimalFormat df = new DecimalFormat("#,###");
        String maxOutput = "Rp " + df.format(max);
        System.out.println("Biggest Expenditure:");
        System.out.println(expenseName.get(indexMax) + " : " + maxOutput);
    }

    public static void removeExpenditure() {
        if (expenseValues.isEmpty()) {
            System.out.println("No expenditures to remove.");
            return;
        }

        System.out.println("Current Expenditures:");
        DecimalFormat df = new DecimalFormat("#,###");
        for (int i = 0; i < expenseName.size(); i++) {
            System.out.println((i + 1) + ". " + expenseName.get(i) + " - Rp " + df.format(expenseValues.get(i)));
        }

        while (true) {
            System.out.print("Enter the number of the expense to remove: ");
            String input = sc.nextLine();

            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < expenseName.size()) {
                    System.out.println("Removing: " + expenseName.get(index));
                    expenseName.remove(index);
                    expenseValues.remove(index);
                    System.out.println("Expenditure removed.");
                    break;
                } else {
                    System.out.println("Invalid number. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void confirmation(){
        while(true){
            System.out.println("Continue ? (Press Enter To Continue)");
            String confirmation = sc.nextLine();

            if(confirmation.equalsIgnoreCase("Y")){return;}
            else{return;}
        }
    }
}
