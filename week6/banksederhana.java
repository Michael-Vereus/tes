package week6;
import java.util.*;
public class banksederhana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pin = "2" ;
        int i = 1;
        int j = i+1;
        int saldo = 100000;
        int USD = 0;
        int EUR = 0;
        int YEN = 0;
        do { 
            System.out.println("Welcome please input your pin");
            pin = sc.nextLine();
        } while (!pin.equals("1234"));
        while(i <= j){
            System.out.println("---------------------------");
            System.out.println("Selamat datang ke Menu Bank L'mantr");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Uang");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Tukar kurs");
            System.out.println("5. Cek kurs");
            System.out.println("6. Exit");
            System.out.println("---------------------------");
            String no = sc.nextLine();
            switch (no){
                case "1" :
                System.out.println("---------------------------");
                System.out.println("Saldo anda sebesar : Rp " + saldo);
                System.out.println("---------------------------");
                break;
                case "2" :
                System.out.println("---------------------------");
                System.out.println("Berapa nominal yang ingin anda setor hari ini");
                int setor = 0 ;
                try {
                    setor = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                saldo = saldo + setor;
                System.out.println("Transaksi setor tunai Anda sebesar Rp " + setor + " berhasil");
                System.out.println("---------------------------");
                break;
                case "3" :
                System.out.println("---------------------------");
                System.out.println("Berapa uang yang ingin anda tarik hari ini ");
                int tarik = 0 ;
                do { 
                    System.out.println("Pastikan tarik tunai anda kelipatan Rp 50.000 atau Rp 100.000");
                    try {
                        tarik = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    if(tarik > saldo){
                        tarik = 0;
                    }
                } while (tarik%50000 != 0|tarik < 0); 
                saldo = saldo - tarik ;
                System.out.println("Transaksi tarik tunai Anda sebesar Rp " + tarik + " telah berhasil");
                System.out.println("---------------------------");
                break;
                case "4" :
                System.out.println("---------------------------");
                System.out.println("Anda memiliki " + USD +" USD");
                System.out.println("Anda memiliki " + EUR +" EUR");
                System.out.println("Anda memiliki " + YEN +" YEN");
                System.out.println("---------------------------");
                System.out.println("Selamat datang ke Tukar Kurs");
                System.out.println("Apa yang ingin anda lakukan hari ini ?");
                System.out.println("1. Jual Kurs");
                System.out.println("2. Beli Kurs");
                System.out.println("---------------------------");
                String tukar = sc.nextLine();
                int Q = 0;
                int price = 0;
                    String nkurs = "";
                switch(tukar){
                    case "1" :
                    System.out.println("Harga Nilai Jual Kurs");
                    System.out.println("1. IDR -> USD : Rp 13.808");
                    System.out.println("2. IDR -> EUR : Rp 17.171");
                    System.out.println("3. IDR -> YEN : Rp 130");
                    String kjual = sc.nextLine();
                    switch (kjual) {
                        case "1" :
                            price = 13308;
                            nkurs = "USD";
                        break;
                        case "2" : 
                            price = 17171;
                            nkurs = "EUR";
                        break;
                        case "3" :
                            price = 130;
                            nkurs = "YEN";
                        break;
                        
                    }
                    System.out.println("Berapa " + nkurs + " yang ingin anda beli");
                    try {
                        Q = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    int totalBayar = Q*price;
                    System.out.println("Maka total bayar anda Rp " + totalBayar );
                    String konfirmasi = "";
                    do{
                        System.out.println("Apakah anda ingin melanjutkan transaksi ini ? (Y/N)");
                        konfirmasi = sc.nextLine();
                    }while(!konfirmasi.equals("Y") | konfirmasi.equals("N"));
                    switch(konfirmasi){
                        case "Y":    
                        if(saldo > totalBayar){
                            saldo = saldo - totalBayar ;
                        }
                        else{
                        System.out.println("Saldo Anda tidak mencukupi");
                        System.out.println("---------------------------");
                        }
                        System.out.println("Saldo anda tersisa sebesar Rp " + saldo);
                        break;
                        case "N":
                        System.out.println("---------------------------");
                    } 
                    break;
                    case "2" :
                    System.out.println("Harga Nilai Beli Kurs");
                    System.out.println("1. IDR -> USD : Rp 13.670");
                    System.out.println("2. IDR -> EUR : Rp 16.752");
                    System.out.println("3. IDR -> YEN : Rp 126");
                    String kbeli = sc.nextLine();
                    switch (kbeli) {
                        case "1" :
                            price = 13308;
                            nkurs = "USD";
                        break;
                        case "2" : 
                            price = 17171;
                            nkurs = "EUR";
                        break;
                        case "3" :
                            price = 130;
                            nkurs = "YEN";
                        break;
                        
                    }
                    System.out.println("Berapa " + nkurs + " yang ingin anda beli");
                    try {
                        Q = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    int totalBayarjual = Q*price;
                    System.out.println("Maka total bayar anda Rp " + totalBayarjual );
                    String konfirmasi1 = "";
                    do{
                        System.out.println("Apakah anda ingin melanjutkan transaksi ini ? (Y/N)");
                        konfirmasi1 = sc.nextLine();
                    }while(!konfirmasi1.equals("Y") | konfirmasi1.equals("N"));
                    switch(konfirmasi1){
                        case "Y":    
                        if(saldo > totalBayarjual){
                            saldo = saldo - totalBayarjual ;
                        }
                        else{
                        System.out.println("Saldo Anda tidak mencukupi");
                        System.out.println("---------------------------");
                        }
                        System.out.println("Saldo anda tersisa sebesar Rp " + saldo);
                        break;
                        case "N":
                        System.out.println("---------------------------");
                    } 
                    break;
                }
                break;
                case "5" : 
                
                break;
                case "6" :
                String konfirmasi ="";
                System.out.println("---------------------------");
                do{
                    System.out.println("Apakah anda yakin untuk keluar? (Y/N)");
                    konfirmasi = sc.nextLine();
                }while(!konfirmasi.equals("Y")&&!konfirmasi.equals("N"));
                switch(konfirmasi){
                    case "Y":
                    System.out.println("Good Bye.");
                    System.out.println("---------------------------");
                    j = j-2;
                    break;
                    case "N":
                    System.out.println("---------------------------");
                }
                break;
            }
        }
    }
}