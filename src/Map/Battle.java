package Map;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Math;

import Entities.Dice;

public class Battle {

    static int option = 1;
    static boolean inBattle = false;

    static double playerHealth = 0;
    static double enemyHealth = 0;

    static double playerMelee = 0;
    static double enemyMelee = 0;

    static double playerSpeed = 0;
    static double enemySpeed = 0;

    static double playerDefense = 0;
    static double enemyDefense = 0;

    static double playerStack = 0;
    static double enemyStack = 0;

    static String choice = "";

    static boolean isInOptions = false;

    static int turns = 0;      /////////////////// IMPLEMENT SUPER

    public Battle(Entity player, Entity enemy) {
        playerHealth = player.getHP();
        playerSpeed = player.getSpeed();
        playerMelee = player.getAtkStandard();
        playerDefense = player.getDefense();
        
        enemyHealth = enemy.getHP();
        enemySpeed = enemy.getSpeed();
        enemyMelee = enemy.getAtkStandard();
        enemyDefense = enemy.getDefense();

        enemyStack = enemySpeed;
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
        playerStack += playerSpeed;
        enemyStack += enemySpeed;
        if (enemyStack <= playerStack) {
            System.out.println("\u001B[96m" + "This is an Extra Turn due to Player's Higher Speed." + "\u001B[37m"); /////////////////////// ADD ENEMY EXTRA TURN MAYBE
        }
        if (choice.equals("melee")) {
            if ((Math.random() * 10) + 1 > 9) {
                System.out.println("\u001B[96m" + "You Have Landed a Critical Hit." + "\u001B[37m");
                System.out.println("Enemy Takes " + (enemyHealth - (enemyHealth -= playerMelee * (2 - enemyDefense / 100))) + " Points of Damage");
            }
            else {
                System.out.println("Enemy Takes " + (enemyHealth - (enemyHealth -= playerMelee * (1 - enemyDefense / 100))) + " Points of Damage");
            }
            // ADD ENEMY AI HERE IF TIME
            if (enemyStack > playerStack) {
                System.out.println("Player Takes " + (playerHealth - (playerHealth -= enemyMelee * (1 - playerDefense / 100))) + " Points of Damage");
            }
            else {
                playerStack = 0;
                enemyStack = enemySpeed;
            }
        }
        else if (choice.equals("guard")) {
            if (enemyStack > playerStack) {
                System.out.println("Player Takes " + (playerHealth - (playerHealth -= enemyMelee * (1 - (playerDefense * 3) / 100))) + " Points of Damage");
            }
            else {
                playerStack = 0;
                enemyStack = enemySpeed;
            }
        }
        else if (choice.equals("run")) {
            if ((Math.random() * 10) + 1 + enemySpeed - playerSpeed >= 9) {
                System.out.println("You Have Successfully Ran Away"); /////////////////////////////////// IMPLEMENT
            }
            else {
                if (enemyStack > playerStack) {
                    System.out.println("Player Takes " + (playerHealth - (playerHealth -= enemyMelee * (1 - playerDefense / 100))) + " Points of Damage");
                }
                else {
                    playerStack = 0;
                    enemyStack = enemySpeed;
                }
            }
        }
        System.out.println();
        System.out.println("Press [space] to continue.");
    }

    public static void endFight() {

    }

    public static void printOptions() {
        if (enemyHealth <= 0) {
            
        }
        if (playerHealth <= 0) {     ////////////////////////////////////////////////////// IMPLEMENT WITH RUN AWAY. ADD LOOT HERE THO MB

        }
        clear();
        isInOptions = true;
        System.out.println();
        System.out.println("Player Health:                                           Enemy Health:");
        System.out.println("      " + playerHealth + "                                                   " + enemyHealth);
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
