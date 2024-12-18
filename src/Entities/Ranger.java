package Entities;

public class Ranger extends Adventurer{

    public Ranger(String Name){
        super(Name, 80, 150, 10, 10, 8);
        setSpecial(0);
        setSpecialMax(3);
        setSpecialName("Air Support");
    }
    

    public void doSpecial(Entity Enemy) {
        setSpecial(0);
        for (int i = 0; i < 4; i++) {
            this.spAttack(Enemy);
        }
    }

    public void spAttack(Entity other) {
        int roll = Dice.advantage20() * 2;
        System.out.print(this.getName() + " rolled a " + roll);
        if (roll < 3) {
            System.out.print(" and misses.");
        } 
        else if (roll <= 19){
            double dmg = (roll / 10) * this.getAtkStandard() * (1 - other.getDefense() / 100);
            System.out.print(" And hits for " + dmg + " damage.");
            other.applyDamage((int) dmg);
        }
        else{
            double dmg = 3 * this.getAtkStandard() * ( 1 - other.getDefense() / 100) * 3;
            System.out.println(" dealing a critical hit for " + dmg + " damage.");
            other.applyDamage((int) dmg);
        }
    }
}
