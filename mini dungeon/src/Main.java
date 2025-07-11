import java.util.*;

abstract class Role{
    protected String name;
    protected int hp;
    protected int defense;
    protected int att;
    protected int speed;
    //base stats sebelum buff or debuff
    protected int baseHp;
    protected int baseAtt;
    protected int baseDefense;
    protected int baseSpeed;
    //tracking buff/debuff duration
    protected int changesAttDuration = 0;
    protected int changesDefDuration = 0;
    protected int changesSpeedDuration = 0;

    public Role(String name, int hp, int defense, int att, int speed){
        //baseHp
        this.name = name;
        this.baseHp = hp;
        this.baseDefense = defense;
        this.baseAtt = att;
        this.baseSpeed = speed;
        //karena hp bisa berubah ubah maka dibuat variabel baru
        this.hp = hp;
        this.defense = defense;
        this.att = att;
        this.speed = speed;
    }
    //getter
    public int getHp(){return hp;}
    public int getDefense() {return defense;}
    public int getAtt() {return att;}
    public int getSpeed() {return speed;}
    //setter
    public void setHp(int hp) {this.hp = hp;}
    public void setDefense(int defense) {this.defense = defense;}
    public void setAtt(int att) {this.att = att;}
    public void setSpeed(int speed) {this.speed = speed;}

    //setiap role punya skill unik
    public abstract void useSkill(Enemy enemy);
    //output
    public void status(){
        System.out.println("Name   : " + name);
        System.out.println("Class  : " + this.getClass().getSimpleName());
        System.out.println("HP     : " + hp);
        System.out.println("ATK    : " + att);
        System.out.println("DEF    : " + defense);
        System.out.println("SPD    : " + speed);
    }
    //update for debuff or buff
    public void updateBuffStatus(){
        if(changesAttDuration > 0){
            changesAttDuration--;
            if(changesAttDuration == 0){
                att = baseAtt;
                System.out.println("Your Attack buff has worn off.");
            }
        }

        if(changesDefDuration > 0){
            changesDefDuration--;
            if(changesDefDuration == 0){
                defense = baseDefense;
                System.out.println("Your Defense buff has worn off.");
            }
        }

        if(changesSpeedDuration > 0){
            changesSpeedDuration--;
            if(changesSpeedDuration == 0){
                speed = baseSpeed;
                System.out.println("Your Speed buff has worn off.");
            }
        }
    }

}

class Figther extends Role{
    public Figther(String name){
        super(name, 20,5,5,5  );
    }
    @Override
    public void useSkill(Enemy enemy){
        System.out.println("Use Beserk (+5 Att)");
        this.setAtt(this.getAtt() + 5);
        this.changesAttDuration = 3;
    }
}

class Tank extends Role{
    public Tank(String name){
        super(name, 20, 10,4,2);
    }
    @Override
    public void useSkill(Enemy enemy){
        System.out.println("Use Thicc Armor (+4 Def)");
        this.setDefense(this.getDefense() + 4);
        this.changesDefDuration = 4;
    }
}

class Archer extends Role{
    public Archer(String name){
        super(name, 20, 3,7,7);
    }
    @Override
    public void useSkill(Enemy enemy) {
        System.out.println("Use Raining Arrows (7 dmg)");
        int dmg = 7 - enemy.enemyDef;
        dmg = Math.max(dmg,2);
        enemy.setEnemyHp(enemy.getEnemyHp() - dmg);
        System.out.println("You dealt " + dmg + " damage");
    }
}

abstract class Enemy{
    protected String name;
    protected int enemyHp;
    protected int enemyDef;
    protected int enemyAtt;

    public Enemy(String name, int enemyHp, int enemyDef, int enemyAtt){
        this.name = name;
        this.enemyHp = enemyHp;
        this.enemyDef = enemyDef;
        this.enemyAtt = enemyAtt;
    }
    //getter
    public int getEnemyHp() {return enemyHp;}
    public int getEnemyDef() {return enemyDef;}
    public int getEnemyAtt() {return enemyAtt;}

    //setter
    public void setEnemyHp(int enemyHp) {this.enemyHp = enemyHp;}
    public void setEnemyDef(int enemyDef) {this.enemyDef = enemyDef;}
    public void setEnemyAtt(int enemyAtt) {this.enemyAtt = enemyAtt;}

    public abstract void deBuff(Role player);

    public void output(){
        System.out.println("Name      : " + name);
        System.out.println("Enemy HP  : " + enemyHp);
        System.out.println("Enemy Def : " + enemyDef);
        System.out.println("Enemy Att : " + enemyAtt);
    }
}

class Slime extends Enemy{
    public Slime(){
        super("Slime", 10,4,3);
    }
    @Override
    public void deBuff(Role player){
        System.out.println("-5 Speed");
        player.setSpeed(player.getSpeed() - 5);
        player.changesSpeedDuration = 1;
    }
}
class Zombie extends Enemy{
    public Zombie(){
        super("Zombie", 20,1,5);
    }
    @Override
    public void deBuff(Role player){
        System.out.println("-3 Def");
        player.setDefense(player.getDefense() - 3);
        player.changesDefDuration = 2;
    }
}
class SkeletonArcher extends Enemy{
    public SkeletonArcher(){
        super("Skeleton Archer",15,2,7);
    }

