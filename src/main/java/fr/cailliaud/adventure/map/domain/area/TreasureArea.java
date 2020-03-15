package fr.cailliaud.adventure.map.domain.area;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreasureArea extends ClassicalArea {

    private int treasureNumber;

    public TreasureArea(int treasureNumber) {
        super();
        if(treasureNumber<=0){
            throw new IllegalArgumentException("Treasure Area should have at least one treasure.");
        }
        this.treasureNumber=treasureNumber;
    }

    @Override
    public void visit() {
        super.visit();
        if(treasureNumber >0){
            this.treasureNumber--;
        }

    }
}
