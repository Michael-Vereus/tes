package week14;
import java.util.*;

public class inputNilai {
    static String optMenu;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Double> listNilai = new ArrayList<>();
    static int c = 1;
    static double sum = 0;
    static double avg = 0;
    public static void main(String[] args) {
        while(true){
            menu();
            optMenu = sc.nextLine();
            switch (optMenu) {
                case "1":
                    inputNilai();
                    break;
                case "2" : 
                    avgCounter();
                break;
                case "0" : 
                return;
                default:
                System.out.println("Invalid Menu Opt");
            }
        }
    }
    public static void menu(){
        System.out.println("== Aplikasi Penghitung Rata - Rata ==");
        System.out.println("1. Input Nilai");
        System.out.println("2. Hit Rata Rata");
        System.out.println("0. Exit");
        System.out.print("Pilih Menu : ");
    }

    public static void inputNilai(){
        while (true){
            System.out.println("-------------------------------------");
            System.out.println("Masukkan Nilai Mahasiswa ke - " + c);
            double nilai = sc.nextFloat();
            if(nilai == -1){
                break;
            }
            else if (nilai > 100){
                System.out.println("Invalid Score");
            }
            else if (nilai < 0){
                System.out.println("Invalid Score");
            }
            else{
                listNilai.add(nilai);
                c++;
            }
        }
    }

    public static void avgCounter(){
        System.out.println("-------------------------------------");
        for (int i = 0; i < listNilai.size(); i++){
            double temp = listNilai.get(i);
            sum = sum + temp;
        }
        avg = sum/listNilai.size();
        System.out.println("Rata Rata = " + avg);
    }
}
