package Entities;

import Map.Map;

public abstract class Entity {

    private String name;
    private int HP, maxHP, money, speed, defense, atkStandard;
    
    public int xcor = 0;
    public int ycor = 0;

    private boolean inFight = false;
    
    public Entity(String name, int maxHP, int money, int atkStandard, int defense, int speed) {
        this.name = name;
        this.maxHP = maxHP;
        this.HP = maxHP;
        this.money = money;
        this.atkStandard = atkStandard;
        this.defense = defense;
        this.speed = speed;
    }
    public abstract void attack(Entity other);
    
    public void setpos(int xcor, int ycor) {
        this.xcor = xcor;
        this.ycor = ycor;
    }
    
    public void moveX(int step) {
        xcor += step;
    }
    
    public void moveY(int step) {
        ycor += step;
    }
    //getters and setters
    public int getX() {
        return (xcor);
    }
    
    public int getY() {
        return (ycor);
    }
    
    public boolean isInFight() {
        return(inFight);
    }

    public void setFight(boolean set) {
        inFight = set;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public int getHP() {
        return HP;
    }
    
    public void setHP(int hP) {
        HP = hP;
    }

    public void changeHP(double amount) {
        HP += amount;
    }
    
    public int getMaxHP() {
        return maxHP;
    }
    
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void setMoney(int money) {
        this.money = money;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getAtkStandard() {
        return atkStandard;
    }
    public void setAtkStandard(int atkStandard) {
        this.atkStandard = atkStandard;
    }
    public void applyDamage(int damage){
        this.HP -= damage;
    }
    // end getters and setters
    
    public boolean canMoveCheck(int facing, int amountMoved, Map map) {
        if (facing == 1 && 0 <= ycor - amountMoved)
        return true;
        else if (facing == 2 && map.sizex >= xcor + amountMoved)
        return true;
        else if (facing == 3 && map.sizey >= ycor + amountMoved)
        return true;
        else if (0 <= xcor - amountMoved)
        return true;
        return false;
    }
}