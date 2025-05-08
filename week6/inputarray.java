package week6;
import java.util.*;
public class inputarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan angka berapa banyak angka yang ingin anda input");
        int n = 0;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int n1 = n;
        int n2 = n;
        double[] angka = new double[n];
        for(int i = 0; i < n1 ;i++){
            int counter = i+1;
            System.out.println("Masukkan angka ke" + counter);
            angka[i] = sc.nextDouble();
        }
        double max = Arrays.stream(angka).max().getAsDouble();
        double min = Arrays.stream(angka).min().getAsDouble();
        double avg = Arrays.stream(angka).average().getAsDouble();
        System.out.println("Rata rata dalam array anda " + avg);
        System.out.println("Nilai maks dalam array : "+ max);
        System.out.println("Nilai min dalam array : " + min);
        Arrays.sort(angka);
        for(int i = 0; i < n2 ;i++){
            System.out.println(angka[i]);
        }
    }
}
