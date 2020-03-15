package fr.cailliaud.adventure.reader;

import fr.cailliaud.adventure.map.domain.Position;
import fr.cailliaud.adventure.map.domain.area.Area;
import fr.cailliaud.adventure.player.Adventurer;

import java.util.Map;

public interface GameInitParams {

    Adventurer getAdventurer();
    int getMapLength();
    int getMapWidth();
    Map<Position, Area> getAreas();

}
