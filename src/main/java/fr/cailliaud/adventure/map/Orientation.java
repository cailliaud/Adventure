package fr.cailliaud.adventure.map;

import fr.cailliaud.adventure.map.domain.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@AllArgsConstructor
@Getter
public enum Orientation {
    NORTH("N", p -> new Position(p.getX(),p.getY()-1)),
    EAST("E", p -> new Position(p.getX()+1,p.getY())),
    SOUTH("S",p -> new Position(p.getX(),p.getY()+1)),
    WEST("W",p -> new Position(p.getX()-1,p.getY()));

    private String key;
    private Function<Position,Position> transform;

    public Orientation next(){
        int index = this.ordinal();
        Orientation[] orientations = Orientation.values();
        int nextIndex = (index + 1) % orientations.length;
        return orientations[nextIndex];

    }

    public Orientation previous(){
        int index = this.ordinal();
        Orientation[] orientations = Orientation.values();
        int previousIndex = (index + orientations.length-1) % orientations.length;
        return orientations[previousIndex];

    }
}
