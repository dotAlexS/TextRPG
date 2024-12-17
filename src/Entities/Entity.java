package Entities;

import Map.Map;

public abstract class Entity {

    private String name;
    private int HP, maxHP, money;
    public int xcor = 0;
    public int ycor = 0;

    public Entity(String name, int maxHP, int money) {
        this.name = name;
        this.maxHP = maxHP;
        this.money = money;
    }
    public abstract int attack();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int hP) {
        HP = hP;
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