package week14;
import java.lang.reflect.Array;
import java.util.*;

public class testFile {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> nama = new ArrayList<>();
    static ArrayList<Integer> random = new ArrayList<>();
    static String opt ;
    public static void main(String[] args) {
        boolean loop = true;
        while(true){
            menu();
            opt = sc.nextLine();
            switch (opt){
                case "1" :
                    inputNama();
                break;
                case "2" :
                    output();
                break;
                case "0" :
                    loop = false;
                break;
            }
        }
    }
    public static void menu(){
        System.out.println("===== Email Genarator =====");
        System.out.println("1. Input Nama");
        System.out.println("2. Tampilkan Nama");
        System.out.println("0. Exit");
        System.out.print("Menu : ");
    }

    public static void inputNama(){
        boolean status = true;
        while(status){
            System.out.print("Nama Lengkap    : ");
            String temp = sc.nextLine();
            nama.add(temp);

            Random num = new Random();
            int randomNumber = num.nextInt(99) + 10;
            random.add(randomNumber);
            while(true){
                System.out.println("Tambah Lagi ? (Y/n)");
                String confirmation = sc.nextLine();
                if (confirmation.equalsIgnoreCase("Y")){
                    break;
                }else if (confirmation.equalsIgnoreCase("n")) {
                    status = false;
                    break;
                }else{
                    System.out.println("Input Again!");
                }
            }

        }
    }

    public static void output(){
        for(int i = 0; i < nama.size(); i++){
            System.out.println("Nama   : " + nama.get(i));
            System.out.println("Random : " + random.get(i));
            String tempNama = nama.get(i);
            int numid = random.get(i);
            int spasiAwal = tempNama.indexOf(" ");
            int spasiAkhir = tempNama.lastIndexOf(" ");
            String email = "";
            if (spasiAwal != -1){
                String namaDepan = tempNama.substring(0, spasiAwal).toLowerCase();
                String namaBelakang = tempNama.substring(spasiAkhir+1).toLowerCase();
                email = namaDepan + "." + namaBelakang + numid + "@dinamika.id";
            }
            else if (spasiAwal == -1){
                email = tempNama + numid + "@dinamika.id";
            }
            System.out.println("Email : " + email);
        }
    }
}