package week10;
import java.util.*;

public class casestudy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==HAIII PIPINNN :3==");
        
        while (true) {
            System.out.print("Cilahkan masukkan Password yang ingin maw di test:3 : ");
            String password = sc.nextLine();
            String strength = checkPassStrength(password);

            if (password.length() >= 8) {
                if (strength == "STRONG") {
                    output1(strength);
                    return;
                }
                else {
                    output2(strength);
                }
            }
            else {
                System.out.println("wui pendek amay passwordnya -.-");
            }
        }
    }
    public static String checkPassStrength(String password){
        boolean hasUpCase = false ;
        boolean hasLowCase = false ; 
        boolean hasNum = false ;
        boolean hasSymbols = false ;

        for (char j : password.toCharArray()) {
            if (Character.isUpperCase(j)) {
                hasUpCase = true ;
            }
            else if (Character.isLowerCase(j)) {
                hasLowCase = true ;
            }
            else if (Character.isDigit(j)) {
                hasNum = true ;
            }
            else if (!Character.isLetterOrDigit(j)) {
                hasSymbols = true ;
            }
        }
        int score = 0;

        score = scoreChecker(hasLowCase, hasUpCase, hasNum, hasSymbols, score);
        if (score == 4) return "STRONG";
        else if (score >=2) return "B AJAA";
        else return "LEMAHH" ;
    }
    public static int scoreChecker(boolean hasLowCase, boolean hasUpCase, boolean hasNum, boolean hasSymbols, int score) {
        if (hasLowCase) score++;
        if (hasUpCase) score++;
        if (hasNum) score++;
        if (hasSymbols) score++;
        return score;
    }
    public static void output1(String strength) {
        System.out.print("WAUWWW PASSWORD ANDAA SANGAT " + strength);
    }
    public static void output2(String strength) {
        System.out.println("HUAAAAA PASSWORD ANDA SAMGAT " + strength);
        System.out.println("Cilahkan tambahkan simbol, digit, serta huruf kapital :>");
    }
}
