package Entities;

public class Defender extends Adventurer {

    private int special, specialMax;
    private String specialName;

    public Defender(String name){
        super(name, 100, 150, 6, 30, 10);
        special = 0;
        specialMax = 15;
        specialName = "Super Immunity";
    }
    public int attack(){
        return 0;
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

}