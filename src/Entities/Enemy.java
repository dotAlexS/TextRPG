package Entities;

public abstract class Enemy extends Entity{


    public Enemy(String name, int maxHP, int money, int atkStandard, int defense, int speed){
        super(name, maxHP, money, atkStandard, defense, speed);
    }

    public void attack(Entity other){
        int roll = Dice.d20();
        System.out.println( this.getName() + " rolled a "+ roll);
        if (roll < 4){
            System.out.println(" and misses.");
        }
        else if (roll <= 19){
            int dmg = (roll / 10) * this.getAtkStandard();
            System.out.println(" And hits for " + dmg + " damage.");
            other.setHP(other.getHP() - dmg);
        }
        else{
            int dmg = 3 * this.getAtkStandard();
            System.out.println(" dealing a critical hit for " + dmg + " damage.");
            other.setHP(other.getHP() - dmg);
        }
    }
}