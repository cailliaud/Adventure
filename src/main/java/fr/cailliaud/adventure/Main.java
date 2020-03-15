package fr.cailliaud.adventure;

import fr.cailliaud.adventure.engine.Action;
import fr.cailliaud.adventure.map.AdventureMap;
import fr.cailliaud.adventure.map.Orientation;
import fr.cailliaud.adventure.map.domain.Position;
import fr.cailliaud.adventure.map.domain.area.Area;
import fr.cailliaud.adventure.map.domain.area.TreasureArea;
import fr.cailliaud.adventure.map.domain.area.UnreachableArea;
import fr.cailliaud.adventure.player.Adventurer;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {

    public static void main(String[] args){

        Map<Position, Area> areas= new HashMap<>();
        areas.put(new Position(1,0), new UnreachableArea());
        areas.put(new Position(2,1), new UnreachableArea());
        areas.put(new Position(0,3), new TreasureArea(2));
        areas.put(new Position(1,3), new TreasureArea(3));

        AdventureMap map = new AdventureMap.Builder()
                .withLength(3)
                .withWidth(4)
                .withAreas(areas)
                .build();

        Adventurer player = new Adventurer(
                "Lara",
                Orientation.SOUTH,
                new Position(1,1),
                map
        );

        List<Action> actions = Arrays.asList(
                Action.GO_FORWARD,
                Action.GO_FORWARD,
                Action.TURN_RIGHT,
                Action.GO_FORWARD,
                Action.TURN_RIGHT,
                Action.GO_FORWARD,
                Action.TURN_LEFT,
                Action.TURN_LEFT,
                Action.GO_FORWARD
        );

        actions.stream().forEach(act -> {
            player.performAction(act);
            log.info(player.getOrientation().name());
            log.info(player.getPosition().toString());
        });


        map.displayMap( );

        log.info(player.getOrientation()+ " Pos : "+player.getPosition());
    }
}
