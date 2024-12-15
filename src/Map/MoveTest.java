public class MoveTest {

    int xcor = 0;
    int ycor = 0;

    public MoveTest(int xcor, int ycor) {
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
}
