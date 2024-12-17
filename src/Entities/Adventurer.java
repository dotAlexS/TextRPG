package Entities;

public abstract class Adventurer extends Entity {
  private String[] inv = new String[5];

  public Adventurer(String name, int maxHP, int money) {
    super(name, maxHP, money);
  }

  public int restoreSpecial(int n){
    if( n > getSpecialMax() - getSpecial()){
            n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial()+n);
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

}
