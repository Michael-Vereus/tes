package week13;
import java.util.*;

public class pert132D {
    static int[][] progDua = new int[3][2];
    static Scanner sc = new Scanner(System.in);
    static int[][] progTiga;
    public static void main(String[] args) {
        while(true){
            int menuOpt = menu();
            switch(menuOpt){
                case 1 : 
                programSatu();
                break;
                case 2 :
                inputProgDua();
                break;
                case 3 :
                inputProgTiga();
                break;
                case 4 :
                System.out.println("Bye bye ");
                return;
            }
        }
    }
    public static int menu(){
        System.out.println("===== Pilih Program yang ingin anda jalankan =====");
        System.out.println("1. Penampilan Array 2D Tanpa input user");
        System.out.println("2. Penampilan Array 2D Dengan input user");
        System.out.println("3. Penampilan Array 2D Dengan full user input");
        System.out.println("4. Exit");
        System.out.print("Pilihan Anda : ");
        int tempOpt = Integer.parseInt(sc.nextLine());
        System.out.println("---------------------------");
        return tempOpt;
    }
    public static void programSatu(){
        int[][] array = {
            {5,3},
            {6,8},
            {9,5}
        };
        for(int i = 0; i < 3; i++){
            
            for(int j = 0; j < 2; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void inputProgDua(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                System.out.print("Masukkan Nilai Baris - " + i + " Kolom - " + j + " : " );
                progDua[i][j] = Integer.parseInt(sc.nextLine());
            }
            System.out.println("---------------------------");
        }
        outputProgDua();
    }
    public static void outputProgDua() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(progDua[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void inputProgTiga(){
        System.out.print("input ukuran baris : ");
        int baris = Integer.parseInt(sc.nextLine());
        System.out.print("input ukuran kolom : ");
        int kolom = Integer.parseInt(sc.nextLine());
        System.out.println("---------------------------");
        progTiga= new int[baris][kolom];
        for(int i = 0; i < baris; i++){
            for(int j = 0; j < kolom; j++){
                System.out.print("Masukkan Nilai Baris - " + i + " Kolom - " + j + " : " );
                progTiga[i][j] = Integer.parseInt(sc.nextLine());
            }
            System.out.println("---------------------------");
        }
        outputProgTiga(baris,kolom);
    }
    
    public static void outputProgTiga(int baris, int kolom) {
        for(int i = 0; i < baris; i++){
            for(int j = 0; j < kolom; j++){
                System.out.print(progTiga[i][j]+" ");
            }
            System.out.println();
        }
    }
}
