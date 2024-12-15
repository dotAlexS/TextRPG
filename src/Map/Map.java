import java.util.Arrays;

public abstract class Map {
  
  int sizex; // IN ARRAY TERMS (-1 compared to regular size)
  int sizey;

  boolean visibleBrackets = true;

  String[][] map;

  public Map(int sizex, int sizey) {
    map = new String[sizey][sizex];
    this.sizex = sizex - 1;
    this.sizey = sizey - 1;
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = " ";
      }
    }
  }

  public void setBrackets(boolean boo) {
    visibleBrackets = boo;
  }

  public void spawnEntity(int x, int y, int facing, String entity) {
    // facing 1 is up
    // facing 2 is right
    // facing 3 is down
    // facing 4 is left

    // ENEMY IS ARROWS FOR entity
    // PLAYER IS O

    if (facing == 1) {
      map[y][x] = entity; //change if terminal doesnt print properly
    }
    if (facing == 2) {
      map[y][x] = entity;
    }
    if (facing == 3) {
      map[y][x] = entity;
    }
    if (facing == 4) {
      map[y][x] = entity;
    }
    displayMap();
  }

  public void moveEntity(int facing, int amountMoved, int x, int y) {
    if (facing == 1 && y - amountMoved >= 0) {
        map[y - amountMoved][x] = map[y][x];
        map[y][x] = " ";
    }
    else if (facing == 2 && x + amountMoved <= sizex) {
        map[y][x + amountMoved] = map[y][x];
        map[y][x] = " ";
    }
    else if (facing == 3 && y + amountMoved <= sizey) {   // FIX THE BOUNDERIES
        map[y + amountMoved][x] = map[y][x];
        map[y][x] = " ";
      }
    else if (facing == 4 && x - amountMoved >= 0) {
        map[y][x - amountMoved] = map[y][x];
        map[y][x] = " ";
      }
    displayMap();
  }


  public void displayMap() {
    clear();
    System.out.print(" ");
    for (int i = 0; i < sizex + 1; i++) {
      System.out.print("___");
    }
    System.out.println();
    for (int i = 0; i < map.length; i++) {
      System.out.print("|");
      for (int j = 0; j < map[i].length; j++) {
        if (visibleBrackets == true) {
          System.out.print("[" + map[i][j] + "]");
        }
        else {
          if (map[i][j] == " ") {
            System.out.print("   ");
          }
          else {
            System.out.print(" " + map[i][j]+ " ");
          }
        }
      }
      System.out.println("|");
    }
    System.out.print(" ");
    for (int i = 0; i < sizex + 1; i++) {
      System.out.print("___");
    }
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
