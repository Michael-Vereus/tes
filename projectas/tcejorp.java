package projectas;
import java.util.*;

public class tcejorp {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("==tcejorp==");
        System.out.print("Create Nickname : ");
        String nickname = sc.nextLine();
        System.out.print("Create Username : ");
        String username = sc.nextLine();
        while(true) {
            System.out.print("Create Password : ");
            String password = sc.nextLine();

            String strength = checkTingkatPassword(password);
            if (password.length() >= 8) {
                return;
            }
            else {
                System.out.println("===Password isn't long enough===");
            }
        }
    }
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

        if (score == 4) return "Strong";
        else if (score >=2) return "Medium";
        else return "Weak" ;
    }
}
