import java.util.*;

abstract class Role{
    protected ArrayList<Items> inventory = new ArrayList<>();
    protected final int maxInventorySize = 5;
    Scanner sc = new Scanner(System.in);
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
    //limit skill usage
    protected int skillCooldown = 0;
    protected final int skillCooldownDuration = 5;

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
    public void addItem(Items items){
        if (inventory.size() < maxInventorySize){
            inventory.add(items);
            System.out.println(items.getName() + " has been added to your inventory");
        }
        else {
            System.out.println("Inventory full! You must discard something.");
            showInventory();
            removeItem(items);
        }
    }
    public void showInventory(){
        System.out.println("=== Inventory ===");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.printf("%d. %s - %s\n", i + 1, inventory.get(i).getName(), inventory.get(i).getDesc());
        }
    }
    public void removeItem(Items items){
        boolean remove = true;
        while (remove){
            showInventory();
            System.out.print("Select the Item Number : ");
            String rm = sc.nextLine().trim();
            int index = Integer.parseInt(rm) - 1;
            try{
                if(index >= 0 && index < inventory.size()){
                    Items removed = inventory.remove(index);
                    System.out.println(removed.getName() + " has been removed");
                    remove = false;
                }else {
                    System.out.println("Wow bro what item are you talking about ?");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Input Must be a NUMBER.");
            }
        }

    }
    public void useItem(){
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }
        boolean using = true;
        while (using){
            System.out.println("Which item you want to use ? ( 0 to cancel ) : ");
            String temp = sc.nextLine().trim();
            int use = Integer.parseInt(temp) - 1;
            try {
                if(use < 0){
                    using = false;
                }else if (use >= 0 && use < inventory.size()){
                    Items item = inventory.get(use);
                    item.use(this);
                    inventory.remove(use);
                }else {
                    System.out.println("Huh such items does not exist.");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Input must be a NUMBER");
            }

        }

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
    public void tryUseSkill(Enemy enemy) {
        if (skillCooldown == 0) {
            useSkill(enemy);
            skillCooldown = skillCooldownDuration;
        } else {
            System.out.println("Skill is on cooldown for " + skillCooldown + " more turn(s).");
        }
    }
    //for update cd
    public void updateSkillCooldown() {
        if (skillCooldown > 0) {
            skillCooldown--;
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


abstract class Items{
    protected String name;
    protected String desc;

    public Items(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName(){return name;}
    public String getDesc(){return desc;}

    public abstract void use(Role player);
}

class HealthPotion extends Items{
    private int healAmount;

    public HealthPotion(){
        super("Health Potion", "Restores 10 HP");
        this.healAmount = 10;
    }
    @Override
    public void use(Role player) {
        player.setHp(Math.min(player.getHp() + healAmount,20));
        System.out.println("Health Restored : +" + healAmount );
    }
}

class AttackElixir extends Items{

    public AttackElixir(){
        super("Attack Elixir", "+3 Attack");
    }
    public void use(Role player){
        Random rng = new Random();
        int attPlus = rng.nextInt(3) + 1;
        player.setAtt(Math.min(player.getAtt() + attPlus , 10 ));
        player.changesAttDuration = player.changesAttDuration + 2;
    }
}

class RandomCube extends Items{
    private int mysteryEfffect;

    public RandomCube(){
        super("Random Cube", "Whats in it? Spin the fate!");
        this.mysteryEfffect = 3;
    }

    @Override
    public void use(Role player) {
        System.out.println("You Throw Da Cube.....");
        Random rng = new Random();
        int effect = rng.nextInt(6) + 1;
        if(effect == 0){
            player.setHp(Math.min(player.getHp() + mysteryEfffect,20));
            System.out.println("Congrats your healed +" + mysteryEfffect);
            System.out.println("Your HP is now : " + player.getHp());
        } else if(effect == 1){
            player.setDefense(player.getDefense() + mysteryEfffect);
            player.changesDefDuration = 2;
            System.out.println("Up Up Up Defense +" + mysteryEfffect);
            System.out.println("Your Defense is now : " + player.getDefense());
        } else if(effect == 2) {
            player.setSpeed(player.getSpeed() + mysteryEfffect);
            player.changesSpeedDuration = 2;
            System.out.println("Up Up Up Speed +" + mysteryEfffect);
            System.out.println("Your speed is now : " + player.getSpeed());
        } else if(effect == 3){
            player.setHp(Math.max(player.getHp() - mysteryEfffect,5 ));
            System.out.println("Ouchhh the cube exploded -" + mysteryEfffect);
            System.out.println("Your HP is now : " + player.getHp());
        } else {
            System.out.println("Huh? nothing happen");
        }
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
            pause();
        } else if(chance < 60){
            System.out.println("You found an Item!");
            Items itemFound = generateItems();
            System.out.println("Item Found: " + itemFound.getName());
            System.out.println("Description: " + itemFound.getDesc());

            while (true) {
                System.out.print("Do you want to keep it ? (Y/n) : ");
                String keep = sc.nextLine().trim();
                if(keep.equalsIgnoreCase("Y")){
                    player.addItem(itemFound);
                    break;
                }
                else if (keep.equalsIgnoreCase("n")){
                    System.out.println("You walked past it.");
                    break;
                } else {
                    System.out.println("Huh ? re type it again.");
                }
            }
            pause();
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
            pause();
        }else {
            System.out.println("You wander around and realize its and empty room. . . .");
            pause();
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
    public Items generateItems(){
        Random rng = new Random();
        int itemName = rng.nextInt(1,5);
        switch (itemName){
            case 1 : return new HealthPotion();
            case 2 : return new AttackElixir();
            case 4 : return new RandomCube();
            default: return new HealthPotion();
        }
    }
    public void pause(){
        System.out.println("Press Enter To Continue");
        sc.nextLine();
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
                player.tryUseSkill(enemy);
            } else if (input.equals("3")){
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
            if(choice <= 10){
                enemy.deBuff(player);
            } else {
                int enemyDamage = Math.max(enemy.getEnemyAtt() - player.getDefense(),1);
                player.setHp(player.getHp() - enemyDamage);
                System.out.println("Enemy dealt " + enemyDamage + " damage to you");
            }

            //update changes
            player.updateBuffStatus();
            player.updateSkillCooldown();
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
            String OPT = opt.toUpperCase();
            switch (OPT){
                case "A" :
                    explr.explore(player);
                    break;
                case "B" :
                    player.showInventory();
                    player.useItem();
                    break;
                case "C" :
                    exploring = exit();
                    break;
            }
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

///