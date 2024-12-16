package Adventureres;
import java.util.Arrays;

public abstract class Adventurer extends Entity {
  private String name;
  private int HP, maxHP, money;
  private String[] inv;

  public Adventurer(String name, int maxHP, int money){
    this.name = name;
    this.maxHP = maxHP;
    this.money = money;
  }




}
