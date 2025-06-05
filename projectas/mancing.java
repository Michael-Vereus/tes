package projectas;
import java.util.*;

public class mancing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== Fishing Life ====");
        System.out.println("");
        System.out.print("Enter Username : ");
        String usrname = sc.nextLine();
        while(true) {
            System.out.print("Enter Password : ");
            String password = sc.nextLine();

            String strength = checkTingkatPassword(password);
            if (password.length() >= 8){
                System.out.println("Tingkat Keamanan Password Anda : " + strength);
                break;
            }
            else {
                System.out.println("Password Anda kurang panjang");
            }
        }
        while(true) {
            
            String optMenu = sc.nextLine();
            switch (optMenu) {
                case "1" :
                System.out.println("You Caught : ");

                break;

                case "4" : 
                System.out.print("Apakah yakin untuk keluar ? (yes/NO) : ");
                String confirmation = sc.nextLine();
                if (confirmation == "yes"){
                    System.out.println("Thank You for playing our game");
                    return;
                }
                else {
                    
                }
                break;
            }
            break;
        }
    }
    //Check tingkat password
    public static String checkTingkatPassword(String password) {
        boolean adaUpCase = false;
        boolean adaLowCase = false;
        boolean adaAngka = false;
        boolean adaSimbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                adaUpCase = true ;
            }
            else if (Character.isLowerCase(c)) {
                adaLowCase = true ;
            }
            else if (Character.isDigit(c)) {
                adaAngka = true ;
            }
            else if (!Character.isLetterOrDigit(c)) {
                adaSimbol = true ;
            }
        }

        int score = 0;

        if (adaUpCase) score++;
        if (adaLowCase) score ++;
        if (adaAngka) score++;
        if (adaSimbol) score++;

        if (score == 4) return "High";
        else if (score >=2) return "Medium";
        else return "Low" ;
    }
    //penentu tipe ikan
    public static String fishTypeDeterminer(){
        String fishName = "";
        return fishName;
    }
    //penentu jumlah
    public static int fishQuantity(){
        int quantity = 0;
        return quantity;
    }
}

