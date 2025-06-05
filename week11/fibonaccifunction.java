package week11;
import java.util.*;

public class fibonaccifunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Aplikasi Pembuat Deret Fibonacci");
        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Create Fibonacci Sequence");
            System.out.println("2. Exit");
            System.out.print("Menu yang dipilih : ");
            String menuOpt = sc.nextLine();
            switch (menuOpt) {
                case "1":
                    System.out.print("Panjang Fibonacci Sequence : ");
                    int n = Integer.parseInt(sc.nextLine());
                    long n1 = 1;
                    long hasil = 0;
                    long n2 = 0;
                    System.out.print((n1-1) + " ");
                    System.out.print(n1 + " ");
                    n = n-1;
                    for (int i =1; i < n; i++) {
                        hasil = fibCreate(n1, n2);
                        System.out.print(hasil + " ");
                        n2 = n1;
                        n1 = hasil;
                    }
                    System.out.println("");
                break;
                case "2":
                    System.out.println("BYE BYE");
                return;
                default:
                    throw new AssertionError();
            }
        }
    }
    public static long fibCreate(long n1, long n2) {
        long tempHasil = n1 + n2;
        return tempHasil;
    }
}
