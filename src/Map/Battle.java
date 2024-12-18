package Map;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Math;

import Entities.*;

public class Battle {

    static int option = 1;
    static boolean inBattle = false;

    static double playerStack = 0;
    static double enemyStack = 0;

    static String choice = "";

    static boolean isInOptions = false;

    static Entity player;
    static Entity enemy;

    static int turns = 0;      /////////////////// IMPLEMENT SUPER

    public Battle(Entity player, Entity enemy) {

        Battle.player = player;
        Battle.enemy = enemy;

        enemyStack = enemy.getSpeed();
    }

    public static void startBattle() {
        inBattle = true;
        printOptions();
    }

    public void encounter() {
        clear();
        System.out.println("You Have Encountered an Enemy. Press [space] to Begin the Battle.");
        keyDetection();
        
    }

    public static void fight() {
        clear();
        turns += 1;
        System.out.println();
        playerStack += player.getSpeed();
        enemyStack += enemy.getSpeed();
        if (enemyStack <= playerStack) {
            System.out.println("\u001B[96m" + "This is an Extra Turn due to Player's Higher Speed." + "\u001B[37m"); /////////////////////// ADD ENEMY EXTRA TURN MAYBE
        }
        if (choice.equals("melee")) {
            if ((Math.random() * 10) + 1 > 9) {
                System.out.println("\u001B[96m" + "You Have Landed a Critical Hit." + "\u001B[37m");
                enemy.changeHP(-1 * player.getAtkStandard() * (2 - enemy.getDefense() / 100));
                System.out.println("Enemy Takes " + (player.getAtkStandard() * (2 - enemy.getDefense() / 100)) + " Points of Damage");
            }
            else {
                enemy.changeHP(-1 * player.getAtkStandard() * (1 - enemy.getDefense() / 100));
                System.out.println("Enemy Takes " + (player.getAtkStandard() * (1 - enemy.getDefense() / 100)) + " Points of Damage");
            }
            // ADD ENEMY AI HERE IF TIME
            if (enemyStack > playerStack) {
                player.changeHP(-1 * enemy.getAtkStandard() * (1 - player.getDefense() / 100));
                System.out.println("Player Takes " + (enemy.getAtkStandard() * (1 - player.getDefense() / 100)) + " Points of Damage");
            }
            else {
                playerStack = 0;
                enemyStack = enemy.getSpeed();
            }
        }
        else if (choice.equals("guard")) {
            if (enemyStack > playerStack) {
                player.changeHP(-1 * enemy.getAtkStandard() * (1 - (player.getDefense() * 3) / 100));
                System.out.println("Player Takes " + (enemy.getAtkStandard() * (1 - (player.getDefense() * 3) / 100)) + " Points of Damage");
            }
            else {
                playerStack = 0;
                enemyStack = enemy.getSpeed();
            }
        }
        else if (choice.equals("run")) {
            if ((Math.random() * 10) + 1 + enemy.getSpeed() - player.getSpeed() >= 9) {
                System.out.println("You Have Successfully Ran Away"); /////////////////////////////////// IMPLEMENT
            }
            else {
                if (enemyStack > playerStack) {
                    player.changeHP(-1 * enemy.getAtkStandard() * (1 - player.getDefense() / 100));
                    System.out.println("Player Takes " + (enemy.getAtkStandard() * (1 - player.getDefense() / 100)) + " Points of Damage");
                }
                else {
                    playerStack = 0;
                    enemyStack = enemy.getSpeed();
                }
            }
        }
        System.out.println();
        System.out.println("Press [space] to continue.");
    }

    public static void endFight() {

    }

    public static void printOptions() {
        if (enemy.getHP() <= 0) {
            
        }
        if (player.getHP() <= 0) {     ////////////////////////////////////////////////////// IMPLEMENT WITH RUN AWAY. ADD LOOT HERE THO MB

        }
        clear();
        System.out.println(player.getHP());
        isInOptions = true;
        System.out.println();
        System.out.println("Player Health:                                           Enemy Health:");
        System.out.println("      " + player.getHP() + "                                                   " + enemy.getHP());
        System.out.println();
        System.out.println("                      What Will you do:");
        System.out.println();
        if (option == 1) {
            System.out.print("\u001B[33m" + "          Melee          " + "\u001B[37m");
            System.out.println("\u001B[34m" + "                   Inventory          " + "\u001B[37m");
            System.out.print("\u001B[34m" + "          Guard             " + "\u001B[37m");
            System.out.println("\u001B[34m" + "                Run          " + "\u001B[37m");
        }
        else if (option == 2) {
            System.out.print("\u001B[34m" + "          Melee          " + "\u001B[37m");
            System.out.println("\u001B[33m" + "                   Inventory          " + "\u001B[37m");
            System.out.print("\u001B[34m" + "          Guard             " + "\u001B[37m");
            System.out.println("\u001B[34m" + "                Run          " + "\u001B[37m");
        }
        else if (option == 3) {
            System.out.print("\u001B[34m" + "          Melee          " + "\u001B[37m");
            System.out.println("\u001B[34m" + "                   Inventory          " + "\u001B[37m");
            System.out.print("\u001B[33m" + "          Guard             " + "\u001B[37m");
            System.out.println("\u001B[34m" + "                Run          " + "\u001B[37m");
        }
        else if (option == 4) {
            System.out.print("\u001B[34m" + "          Melee          " + "\u001B[37m");
            System.out.println("\u001B[34m" + "                   Inventory          " + "\u001B[37m");
            System.out.print("\u001B[34m" + "          Guard             " + "\u001B[37m");
            System.out.println("\u001B[33m" + "                Run          " + "\u001B[37m");
        }

    }
    
    public static void select() {
        if (option == 1) {
            choice = "melee";
        }
        else if (option == 2) {
            /////////////////////////// OPEN INVENTORY
        }
        else if (option == 3) {
            choice = "guard";
        }
        else if (option == 4) {
            choice = "run";
        }
        if (isInOptions == true) {
            fight();
            isInOptions = false;
        }
        else {
            printOptions();
        }
    }

    public static void keyDetection() {
        JFrame frame = new JFrame("");
        frame.setSize(20, 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add KeyListener for input
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    if (inBattle == false) {
                        switch (e.getKeyChar()) {
                            case ' ':
                                startBattle();
                                break;
                        }
                    }
                    else {
                        switch (e.getKeyChar()) {
                            case 'd':
                                if (option + 1 <= 4) {
                                    option += 1;
                                    printOptions();
                                }
                                break;
                            case 'a':
                                if (option - 1 >= 1) {
                                    option -= 1;
                                    printOptions();
                                }
                                break;
                            case 's':
                                if (option + 2 <= 4) {
                                    option += 2;
                                    printOptions();
                                }
                                break;
                            case 'w':
                                if (option - 2 >= 1) {
                                    option -= 2;
                                    printOptions();
                                }
                                break;
                            case ' ':
                                select();
                                break;
                        }
                    }
                } 
                catch (Exception ex) {
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

    public static void clear() {
        try {
          if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
          } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
}
