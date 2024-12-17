package Entities;

import Map.Map;

public class Entity {

    int xcor = 0;
    int ycor = 0;

    double health = 0.0;

    double melee = 0;
    double defense = 0;
    double speed = 0;

    public Entity(int xcor, int ycor, double health, double defense, double melee, double speed) {
        this.xcor = xcor;
        this.ycor = ycor;
        this.health = health;
        this.defense = defense;
        this.melee = melee;
        this.speed = speed;
    }

    public double getHealth() {
        return(health);
    }

    public double getMelee() {
        return(melee);
    }

    public double getDefense() {
        return(defense);
    }

    public double getSpeed() {
        return(speed);
    }

    public void moveX(int step) {
        xcor += step;
    }

    public void moveY(int step) {
        ycor += step;
    }

    public int getX() {
        return (xcor);
    }

    public int getY() {
        return (ycor);
    }

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