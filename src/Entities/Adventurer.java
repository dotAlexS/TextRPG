package Entities;

public abstract class Adventurer extends Entity {
  private String[] inv = new String[10];

  //test

  public Adventurer(String name, int maxHP, int money, int atkStandard, int defense, int speed) {
    super(name, maxHP, money, atkStandard, defense, speed);
  }

  public int restoreSpecial(int n) {
    if (n > getSpecialMax() - getSpecial()) {
      n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial() + n);
    return n;
  }

  public abstract String getSpecialName();

  public abstract int getSpecial();

  public abstract void setSpecial(int n);

  public abstract int getSpecialMax();

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

  public void trashItem(int itemIndex){
    for (int i = itemIndex; i < inv.length-1; i++){
      inv[i] = inv[i+1];
    }
  }

}