    @Override
    public void deBuff(Role player) {
        System.out.println("-2 Att");
        player.setAtt(player.getAtt() - 2);
        player.changesAttDuration = 2;
    }
}

class exploringHandler {
    Scanner sc ;
    public exploringHandler(Scanner sc){
        this.sc = sc;
    }
    public void explore(Role player){
        Random rng = new Random();
        int chance = rng.nextInt(100);

        if(chance < 40){
            System.out.println("An Enemy has Appeared !!");
            Enemy enemy = generateEnemy();
            enemy.output();
            battleHandler(player, enemy);
        } else if(chance < 60){
            System.out.println("You found an Item!");
        } else if (chance < 80) {
            System.out.println("A magical fairy flies towards you...");
            Random perChance = new Random();
            int buff = perChance.nextInt(4);
            int boost = perChance.nextInt(3) + 1;
            switch (buff){
                case 0 :
                    player.setHp(20);
                    System.out.println("Your Health is Fully Restored.");
                    break;
                case 1 :
                    player.setAtt(player.getAtt() + boost );
                    System.out.println("+ " + boost + " Att");
                    break;
                case 2 :
                    player.setDefense(player.getDefense() + boost);
                    System.out.println("+ " + boost + " Def");
                    break;
                case 3 :
                    player.setSpeed(player.getSpeed() + boost);
                    System.out.println("+ " + boost + " Speed");
                    break;
                default:
                    player.setHp(20);
                    System.out.println("Your Health is Fully Restored.");
                    break;
            }
        }else {
            System.out.println("You wander around and realize its and empty room. . . .");
        }
    }
    public Enemy generateEnemy(){
        Random rng = new Random();
        int enemyType = rng.nextInt(3);
        switch (enemyType){
            case 0 : return new Slime();
            case 1 : return new Zombie();
            case 2 : return new SkeletonArcher();
            default: return new Slime();
        }
    }
    public void battleHandler(Role player, Enemy enemy){
        System.out.println("Battle Start !");
        player.status();
        enemy.output();
        while (player.getHp() > 0 && enemy.getEnemyHp() > 0){
            System.out.println("\n== YOUR TURN ==");
            System.out.println("1. Attack");
            System.out.println("2. Use Skill");
            System.out.println("3. Run");
            System.out.println("Choose : ");
            String input = sc.nextLine().trim();
            if(input.equals("1")){
                int damage = Math.max(player.getAtt() - enemy.getEnemyDef(),1);
                enemy.setEnemyHp(enemy.getEnemyHp()-damage);
                System.out.println("You attacked and dealt " + damage + " damage");
            } else if (input.equals("2")) {
                player.useSkill(enemy);
            }
            else if (input.equals("3")){
                Random rng = new Random();
                int esc = rng.nextInt(8);
                if(player.getSpeed() > esc ){
                    System.out.println("Successfully Escaped !");
                    return;
                } else {
                    System.out.println("Failed to escape");
                }
            }
            else {
                System.out.println("Invalid input. You miss your turn.");
            }
            if(enemy.getEnemyHp() <= 0) break;

            System.out.println("\n== ENEMY TURN ==");
            Random rng = new Random();
            int choice = rng.nextInt(100);
            if(choice <= 20){
                enemy.deBuff(player);
            } else {
                int enemyDamage = Math.max(enemy.getEnemyAtt() - player.getDefense(),1);
                player.setHp(player.getHp() - enemyDamage);
                System.out.println("Enemy dealt " + enemyDamage + " damage to you");
            }

            //update changes
            player.updateBuffStatus();

            //status
            System.out.println("\n == STATUS ==");
            System.out.println("You: " + player.getHp() + " HP");
            System.out.println("Enemy: " + enemy.getEnemyHp() + " HP");
        }

        if(player.getHp() > 0){
            System.out.println("Huurayy enemy slain !!");
        } else {
            System.out.println("Dang Bro You're dead");
        }
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
            menu();
            String opt = sc.nextLine().trim();
            exploringHandler explr = new exploringHandler(sc);
            switch (opt){
                case "A" :
                    explr.explore(player);
                    break;
                case "B" :

                    break;
                case "C" :
                    exploring = exit();
                    break;
            }
            pause();
        }
    }
    /// menu
    public static void menu(){
        System.out.println("A. Explore");
        System.out.println("B. Inventory");
        System.out.println("C. Exit");
        System.out.print("Choice : ");
    }
    /// pause method
    public static void pause(){
        System.out.println("Press Enter To Continue");
        String cntn = sc.nextLine();

        if(cntn.equals("")){

        }else {

        }
    }
    ///  Exit
    public static boolean exit(){
        boolean temp = true;
        while(true){
            System.out.print("Are you sure you want to exit ? (Y/n) : ");
            String exit = sc.nextLine().trim();
            if(exit.equalsIgnoreCase("Y")){
                temp = false;
                break;
            } else if (exit.equalsIgnoreCase("n")) {
                break;
            }
            else {
                System.out.println("Input Again !");
            }
        }
        return temp;
    }
}

/// note : resolve bug dimana ketika setelah membunuh musuh stat musuh tidak kembali seperti semula