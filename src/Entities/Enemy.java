package Entities;

public class Enemy extends Entity{

    private int atkStandard;

    public Enemy(String name, int maxHP, int money, int atkStandard){
        super(name, maxHP, money);
        this.atkStandard = atkStandard;
    }

    public int attack(){
        int roll = Dice.d20();
        System.out.println("Enemy rolled a "+ roll);
        if (roll < 4){
            System.out.println(" and misses.");
            return 0;
        }
        else if (roll <= 19){
            int dmg = (roll / 10) * atkStandard;
            System.out.println(" And hits for " + dmg + " damage.");
            return dmg;
        }
        else{
            int dmg = 3 * atkStandard;
            System.out.println(" dealing a critical hit for " + dmg + " damage.");
            return dmg;
        }
    }
}
