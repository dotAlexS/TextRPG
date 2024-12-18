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

    public static boolean wonFight = false;
    public static boolean ranAway = false;

    public static boolean canSpecial = false;
    static int special = 0;

    static Adventurer player;
    static Entity enemy;

    static int turns = 0;      /////////////////// IMPLEMENT SUPER

    public Battle(Adventurer player, Entity enemy) {

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
        
        player.restoreSpecial(1);

        System.out.println();
        playerStack += player.getSpeed();
        enemyStack += enemy.getSpeed();
        if (enemyStack <= playerStack) {
            System.out.println("\u001B[96m" + "This is an Extra Turn due to Player's Higher Speed." + "\u001B[37m"); 
        }
        if (choice.equals("melee")) {
            player.attack(enemy);
            if (enemyStack > playerStack) {
                enemy.attack(player);
            }
            else {
                playerStack = 0;
                enemyStack = enemy.getSpeed();
            }
        }
        else if (choice.equals("guard")) {
            if (enemyStack > playerStack) {
                player.setDefense(player.getDefense() * 3);
                enemy.attack(player);
                player.setSpecial(player.getSpecial() + 1);
                player.setDefense(player.getDefense() / 3);
            }
            else {
                playerStack = 0;
                enemyStack = enemy.getSpeed();
            }
        }
        else if (choice.equals("run")) {
            if ((Math.random() * 10) + 1 + enemy.getSpeed() - player.getSpeed() >= 9) {
                System.out.println("You Have Successfully Ran Away."); 
                ranAway = true;
            }
            else {
                if (enemyStack > playerStack) {
                    enemy.attack(player);
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

    public static void printOptions() {
        if (enemy.getHP() <= 0) {
            wonFight = true;
        }
        if (player.getHP() <= 0) { 
            clear();
            System.out.println("You have lost.");
            System.exit(0);
        }
        if (wonFight == false && ranAway == false) {
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

            if (player.getSpecial() >= player.getSpecialMax()) {
                System.out.println("You May Use Your Special Move [v]: " + player.getSpecialName());
                canSpecial = true;
                
            }
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
                    if (wonFight) {
                        player.setFight(false);
                        player.setMoney(player.getMoney() + enemy.getMoney());
                        System.out.println("You Have Won the Fight!");
                        System.out.println("Obtained " + enemy.getMoney() + " Gold");
                        switch (e.getKeyChar()) {
                            case ' ':
                                frame.removeKeyListener(this);
                                frame.dispose();
                                break;
                        }
                    }
                    else if (ranAway == true) {
                        player.setFight(false);
                        switch (e.getKeyChar()) {
                            case ' ':
                                frame.removeKeyListener(this);
                                frame.dispose();
                                break;
                        }
                    }
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
                            case 'v':
                                if (canSpecial) {
                                    player.doSpecial(enemy); //////////////////////////////////////////////////////////////////////////////////////  HERE
                                }
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
