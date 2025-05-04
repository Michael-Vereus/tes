package week4;
import java.util.*;

public class phone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ketikkan Kode USSD");
        String x = sc.nextLine();
        if(x.equals("*888#")){
            System.out.println("1. Cek Saldo");
            System.out.println("2. Cek Paket");
            System.out.println("3. Promo");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    System.out.println("Saldo anda sebesar Rp " + Math.random() * 100000);
                    break;
                case 2:
                    System.out.println("Paket anda yang anda miliki " + Math.random() * 100000 + "GB");
                    break;
                case 3:
                    System.out.println("Anda tidak memiliki promo apapun :( ");
                    break;
                default:
                    throw new AssertionError();
            }
    
        }
        else{
            System.out.println("Kode USSD Invalid");
        }
    }
}
