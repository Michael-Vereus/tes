package week1;

class pyramidupsidedown { 
    public static void main(String[] args) {
        int baris = 9 ;
        int d = baris ;
        for (int i = 1; i <= baris ; i++){                
            for (int j = 1; j <= i; j++){
                System.out.print(" ");
            }
            for (int a = 1; a <= d;a++){
                System.out.print("* ");
            }
            d = d-1 ;
            System.out.println();
        }
    }
}

