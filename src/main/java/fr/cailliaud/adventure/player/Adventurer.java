package fr.cailliaud.adventure.player;

import fr.cailliaud.adventure.engine.Action;
import fr.cailliaud.adventure.map.AdventureMap;
import fr.cailliaud.adventure.map.Orientation;
import fr.cailliaud.adventure.map.domain.Position;
import fr.cailliaud.adventure.map.domain.area.Area;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Adventurer implements Playable{
    private String name;
    private Orientation orientation;
    private Position position;
    private AdventureMap map;

    @Override
    public void performAction(Action action) {
        switch(action){
            case GO_FORWARD:
                goForward();
                break;
            case TURN_LEFT:
                this.orientation = orientation.previous();
                break;
            case TURN_RIGHT:
                this.orientation= orientation.next();
                break;
            default:

        }
    }

    private void goForward() {
        Area currentArea = map.getArea(position);
        Position newPos = orientation.getTransform().apply(this.position);
        Area newArea = map.getArea(newPos);
        if(newArea != null &&  newArea.isReachable()){
            currentArea.leave();
            newArea.visit();
            this.position=newPos;
        }
    }
}
