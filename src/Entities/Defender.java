package Entities;

public class Defender extends Adventurer {

    private int special, specialMax, invincible;
    private String specialName;

    public Defender(String name) {
        super(name, 100, 150, 6, 30, 4);
        special = 0;
        specialMax = 5;
        specialName = "Super Immunity";
    }


    public void doSpecial() {
        special = 0;
        invincible = 10;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public int getSpecialMax() {
        return specialMax;
    }

    public void setSpecialMax(int specialMax) {
        this.specialMax = specialMax;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    @Override
    public void applyDamage(int damage) {
        if (invincible != 0)
            invincible--;
        else
            super.applyDamage(damage);
    }

}