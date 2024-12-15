
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Driver {
    public static void main(String[] args) {

        

        MainMenu start = new MainMenu();
        start.displayMenu();

        keyDetection(null, null, start, true);

        //clear();
        //room.displayMap();

        //MoveTest player = new MoveTest(2, 2);

        //room.spawnEntity(2, 2, 2, "O");

        //keyDetection(room, player);

    }

    public static void startGame(MainMenu start) {
        Map room = new Room1(16,20);
        room.setBrackets(start.getvisibleBrackets());
        room.displayMap();
        MoveTest player = new MoveTest(2, 2);
        room.spawnEntity(2, 2, 2, "O");
        if (start.getinputDetection() == true) {
            keyDetection(room, player, start, false);
        }
        else {
            ///////////////////////////////////////////////////////////////  ADD NO KEY DETECTION CODE HERE
        }
    }

    public static void keyDetection(Map room, MoveTest player, MainMenu start, boolean inMenu) {
        JFrame frame = new JFrame("WASD Game");
        frame.setSize(20, 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add KeyListener for input
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (inMenu == false) {
                    switch (e.getKeyChar()) {
                        case 'w': room.moveEntity(1, 1, player.getX(), player.getY()); player.moveY(-1); break;
                        case 'a': room.moveEntity(4, 1, player.getX(), player.getY()); player.moveX(-1); break;
                        case 's': room.moveEntity(3, 1, player.getX(), player.getY()); player.moveY(1); break;
                        case 'd': room.moveEntity(2, 1, player.getX(), player.getY()); player.moveX(1); break;
                    }
                }
                else {
                    switch (e.getKeyChar()) {
                        case 'w': start.step(-1); start.displayMenu(); break;
                        case 's': start.step(1); start.displayMenu(); break;
                        case 'p': start.select(); start.displayMenu(); if(start.getOption() == 0) {frame.removeKeyListener(this); frame.dispose(); startGame(start);} break;
                        //frame.removeKeyListener(this);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
            @Override
            public void keyTyped(KeyEvent e) { }
        });

        frame.setVisible(true);
    }
    
}
