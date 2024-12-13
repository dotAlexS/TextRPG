public abstract class Map {
  
  int sizex; // IN ARRAY TERMS (-1 compared to regular size)
  int sizey;

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
  }

  public void moveEntity(int facing, int amountMoved, int x, int y) {
    if (facing == 1) {
      if (y - amountMoved >= 0) {
        map[y - amountMoved][x] = map[y][x];
        map[y][x] = " ";
      }
    }
    if (facing == 2) {
      if (x + amountMoved <= sizex) {
        map[y][x + amountMoved] = map[y][x];
        map[y][x] = " ";
      }
    }
    if (facing == 3) {
      if (y + amountMoved <= sizey) {
        map[y + amountMoved][x] = map[y][x];
        map[y][x] = " ";
      }
    }
    if (facing == 4) {
      if (x - amountMoved >= 0) {
        map[y][x - amountMoved] = map[y][x];
        map[y][x] = " ";
      }
    }
  }

  public void displayMap() {
    clear();
    for (int i = 0; i < map.length; i++) {
      System.out.println(Arrays.toString(map[i]));
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
