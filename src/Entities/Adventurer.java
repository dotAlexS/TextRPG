package Entities;

public abstract class Adventurer extends Entity {
  private String[] inv = new String[10];

  private int special, specialMax;
  private String specialName;

  // test
  public Adventurer(String name, int maxHP, int money, int atkStandard, int defense, int speed) {
    super(name, maxHP, money, atkStandard, defense, speed);
  }

  public void restoreSpecial(int n) {
    if (n > getSpecialMax() - getSpecial()) {
      n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial() + n);
  }

  public void attack(Entity other) {
    restoreSpecial(1);
    int roll = Dice.d20();
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

  public String[] getInv() {
    return inv;
  }

  public void setInv(String[] inv) {
    this.inv = inv;
  }

  public void collect(String item) {
    for (int i = 0; i < inv.length; i++) {
      if (i == inv.length - 1) {
        System.out.println("Not enough inventory space.");
      }
      if (inv[i] == null)
        inv[i] = item;
    }
  }

  public void trashItem(int itemIndex) {
    for (int i = itemIndex; i < inv.length - 1; i++) {
      inv[i] = inv[i + 1];
    }
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