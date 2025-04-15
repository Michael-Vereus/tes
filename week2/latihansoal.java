package week2;

public class latihansoal {
    public static void main(String[] args) {
        float r = 3f ;
        float phi = 3.14f;
        float luas = phi*r*r ;
        System.out.println(luas);
        //Soal ke dua
        String nama = "Alif";
        String produk = "Snack";
        float jumlahProduk = 3f; 
        float harga = 5000f;
        float subTotalBeli = harga*jumlahProduk;
        float diskon = 0.02f;
        float diskonHarga = subTotalBeli*diskon ;
        float grandTotal = Math.round(subTotalBeli-diskonHarga);

        System.out.println(grandTotal);
    }
    
}
