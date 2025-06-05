package week10;
import java.util.*;

public class duadimensi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = 0;
        int b = 0;

        System.out.print("Masukkan jumlah baris: ");
        int baris = input.nextInt();
        System.out.print("Masukkan jumlah kolom: ");
        int kolom = input.nextInt();
        int[] hasil = new int[baris];
        int[] hasilKolom = new int[kolom];
        int[][] data = new int[baris][kolom];

        System.out.println("\nMasukkan elemen array:");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print("Elemen  [" + i + "][" + j + "]: ");
                data[i][j] = input.nextInt();
                a = a + data[i][j];
            }
            hasil[i] = a;
            a = 0;
        }
        for (int j = 0; j < kolom; j++) {
            for (int i = 0; i < baris; i++) {
                if (i == 0){
                    b = 0;
                }
                else {
                    b = b + data[i][j];
                }
            }
            hasilKolom[j] = b + data[0][j];
        }
        System.out.println("\nIsi array 2 dimensi:");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.print(hasil[i] + "\t");
            System.out.println();
        }
        for (int j = 0; j < kolom; j++){
            System.out.print(hasilKolom[j] + "\t");
        }

        input.close();
    }
}
