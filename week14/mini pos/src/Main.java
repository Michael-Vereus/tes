
import java.text.DecimalFormat;
import java.util.*;
class stock{
    private String name;
    private int quantity;
    private double price;

    public stock(String name, int quantity, double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName(){ return name;}

    public int getQuantity(){ return quantity;}

    public double getPrice(){ return price;}

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void result(){
        System.out.println("Name     : " + getName());
        System.out.println("Quantity : " + getQuantity());
        System.out.println("Price    : " + getPrice());
    }
}
class StockManager{
    private ArrayList<stock> listStock = new ArrayList<>();
    private Scanner sc;

    public StockManager(Scanner sc) {
        this.sc = sc;
    }

    public void addStock() {
        boolean add = true;
        while (add) {
            System.out.print("Name      : ");
            String tempName = sc.nextLine().trim();
            int tempQuantity = 0;
            while (true) {
                System.out.print("Quantity  : ");
                try {
                    tempQuantity = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input must be an Integer");
                }
            }

            System.out.print("Price     : ");
            String priceInput = sc.nextLine();
            String priceInputClean = priceInput.replaceAll("[^\\d]", "");
            double tempPrice = Double.parseDouble(priceInputClean);

            boolean found = false;
            for (stock s : listStock) {
                if (tempName.equalsIgnoreCase(s.getName())) {
                    s.setQuantity(s.getQuantity() + tempQuantity);
                    s.setPrice(tempPrice);
                    found = true;
                    System.out.println("Stock " + tempName + " telah diperbarui. ");
                    break;
                }
            }

            if (!found) {
                listStock.add(new stock(tempName, tempQuantity, tempPrice));
            }

            while (true) {
                System.out.print("Add another Stock? (Y/n)");
                String yn = sc.nextLine();
                if (yn.equalsIgnoreCase("Y")) {
                    break;
                } else if (yn.equalsIgnoreCase("n")) {
                    add = false;
                    break;
                }
            }
        }
    }

    public void removeStock(){
        if (listStock.isEmpty()) {
            System.out.println("Stock is Empty rn.\n");
            return;
        }
        checkStock();
        System.out.print("Input the number : ");
        String rm = sc.nextLine().trim();
        try {
            int index = Integer.parseInt(rm) - 1;

            if (index >= 0 && index < listStock.size()) {
                stock removed = listStock.remove(index);
                System.out.println("Stock '" + removed.getName() + "' successfully removed.\n");
            } else {
                System.out.println("Invalid Number.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input must be a Number.\n");
        }
    }
    public   void checkStock() {
        System.out.println("\n===== List of Stocks =====");
        System.out.printf("%-4s %-15s %-10s %-10s\n", "No", "Name", "Quantity", "Price");
        System.out.println("-------------------------------------------------------------");

        DecimalFormat df = new DecimalFormat("#,###");

        double totalNilai = 0;

        for (int i = 0; i < listStock.size(); i++) {
            stock s = listStock.get(i);

            double priceDouble = s.getPrice();
            String priceFormatted = "Rp " + df.format(priceDouble);
            System.out.printf("%-4d %-15s %-10d %-10s\n",
                    (i + 1), s.getName(), s.getQuantity(), priceFormatted);
        }

        System.out.println("-------------------------------------------------------------");
        System.out.println("Total Barang: " + listStock.size());
    }

}

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean runtime = true;
        while (runtime) {
            menu();
            String inputOpt = sc.nextLine();
            String opt = inputOpt.trim();
            StockManager sm = new StockManager(sc);
            switch (opt) {
                case "1":
                    sm.addStock();
                    break;
                case "2":
                    sm.checkStock();
                    break;
                case "3" :
                    sm.removeStock();
                    break;
                case "0":
                    runtime = exitProgram();
                    break;
            }
        }
    }

    // method show menu
    public static void menu(){
        System.out.println("==== Stock Organizer ====");
        System.out.println("1. Add Stock");
        System.out.println("2. Check Stock");
        System.out.println("3. Delete Stock");
        System.out.println("0. Exit");
        System.out.print("Choose menu : ");
    }

    //method add stock

    //method untuk exit program
    public static boolean exitProgram(){
        boolean temp = true;
        while(true){
            System.out.print("Are you sure you want to exit? (Y/n)");
            String yn = sc.nextLine();
            if(yn.equalsIgnoreCase("Y")){
                temp = false;
                break;
            }else if(yn.equalsIgnoreCase("n")){
                break;
            }
            else{
                System.out.println("Input Again !");
            }
        }
        return temp;
    }
}