public class Entity {

    int xcor = 0;
    int ycor = 0;

    public Entity(int xcor, int ycor) {
        this.xcor = xcor; 
        this.ycor = ycor; 
    }

    public void moveX(int step) {
        xcor += step;
    }

    public void moveY(int step) {
        ycor += step;
    }

    public int getX() {
        return(xcor);
    }
    public int getY() {
        return(ycor);
    }
  public boolean canMoveCheck(int facing, int amountMoved, Map map){
    if( facing == 1 && 0 <= ycor - amountMoved ) return true;
    else if( facing == 2 && map.sizex >= xcor + amountMoved ) return true;
    else if( facing == 3 && map.sizey >= ycor + amountMoved ) return true;
    else if( 0 <= xcor - amountMoved ) return true;
    return false;
  }
}
