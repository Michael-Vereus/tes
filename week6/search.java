package week6;
import java.util.*;
public class search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        
        while(true){
        System.out.println("Welcome to Transaction Recorder");
        System.out.println("1. Input Receipt");
        System.out.println("2. Search Receipt");
        System.out.println("3. Check Receipt");
        System.out.println("4. Exit");
        String menu = sc.nextLine();
        String[] kode_receipt = new String[100];
        String[] tanggal_receipt = new String[100];
        float[] total_receipt = new float[100];
        int index_kode = 0;
            switch (menu) {
            case "1" :
                System.out.print("How many receipts would you like to input? : ");
                    int sum = Integer.parseInt(sc.nextLine());
                    for (int j = 0; j < sum; j++) {
                        System.out.println("\nReceipt #" + (j + 1));
                        System.out.print("Enter the receipt code: ");
                        kode_receipt[index_kode] = sc.nextLine();

                        System.out.print("Enter the receipt date: ");
                        tanggal_receipt[index_kode] = sc.nextLine();

                        System.out.print("Enter the grand total on the receipt: ");
                        total_receipt[index_kode] = sc.nextFloat();
                        sc.nextLine(); // Clear the leftover newline

                        index_kode++;
                    }
            break;
                
            case "2" :
                System.out.print("Enter the receipt code to search: ");
                String query = sc.nextLine().trim();  // trims leading/trailing spaces
                boolean found = false;

                for (int k = 0; k < index_kode; k++) {
                    if (query.equals(kode_receipt[k])) {
                        System.out.println("\n=== Search Result ===");
                        System.out.println("Code  : " + kode_receipt[k]);
                        System.out.println("Date  : " + tanggal_receipt[k]);
                        System.out.println("Total : " + total_receipt[k]);
                        found = true;
                        break;
                        }
                    }
                    
                    if (!found) {
                        System.out.println("Receipt not found.");
                    }
            

            break;
            
            case "3" :
                
            break;

            case "4" : 
                System.out.println("Terima Kasih telah menggunakan program kami");
                
            return;
            default :
                System.out.println("Error Code");
            }
        }
        
        
    }
}
