package Map;

import Entities.*;

public class StartRoom extends Map {
    public StartRoom(int sizex, int sizey, Adventurer adventurer) {
        super(sizex,sizey, adventurer);
        loadMap();
    }

    @Override
    public void loadMap() {
        // spawns in required entities & shops
        super.spawnEntity(2, 2, 2, "O", P);
    }
}