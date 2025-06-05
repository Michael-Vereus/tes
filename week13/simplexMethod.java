package week13;
import java.util.*;
public class simplexMethod {
    static Scanner sc = new Scanner(System.in);
    static int variabelQuantity;
    static int probFunction;
    static double[][] table;
    static String[] variableNames;
    static int kolom, baris;
    public static void main(String[] args){
        inputVarDanFungsi();
    }
    public static void inputVarDanFungsi(){
        System.out.print("Berapa Variabel dalam soal tsb : ");
        variabelQuantity = Integer.parseInt(sc.nextLine());
        System.out.print("Berapa Banyak Fungsi Kendala dalam soal tsb : ");
        probFunction = Integer.parseInt(sc.nextLine());

        //setting ukuran array untuk baris + 2 dikarenakan adanya Zj dan Cj - Zj kemudian kolom + 1 dikarenakan ada quantity nya 
        kolom = variabelQuantity+probFunction+1;
        baris = probFunction;
        table = new double[baris+2][kolom];
        variableNames = new String[variabelQuantity];

        //input nama variabel
        System.out.println("\n-----------------------");
        for (int i = 0; i < variabelQuantity; i++){
            System.out.print("Nama Variabel ke - " + (i+1) + " : ");
            variableNames[i] = sc.nextLine();
        }
        System.out.println("-----------------------");

        //input data variabel dan persamaan
        for (int i = 0; i < baris; i++){
            System.out.println("-----------------------");
            System.out.println("Fungsi Kendala ke - " + (i+1));
            for (int j = 0; j < variabelQuantity; j++) {
                System.out.print("Konstanta variabel " + variableNames[j] + " : ");
                table[i][j] = Double.parseDouble(sc.nextLine());
            }
        }
    }
}
