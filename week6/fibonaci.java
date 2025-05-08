package week6;
import java.util.*;

public class fibonaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int n1 = 1;
        int hasil = 0;
        int n2 = 0;
        System.out.println(n1);
        for(int i = 1; i < n;i++){
            hasil = n1+n2;
            System.out.println(hasil);
            n2 = n1;
            n1 = hasil;
        }
    }
}
