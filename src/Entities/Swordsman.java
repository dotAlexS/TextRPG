package Entities;

public class Swordsman extends Adventurer {

    public Swordsman(String Name) {
        super(Name, 100, 50, 10, 14, 12);
        setSpecial(0);
        setSpecialMax(2);
        setSpecialName("Fury Slashes");
    }

    public void doSpecial(Entity Enemy) {
        setSpecial(0);
        for (int i = 0; i < 4; i++) {
            this.spAttack(Enemy);
        }
    }

    public void spAttack(Entity other) {
        int roll = Dice.advantage20();
        System.out.print(this.getName() + " rolled a " + roll);
        if (roll < 3) {
            System.out.print(" and misses.");
        } else if (roll <= 19) {
            double dmg = (roll / 10) * this.getAtkStandard();
            System.out.print(" And hits for " + dmg + " damage.");
            other.applyDamage((int) dmg);
        } else {
            int dmg = 3 * this.getAtkStandard();
            System.out.println(" dealing a critical hit for " + dmg + " damage.");
            other.applyDamage(dmg);
        }
    }


}