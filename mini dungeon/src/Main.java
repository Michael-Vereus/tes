import java.util.*;

abstract class Role{
    protected String name;
    protected int hp;
    protected int defense;
    protected int att;

    public Role(String name, int hp, int defense, int att){
        this.name = name;
        this.hp = hp;
        this.defense = defense;
        this.att = att;
    }
    //mengambil data hp, att, def dari object
    public int getHp(){return hp;}
    public int getDefense() {return defense;}
    public int getAtt() {return att;}
    //karena hp, def, att aku set bisa berubah ubah
    public void setHp(int hp) {this.hp = hp;}
    public void setDefense(int defense) {this.defense = defense;}
    public void setAtt(int att) {this.att = att;}
    //setiap role punya skill unik
    public abstract void useSkill();
    //output
    public void status(){
        System.out.println("Name   : " + name);
        System.out.println("Class  : " + this.getClass().getSimpleName());
        System.out.println("HP     : " + hp);
        System.out.println("ATK    : " + att);
        System.out.println("DEF    : " + defense);
    }
}

class Figther extends Role{
    public Figther(String name){
        super(name, 20,5,5  );
    }
    @Override
    public void useSkill(){
        System.out.println("Use Beserk (+5 Att)");
    }
}

class Tank extends Role{
    public Tank(String name){
        super(name, 20, 10,4);
    }
    @Override
    public void useSkill(){
        System.out.println("Use Thicc Armor (+4 Def)");
    }
}

class Archer extends Role{
    public Archer(String name){
        super(name, 20, 3,7);
    }
    @Override
    public void useSkill() {
        System.out.println("Use Raining Arrows (10 dmg)");
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello Fellow Traveler !");
        System.out.print("Your name ? : ");
        String usrName = sc.nextLine().trim();
        String choice = "";
        while (true) {
            System.out.println("Choose Your Class : \n1. Figther \n2. Tank \n3. Archer");
            choice = sc.nextLine().trim();
            if(choice.equals("1") || choice.equals("2") || choice.equals("3")){
                break;
            }
            else {
                System.out.println("Invalid choice !");
            }
        }
        Role player = null;
        switch (choice){
            case "1" : player = new Figther(usrName); break;
            case "2" : player = new Tank(usrName); break;
            case "3" : player = new Archer(usrName); break;
        }
        player.status();
        pause();

        boolean exploring = true;
        while(exploring){
            exploring = false;
        }
    }
    /// pause method
    public static void pause(){
        System.out.println("Press Enter To Continue");
        String cntn = sc.nextLine();

        if(cntn.equals("")){

        }else {

        }
    }
}