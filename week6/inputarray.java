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
        double max2 = angka[0];
        double min2 = angka[0];
        double jumlah = angka[0];
        for (int i = 1; i < angka.length; i++){
            if (angka[i] > max2){
                max2 = angka[i];
            }
            if (angka[i] < min2){
                min2 = angka[i];
            }
            jumlah = angka[i] + jumlah;
        }
        //dibawah ini untuk sort array
        for (int i = 0; i < angka.length; i++){
            for (int j = 0; j < angka.length; j++){
                if (angka[i] < angka[j]){
                    double temp = angka[j];
                    angka[j] = angka[i];
                    angka[i] = temp;
                }
            }
        
        }
        for(int j = 0; j < n2 ;j++){
            System.out.println(angka[j]);
        }
        double avg2 = jumlah/n;
        System.out.println("Nilai max : " + max2);
        System.out.println("Nilai min : " + min2);
        System.out.println("Nilai Average : " + avg2);
        double min = Arrays.stream(angka).min().getAsDouble();
        double avg = Arrays.stream(angka).average().getAsDouble();
        System.out.println("Rata rata dalam array anda " + avg);
        System.out.println("Nilai maks dalam array : "+ max);
        System.out.println("Nilai min dalam array : " + min);
    }
}
