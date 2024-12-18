
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import Entities.*;
import Map.*;

public class Driver {
    public static void main(String[] args) {

        MainMenu start = new MainMenu();
        start.displayMenu();

        keyDetection(null, null, start, true);

    }

    public static void startGame(MainMenu start) {
        Adventurer player = new Defender("Mother");
        Map room = new StartRoom(20, 20, player);
        room.setBrackets(start.getvisibleBrackets());
        room.displayMap();

        if (start.getinputDetection() == true) {
            Battle fight = new Battle(player, enemy); //////////////////////// BATTLE TEST
            fight.encounter();
            //keyDetection(room, player, start, false);
        } else {
            while (true) {
                Scanner myObj = new Scanner(System.in);
                String option = myObj.nextLine(); 

                // code breaks when moving out of bounds

                if (option.equals("w")) {
                    if (player.canMoveCheck(1, 1, room)) {
                        room.moveEntity(1, 1, player.getX(), player.getY());
                        player.moveY(-1);
                        continue;
                    }
                } else if (option.equals("a")) {
                    if (player.canMoveCheck(4, 1, room)) {
                        room.moveEntity(4, 1, player.getX(), player.getY());
                        player.moveX(-1);
                        continue;
                    }
                } else if (option.equals("s")) {
                    if (player.canMoveCheck(3, 1, room)) {
                        room.moveEntity(3, 1, player.getX(), player.getY());
                        player.moveY(1);
                        continue;
                    }
                } else if (option.equals("d")) {
                    if (player.canMoveCheck(2, 1, room)) {
                        room.moveEntity(2, 1, player.getX(), player.getY());
                        player.moveX(1);
                        continue;
                    }
                } else if (option.equals("p")) {
                    start.setOption(1);
                    start.displayMenu();
                    keyDetection(null, null, start, true);
                } else {
                    System.out.println("Wrong Input. Try Again.");
                    continue;
                }
            }
        }
    }

    public static void keyDetection(Map room, Entity player, MainMenu start, boolean inMenu) {
        JFrame frame = new JFrame("");
        frame.setSize(1, 1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add KeyListener for input
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    if (inMenu == false) {
                        switch (e.getKeyChar()) {
                            case 'w':
                                if (player.canMoveCheck(1, 1, room)) {
                                    room.moveEntity(1, 1, player.getX(), player.getY());
                                    player.moveY(-1);
                                    break;
                                } else
                                    break;
                            case 'a':
                                if (player.canMoveCheck(4, 1, room)) {
                                    room.moveEntity(4, 1, player.getX(), player.getY());
                                    player.moveX(-1);
                                    break;
                                } else
                                    break;
                            case 's':
                                if (player.canMoveCheck(3, 1, room)) {
                                    room.moveEntity(3, 1, player.getX(), player.getY());
                                    player.moveY(1);
                                    break;
                                } else
                                    break;
                            case 'd':
                                if (player.canMoveCheck(2, 1, room)) {
                                    room.moveEntity(2, 1, player.getX(), player.getY());
                                    player.moveX(1);
                                    break;
                                } else
                                    break;
                            case 'p':
                                start.setOption(1);
                                start.displayMenu();
                                keyDetection(null, null, start, true);
                                frame.removeKeyListener(this);
                                frame.dispose();
                                break;
                        }
                    } else {
                        switch (e.getKeyChar()) {
                            case 'w':
                                start.step(-1);
                                start.displayMenu();
                                break;
                            case 's':
                                start.step(1);
                                start.displayMenu();
                                break;
                            case ' ':
                                start.select();
                                start.displayMenu();
                                if (start.getOption() == 0) {
                                    frame.removeKeyListener(this);
                                    frame.dispose();
                                    startGame(start);
                                }
                                break;
                            // frame.removeKeyListener(this);
                        }
                    }
                } catch (Exception ex) {
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        frame.setVisible(true);
    }

}
