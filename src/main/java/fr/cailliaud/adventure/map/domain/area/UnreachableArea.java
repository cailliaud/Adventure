package fr.cailliaud.adventure.map.domain.area;

public class UnreachableArea extends Area {

    public UnreachableArea() {
        super(false);
    }

    @Override
    public void visit() {
        // Do nothing
    }

    @Override
    public void leave() {
        // Do nothing
    }
}
