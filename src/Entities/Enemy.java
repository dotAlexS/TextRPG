package Entities;

public abstract class Enemy extends Entity{


    public Enemy(String name, int maxHP, int money, int atkStandard, int defense, int speed){
        super(name, maxHP, money, atkStandard, defense, speed);
    }

    public int attack(){
        int roll = Dice.d20();
        System.out.println( this.getName() + " rolled a "+ roll);
        if (roll < 4){
            System.out.println(" and misses.");
            return 0;
        }
        else if (roll <= 19){
            int dmg = (roll / 10) * this.getAtkStandard();
            System.out.println(" And hits for " + dmg + " damage.");
            return dmg;
        }
        else{
            int dmg = 3 * this.getAtkStandard();
            System.out.println(" dealing a critical hit for " + dmg + " damage.");
            return dmg;
        }
    }
}