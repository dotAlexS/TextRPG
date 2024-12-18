package Entities;

public class Defender extends Adventurer {

    private int invincible;

    public Defender(String name) {
        super(name, 150, 150, 6, 30, 4);
        setSpecial(0);
        setSpecialMax(5);
        setSpecialName("Invincibility");
    }


    public void doSpecial() {
        setSpecial(0);
        invincible = 3;
    }

    @Override
    public void applyDamage(int damage) {
        if (invincible != 0)
            invincible--;
        else
            super.applyDamage(damage);
    }

}