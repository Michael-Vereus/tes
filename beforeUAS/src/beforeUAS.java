import java.text.DecimalFormat;
import java.util.*;

class stock {
    private String stockName;
    private int stockQuantity;
    private double stockPrice;

    public stock(String stockName, int stockQuantity, double stockPrice){
        this.stockName = stockName;
        this.stockQuantity = stockQuantity;
        this.stockPrice = stockPrice;
    }

    public String getStockName(){return stockName;}
    public int getStockQuantity(){return stockQuantity;}
    public double getStockPrice(){return stockPrice;}

    public void setStockName(String stockName){this.stockName = stockName;}
    public void setStockQuantity(int stockQuantity){this.stockQuantity = stockQuantity;}
    public void setStockPrice(double stockPrice){this.stockPrice = stockPrice;}
}
class stockHandler{
    ArrayList<stock> listOfStocks = new ArrayList<>();
    ArrayList<String> transaksiHariIni = new ArrayList<>();
    double grandTotal = 0;
    Scanner sc;
    public stockHandler(Scanner sc){this.sc = sc;}

    public void addStock(){
        boolean add = true;
        while(add){
            System.out.print("Stock name : ");
            String tempName = sc.nextLine().trim();
            int tempQuantity = 0;
            while (true){
                System.out.print("Quantity : ");
                try{
                    tempQuantity = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input MUST be an INTEGER and a NUMBER");
                }
            }
            System.out.println("Price : ");
            String priceInput = sc.nextLine();
            String priceInputClean = priceInput.replaceAll("[^\\d]", "");
            Double tempPrice = Double.parseDouble(priceInputClean);
            boolean found = false;
            for (stock s : listOfStocks) {
                if (tempName.equalsIgnoreCase(s.getStockName())) {
                    s.setStockQuantity(s.getStockQuantity() + tempQuantity);
                    s.setStockPrice(tempPrice);
                    found = true;
                    System.out.println("Stock " + tempName + " telah diperbarui. ");
                    break;
                }
            }
            if (!found) {
                listOfStocks.add(new stock(tempName, tempQuantity, tempPrice));
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
    public void viewStocks() {
        System.out.println("\n===== List of Stocks =====");
        System.out.printf("%-4s %-15s %-10s %-10s\n", "No", "Name", "Quantity", "Price");
        System.out.println("-------------------------------------------------------------");

        DecimalFormat df = new DecimalFormat("#,###");

        double totalNilai = 0;

        for (int i = 0; i < listOfStocks.size(); i++) {
            stock s = listOfStocks.get(i);

            double priceDouble = s.getStockPrice();
            String priceFormatted = "Rp " + df.format(priceDouble);
            System.out.printf("%-4d %-15s %-10d %-10s\n",
                    (i + 1), s.getStockName(), s.getStockQuantity(), priceFormatted);
        }

        System.out.println("-------------------------------------------------------------");
        System.out.println("Total Barang: " + listOfStocks.size());
    }
    public void searchStock() {
        System.out.print("Masukkan nama stok yang ingin dicari: ");
        String keyword = sc.nextLine().trim().toLowerCase();

        boolean found = false;
        for (stock s : listOfStocks) {
            if (s.getStockName().toLowerCase().contains(keyword)) {
                System.out.println("Stock ditemukan: " + s.getStockName() +
                        " | Jumlah: " + s.getStockQuantity() +
                        " | Harga: Rp " + s.getStockPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Stock tidak ditemukan.");
        }
    }

    public void removeStock() {
        System.out.print("Masukkan nama stok yang ingin dihapus: ");
        String name = sc.nextLine().trim();
        boolean removed = listOfStocks.removeIf(s -> s.getStockName().equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Stock " + name + " telah dihapus.");
        } else {
            System.out.println("Stock tidak ditemukan.");
        }
    }

    public void buyStock() {
        System.out.print("Masukkan nama stok yang ingin dibeli: ");
        String name = sc.nextLine().trim();
        stock selected = null;

        for (stock s : listOfStocks) {
            if (s.getStockName().equalsIgnoreCase(name)) {
                selected = s;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Stok tidak ditemukan.");
            return;
        }

        int jumlah = 0;
        while (true) {
            System.out.print("Masukkan jumlah yang ingin dibeli: ");
            try {
                jumlah = Integer.parseInt(sc.nextLine());
                if (jumlah > selected.getStockQuantity()) {
                    System.out.println("Jumlah melebihi stok tersedia.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka.");
            }
        }
        double total = jumlah * selected.getStockPrice();
        selected.setStockQuantity(selected.getStockQuantity() - jumlah);
        grandTotal += total;

        String log = selected.getStockName() + " x" + jumlah + " = Rp " + total;
        transaksiHariIni.add(log);
        System.out.println("Transaksi dicatat: " + log);
    }
    public void showGrandTotal() {
        System.out.println("\n===== TRANSAKSI HARI INI =====");
        for (String transaksi : transaksiHariIni) {
            System.out.println("- " + transaksi);
        }
        System.out.println("-----------------------------");
        System.out.println("Total Pengeluaran Hari Ini: Rp " + grandTotal);
    }
}
public class beforeUAS {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        stockHandler sh = new stockHandler(sc);
        while (running){
            menu();
            System.out.print("Enter : ");
            String input = sc.nextLine().trim();
            switch (input){
                case "1":
                    sh.addStock(); break;
                case "2":
                    sh.viewStocks(); break;
                case "3":
                    sh.searchStock(); break;
                case "4":
                    sh.removeStock(); break;
                case "5":
                    sh.buyStock(); break;
                case "6":
                    sh.showGrandTotal(); break;
                case "0":
                    System.out.println("BYE 404");
                    running = false;
                    break;
            }
            pause(running);
        }
    }
    public static void menu(){
        System.out.println("\n===== MENU =====");
        System.out.println("1. Add Stock");
        System.out.println("2. View Stock");
        System.out.println("3. Search Stock");
        System.out.println("4. Remove Stock");
        System.out.println("5. Transactions");
        System.out.println("6. Total Transactions");
        System.out.println("0. Exit");
    }
    public static void pause(boolean running){
        if(running == true){

        }
        else {
            System.out.println("Press Enter To Continue");
            String resume = sc.nextLine();
        }
    }
}